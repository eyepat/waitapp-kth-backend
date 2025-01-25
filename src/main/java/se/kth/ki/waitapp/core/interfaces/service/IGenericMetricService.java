package se.kth.ki.waitapp.core.interfaces.service;

import java.util.Optional;

import io.smallrye.mutiny.Uni;
import se.kth.ki.waitapp.core.model.BaseModel;
import se.kth.ki.waitapp.dto.BaseDTO;

public interface IGenericMetricService<T extends BaseModel, TDTO extends BaseDTO> extends IGenericService<T, TDTO> {
    Uni<Optional<TDTO>> latest();
}