package se.kth.ki.waitapp.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;

import se.kth.ki.waitapp.core.model.metrics.Weight;
import se.kth.ki.waitapp.dto.metrics.WeightDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface IWeightMapper extends IGenericMapper<Weight, WeightDTO> {
}
