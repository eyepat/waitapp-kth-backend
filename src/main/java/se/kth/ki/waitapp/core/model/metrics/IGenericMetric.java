package se.kth.ki.waitapp.core.model.metrics;

import se.kth.ki.waitapp.core.model.IBaseModel;

public interface IGenericMetric<T> extends IBaseModel {
    T getValue();
    void setValue(T value);
}
