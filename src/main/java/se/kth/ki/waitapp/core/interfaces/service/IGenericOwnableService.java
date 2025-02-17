package se.kth.ki.waitapp.core.interfaces.service;

import se.kth.ki.waitapp.core.model.IOwnableModel;
import se.kth.ki.waitapp.dto.IOwnableDTO;

public interface IGenericOwnableService<T extends IOwnableModel, TDTO extends IOwnableDTO>
        extends IGenericService<T, TDTO> {
}
