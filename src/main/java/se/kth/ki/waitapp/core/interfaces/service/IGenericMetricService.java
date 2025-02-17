package se.kth.ki.waitapp.core.interfaces.service;

import java.util.Optional;

import io.smallrye.mutiny.Uni;
import se.kth.ki.waitapp.core.model.metrics.IGenericMetric;
import se.kth.ki.waitapp.dto.IOwnableDTO;

public interface IGenericMetricService<T extends IGenericMetric<?>, TDTO extends IOwnableDTO>
        extends IGenericOwnableService<T, TDTO> {
    Uni<Optional<TDTO>> latest();
}