package se.kth.ki.waitapp.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;

import se.kth.ki.waitapp.core.model.metrics.WaistSize;
import se.kth.ki.waitapp.dto.metrics.WaistSizeDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface IWaistSizeMapper extends IGenericMapper<WaistSize, WaistSizeDTO> {
}
