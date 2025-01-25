package se.kth.ki.waitapp.core.interfaces;

import java.util.List;
import java.util.Optional;

import io.smallrye.mutiny.Uni;
import se.kth.ki.waitapp.core.model.BaseModel;
import se.kth.ki.waitapp.dto.BaseDTO;

public interface IGenericService<T extends BaseModel, TDTO extends BaseDTO> {

    // Retrieve all entities as DTOs
    Uni<List<TDTO>> findAll();

    // Retrieve an entity by its ID, wrapped in Optional
    Uni<Optional<TDTO>> findById(Long id);

    // Create a new entity from DTO and return the created DTO
    Uni<TDTO> create(TDTO dto);

    // Update an existing entity by ID and return the updated DTO
    Uni<Optional<TDTO>> update(Long id, TDTO dto);

    // Delete an entity by its ID and return success status
    Uni<Boolean> delete(Long id);

    // Check if an entity exists by ID
    Uni<Boolean> existsById(Long id);
}
