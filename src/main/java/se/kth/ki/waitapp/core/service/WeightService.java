package se.kth.ki.waitapp.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.IWeightService;
import se.kth.ki.waitapp.core.model.metrics.Weight;
import se.kth.ki.waitapp.dto.metrics.WeightDTO;
import se.kth.ki.waitapp.mappers.IWeightMapper;

@ApplicationScoped
public class WeightService extends GenericService<Weight, WeightDTO> implements IWeightService {

    @Inject
    public WeightService(IWeightMapper mapper) {
        super(mapper);
    }

}
