package se.kth.ki.waitapp.core.interfaces.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import se.kth.ki.waitapp.core.model.BaseModel;

public interface IGenericRepository<T extends BaseModel> extends PanacheRepository<T> {
}