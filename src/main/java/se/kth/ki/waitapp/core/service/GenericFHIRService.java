package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.interfaces.repository.IGenericFHIRRepository;
import se.kth.ki.waitapp.core.model.IBaseFHIRModel;
import se.kth.ki.waitapp.dto.IBaseFHIRDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;

@NoArgsConstructor
public abstract class GenericFHIRService<T extends IBaseFHIRModel, TDTO extends IBaseFHIRDTO>
        extends GenericService<T, TDTO> {

    public GenericFHIRService(IGenericMapper<T, TDTO> mapper, IGenericFHIRRepository<T> repository,
            SecurityIdentity identity) {
        super(mapper, repository, identity);
    }
}
