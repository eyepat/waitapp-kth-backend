package se.kth.ki.waitapp.core.service;

import se.kth.ki.waitapp.core.interfaces.repository.IGenericFHIRRepository;
import se.kth.ki.waitapp.core.interfaces.service.IGenericFHIRService;
import se.kth.ki.waitapp.core.model.IBaseFHIRModel;
import se.kth.ki.waitapp.dto.IBaseFHIRDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;

public abstract class GenericFHIRServiceTest<T extends IBaseFHIRModel, TDTO extends IBaseFHIRDTO, 
            TSERVICE extends IGenericFHIRService<T, TDTO>, 
            TMAPPER extends IGenericMapper<T, TDTO>, 
            TREPO extends IGenericFHIRRepository<T>> 
            extends GenericServiceTest<T, TDTO, TSERVICE, TMAPPER, TREPO> {
            
                protected GenericFHIRServiceTest(Class<T> modelClass, Class<TDTO> dtoClass, Class<TREPO> repositoryClass, Class<TMAPPER> mapperClass) {
                    super(modelClass, dtoClass, repositoryClass, mapperClass);
                }
}
