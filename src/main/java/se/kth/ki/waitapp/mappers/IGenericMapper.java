package se.kth.ki.waitapp.mappers;

import java.util.Optional;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import se.kth.ki.waitapp.core.model.IBaseModel;
import se.kth.ki.waitapp.dto.IBaseDTO;

public interface IGenericMapper<E extends IBaseModel, DTO extends IBaseDTO> {
    @Mapping(target = "id", source = "id")
    DTO toDTO(E entity);

    @Mapping(target = "id", source = "id")
    E toEntity(DTO dto);

    default Optional<E> mapOptionalToEntity(Optional<DTO> value) {
        return value.map(this::toEntity);
    }

    default Optional<DTO> mapOptionalToDTOFromEntity(Optional<E> value) {
        return value.map(this::toDTO);
    }

    void updateEntity(DTO dto, @MappingTarget E existingEntity);
}