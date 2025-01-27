package se.kth.ki.waitapp.core.interfaces.repository;

import se.kth.ki.waitapp.core.model.IBaseFHIRModel;

public interface IGenericFHIRRepository<T extends IBaseFHIRModel> extends IGenericRepository<T> {
}
