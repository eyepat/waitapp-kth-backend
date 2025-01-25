package se.kth.ki.waitapp.mappers;

import org.mapstruct.Mapper;

import se.kth.ki.waitapp.core.model.metrics.Height;
import se.kth.ki.waitapp.dto.metrics.HeightDTO;

@Mapper(componentModel = "cdi")
public interface IHeightMapper extends IGenericMapper<Height, HeightDTO> {
}
