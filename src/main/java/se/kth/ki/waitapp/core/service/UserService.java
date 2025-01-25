package se.kth.ki.waitapp.core.service;

import java.util.UUID;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.IUserService;
import se.kth.ki.waitapp.core.model.user.User;
import se.kth.ki.waitapp.dto.metrics.BloodPressureDTO;
import se.kth.ki.waitapp.dto.metrics.HeightDTO;
import se.kth.ki.waitapp.dto.metrics.WaistSizeDTO;
import se.kth.ki.waitapp.dto.metrics.WeightDTO;
import se.kth.ki.waitapp.dto.user.OnboardingDTO;
import se.kth.ki.waitapp.dto.user.UserDTO;
import se.kth.ki.waitapp.mappers.IBloodPressureMapper;
import se.kth.ki.waitapp.mappers.IHeightMapper;
import se.kth.ki.waitapp.mappers.IUserMapper;
import se.kth.ki.waitapp.mappers.IWaistSizeMapper;
import se.kth.ki.waitapp.mappers.IWeightMapper;

@ApplicationScoped
public class UserService extends GenericService<User, UserDTO> implements IUserService {

    @Inject
    IHeightMapper heightMapper;
    @Inject
    IWeightMapper weightMapper;
    @Inject
    IWaistSizeMapper waistSizeMapper;
    @Inject
    IBloodPressureMapper bloodPressureMapper;

    @Inject
    public UserService(IUserMapper mapper, SecurityIdentity identity) {
        super(mapper, identity);
    }

    @Override
    public Uni<UserDTO> onboard(OnboardingDTO dto) {
        if (dto.getEmail() == null || dto.getFullName() == null) {
            return Uni.createFrom().failure(new IllegalArgumentException("Email, and fullName are required"));
        }

        String sub = jwt.getSubject();
        var owner = UUID.fromString(sub);

        return Panache.withSession(() -> User.<User>find("owner = ?1", owner).firstResult()
                .onItem().transformToUni(existingUser -> {
                    if (existingUser != null && existingUser.getOnboarded()) {
                        return Uni.createFrom().failure(new IllegalStateException("User is already onboarded"));
                    }

                    User user = (existingUser == null) ? User.builder()
                            .email(dto.getEmail())
                            .fullName(dto.getFullName())
                            .birthDate(dto.getBirthDate())
                            .gender(dto.getGender())
                            .ablationDate(dto.getAblationDate() != null ? dto.getAblationDate() : null)
                            .owner(owner)
                            .onboarded(true)
                            .build()
                            : User.builder()
                                    .email(existingUser != null && existingUser.getEmail() != null
                                            ? existingUser.getEmail()
                                            : dto.getEmail())
                                    .fullName(dto.getFullName())
                                    .birthDate(dto.getBirthDate())
                                    .gender(dto.getGender())
                                    .ablationDate(dto.getAblationDate() != null ? dto.getAblationDate()
                                            : null)
                                    .onboarded(true)
                                    .owner(existingUser != null ? existingUser.getOwner()
                                            : UUID.fromString(jwt.getSubject()))
                                    .build();

                    var height = heightMapper.toEntity(HeightDTO.builder().value(dto.getHeight()).owner(owner).build());
                    var weight = weightMapper.toEntity(WeightDTO.builder().value(dto.getWeight()).owner(owner).build());
                    var waistSize = waistSizeMapper
                            .toEntity(WaistSizeDTO.builder().value(dto.getWaistSize()).owner(owner).build());
                    var bloodPressure = bloodPressureMapper
                            .toEntity(BloodPressureDTO.builder().value(dto.getBloodPressure()).owner(owner).build());

                    return Panache.withTransaction(() -> user.persistAndFlush()
                            .chain((savedEntity) -> {
                                var id = ((User) savedEntity).getId();
                                height.setUserID(id);
                                height.setValue(dto.getHeight());
                                weight.setUserID(id);
                                weight.setValue(dto.getWeight());
                                waistSize.setUserID(id);
                                waistSize.setValue(dto.getWaistSize());
                                bloodPressure.setUserID(id);
                                bloodPressure.setValue(dto.getBloodPressure());
                                return height.persistAndFlush()
                                        .chain(() -> weight.persistAndFlush())
                                        .chain(() -> waistSize.persistAndFlush())
                                        .chain(() -> bloodPressure.persistAndFlush())
                                        .replaceWith(mapper.toDTO(((User) savedEntity)));
                            }));
                }));
    }

}
