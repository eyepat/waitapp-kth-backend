package se.kth.ki.waitapp.controller;

import se.kth.ki.waitapp.core.interfaces.IGenericService;

public class GenericMetricController<TDTO, TSERVICE extends IGenericService<?, TDTO>>
        extends GenericController<TDTO, TSERVICE> {

}
