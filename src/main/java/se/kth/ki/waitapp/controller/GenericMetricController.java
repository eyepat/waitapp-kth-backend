package se.kth.ki.waitapp.controller;

import se.kth.ki.waitapp.core.interfaces.IGenericService;
import se.kth.ki.waitapp.dto.BaseDTO;

public abstract class GenericMetricController<TDTO extends BaseDTO, TSERVICE extends IGenericService<?, TDTO>>
                extends GenericController<TDTO, TSERVICE> {

        public GenericMetricController(TSERVICE service) {
                super(service);
        }

}
