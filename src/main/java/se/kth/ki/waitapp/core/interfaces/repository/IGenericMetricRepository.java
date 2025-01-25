package se.kth.ki.waitapp.core.interfaces.repository;

import se.kth.ki.waitapp.core.model.metrics.GenericMetric;

public interface IGenericMetricRepository<T extends GenericMetric<?>> extends IGenericRepository<T> {
}
