package se.kth.ki.waitapp.mappers;

import java.util.Optional;

import org.mapstruct.MappingTarget;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface IGenericMapper<E, DTO> {
    DTO toDTO(E entity);

    E toEntity(DTO dto);

    default Optional<E> mapOptionalToEntity(Optional<DTO> value) {
        return value.map(this::toEntity);
    }

    default Optional<DTO> mapOptionalToDTOFromEntity(Optional<E> value) {
        return value.map(this::toDTO);
    }

    void updateEntity(DTO dto, @MappingTarget E existingEntity);
}