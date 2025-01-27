package se.kth.ki.waitapp.core.interfaces.service;

import java.util.Optional;

import io.smallrye.mutiny.Uni;
import se.kth.ki.waitapp.core.model.metrics.IGenericMetric;
import se.kth.ki.waitapp.dto.IBaseDTO;

public interface IGenericMetricService<T extends IGenericMetric<?>, TDTO extends IBaseDTO> extends IGenericService<T, TDTO> {
    Uni<Optional<TDTO>> latest();
}