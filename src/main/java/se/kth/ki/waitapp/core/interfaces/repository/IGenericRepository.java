package se.kth.ki.waitapp.core.interfaces.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import se.kth.ki.waitapp.core.model.IBaseModel;

public interface IGenericRepository<T extends IBaseModel> extends PanacheRepository<T> {
}