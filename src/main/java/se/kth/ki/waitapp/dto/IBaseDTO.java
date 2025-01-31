package se.kth.ki.waitapp.dto;

import java.util.UUID;

public interface IBaseDTO {
    Long getId();
    void setId(Long id);
    UUID getOwner();
    void setOwner(UUID owner);
}
