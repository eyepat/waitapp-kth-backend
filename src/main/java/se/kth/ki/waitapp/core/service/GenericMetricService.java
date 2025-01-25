package se.kth.ki.waitapp.core.service;

import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.interfaces.IGenericMetricService;
import se.kth.ki.waitapp.core.model.BaseModel;
import se.kth.ki.waitapp.dto.BaseDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;

@NoArgsConstructor
public abstract class GenericMetricService<T extends BaseModel, TDTO extends BaseDTO> extends GenericService<T, TDTO>
        implements IGenericMetricService<T, TDTO> {

    public GenericMetricService(IGenericMapper<T, TDTO> mapper) {
        super(mapper);
    }

}
