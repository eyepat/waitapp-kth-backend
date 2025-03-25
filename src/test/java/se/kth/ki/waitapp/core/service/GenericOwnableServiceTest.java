package se.kth.ki.waitapp.core.service;

import se.kth.ki.waitapp.core.interfaces.repository.IGenericRepository;
import se.kth.ki.waitapp.core.interfaces.service.IGenericOwnableService;
import se.kth.ki.waitapp.core.model.IOwnableModel;
import se.kth.ki.waitapp.dto.IOwnableDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;

public abstract class GenericOwnableServiceTest<T extends IOwnableModel, TDTO extends IOwnableDTO, 
            TSERVICE extends IGenericOwnableService<T, TDTO>, 
            TMAPPER extends IGenericMapper<T, TDTO>, 
            TREPO extends IGenericRepository<T>> 
            extends GenericServiceTest<T, TDTO, TSERVICE, TMAPPER, TREPO> {
            
                protected GenericOwnableServiceTest(Class<T> modelClass, Class<TDTO> dtoClass, Class<TREPO> repositoryClass, Class<TMAPPER> mapperClass) {
                    super(modelClass, dtoClass, repositoryClass, mapperClass);
                }
    
}
