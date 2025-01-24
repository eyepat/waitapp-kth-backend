package se.kth.ki.waitapp.core.interfaces;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T, TDTO> {
    List<TDTO> list();

    Optional<TDTO> byId(Long id);

    boolean delete(Long id);

    Optional<TDTO> update(Long id, TDTO updated);
}
