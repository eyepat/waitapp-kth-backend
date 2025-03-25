package se.kth.ki.waitapp.core.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.function.Function;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.hibernate.reactive.mutiny.Mutiny;
import org.hibernate.reactive.mutiny.Mutiny.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import io.quarkus.hibernate.reactive.panache.PanacheQuery;
import io.quarkus.test.Mock;
import io.smallrye.mutiny.Uni;
import se.kth.ki.waitapp.core.interfaces.repository.IGenericMetricRepository;
import se.kth.ki.waitapp.core.interfaces.repository.IUserRepository;
import se.kth.ki.waitapp.core.interfaces.service.IGenericMetricService;
import se.kth.ki.waitapp.core.model.metrics.IGenericMetric;
import se.kth.ki.waitapp.core.model.user.User;
import se.kth.ki.waitapp.dto.metrics.IGenericMetricDTO;
import se.kth.ki.waitapp.dto.user.UserDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;
import se.kth.ki.waitapp.repository.UserRepository;

public abstract class GenericMetricServiceTest<TVALUE, T extends IGenericMetric<TVALUE>, TDTO extends IGenericMetricDTO<TVALUE>, 
            TSERVICE extends IGenericMetricService<T, TDTO>, 
            TMAPPER extends IGenericMapper<T, TDTO>, 
            TREPO extends IGenericMetricRepository<T>> 
            extends GenericOwnableServiceTest<T, TDTO, TSERVICE, TMAPPER, TREPO> {

                @Mock
                protected IUserRepository userRepository;
            
                protected GenericMetricServiceTest(Class<T> modelClass, Class<TDTO> dtoClass, Class<TREPO> repositoryClass, Class<TMAPPER> mapperClass) {
                    super(modelClass, dtoClass, repositoryClass, mapperClass);
                }

                protected abstract TSERVICE createService(SessionFactory sessionFactory, JsonWebToken jwt, IUserRepository userRepo);

                @Override
                protected TSERVICE createService(SessionFactory sessionFactory, JsonWebToken jwt)  {
                    if (userRepository == null) {
                        this.userRepository = Mockito.mock(UserRepository.class);
                    }
                    return createService(sessionFactory, jwt, this.userRepository);
                }

                @BeforeEach
                void setUpUser() {
                    if (mockUUID == null) {
                        setup();
                    }

                    @SuppressWarnings("unchecked")
                    PanacheQuery<User> mockQuery = mock(PanacheQuery.class);
                    User mockUser = new User();
                    mockUser.setOwner(mockUUID);

                    when(userRepository.find("owner = ?1", mockUUID)).thenReturn(mockQuery);
                    when(userRepository.find("WHERE owner = ?1", mockUUID)).thenReturn(mockQuery);
                    when(userRepository.find("WHERE owner = ?1 AND id = ?2", mockUUID, 1L)).thenReturn(mockQuery);
                    when(mockQuery.firstResult()).thenReturn(Uni.createFrom().item(mockUser));

                    when(sf.withSession(any())).thenAnswer(invocation -> {
                        Function<Mutiny.Session, Uni<?>> work = invocation.getArgument(0);
                        
                        if (work != null) {
                            Mutiny.Session mockSession = mock(Mutiny.Session.class);
                            
                            return work.apply(mockSession);
                        } else {
                            return Uni.createFrom().failure(new NullPointerException("Work function is null"));
                        }
                    });

                    when(service.findAll()).thenAnswer(invocation -> {
                        return Uni.createFrom().item(List.of(UserDTO.builder().owner(mockUUID).build()));
                    });
                }

}
