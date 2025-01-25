package se.kth.ki.waitapp.mappers;

import org.mapstruct.Mapper;

import se.kth.ki.waitapp.core.model.metrics.Steps;
import se.kth.ki.waitapp.dto.metrics.StepsDTO;

@Mapper(componentModel = "cdi")
public interface IStepsMapper extends IGenericMapper<Steps, StepsDTO> {
}
