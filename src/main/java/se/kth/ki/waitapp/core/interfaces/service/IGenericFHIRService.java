package se.kth.ki.waitapp.core.interfaces.service;

import se.kth.ki.waitapp.core.model.IBaseFHIRModel;
import se.kth.ki.waitapp.dto.IBaseFHIRDTO;

public interface IGenericFHIRService<T extends IBaseFHIRModel, TDTO extends IBaseFHIRDTO> extends IGenericService<T, TDTO>{
}
