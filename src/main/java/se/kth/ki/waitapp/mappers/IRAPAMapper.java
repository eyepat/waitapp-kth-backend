package se.kth.ki.waitapp.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;

import se.kth.ki.waitapp.core.model.metrics.RAPA;
import se.kth.ki.waitapp.dto.metrics.RAPADTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface IRAPAMapper extends IGenericMapper<RAPA, RAPADTO> {
}
