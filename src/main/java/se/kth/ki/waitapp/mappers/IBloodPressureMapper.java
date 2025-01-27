package se.kth.ki.waitapp.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;

import se.kth.ki.waitapp.core.model.metrics.BloodPressure;
import se.kth.ki.waitapp.dto.metrics.BloodPressureDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface IBloodPressureMapper extends IGenericMapper<BloodPressure, BloodPressureDTO> {

}
