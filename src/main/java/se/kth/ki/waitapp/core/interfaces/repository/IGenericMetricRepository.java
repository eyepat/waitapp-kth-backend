package se.kth.ki.waitapp.core.interfaces.repository;

import se.kth.ki.waitapp.core.model.metrics.IGenericMetric;

public interface IGenericMetricRepository<T extends IGenericMetric<?>> extends IGenericRepository<T> {
}
