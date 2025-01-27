package se.kth.ki.waitapp.core.model;

import java.util.UUID;

public interface IBaseModel {
    Long getId();
    void setId(Long id);
    UUID getOwner();
    void setOwner(UUID owner);
    boolean isPersistent();
}
