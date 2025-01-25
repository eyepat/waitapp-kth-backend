package se.kth.ki.waitapp.mappers;

import org.mapstruct.Mapper;

import se.kth.ki.waitapp.core.model.metrics.Weight;
import se.kth.ki.waitapp.dto.metrics.WeightDTO;

@Mapper(componentModel = "cdi")
public interface IWeightMapper extends IGenericMapper<Weight, WeightDTO> {
}
