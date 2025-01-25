package se.kth.ki.waitapp.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.IRAPAService;
import se.kth.ki.waitapp.core.model.metrics.RAPA;
import se.kth.ki.waitapp.dto.metrics.RAPADTO;
import se.kth.ki.waitapp.mappers.IRAPAMapper;

@ApplicationScoped
public class RAPAService extends GenericMetricService<RAPA, RAPADTO> implements IRAPAService {

    @Inject
    public RAPAService(IRAPAMapper mapper) {
        super(mapper);
    }

}
