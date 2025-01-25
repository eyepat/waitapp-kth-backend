package se.kth.ki.waitapp.core.interfaces;

import se.kth.ki.waitapp.core.model.BaseModel;
import se.kth.ki.waitapp.dto.BaseDTO;

public interface IGenericMetricService<T extends BaseModel, TDTO extends BaseDTO> extends IGenericService<T, TDTO> {
}