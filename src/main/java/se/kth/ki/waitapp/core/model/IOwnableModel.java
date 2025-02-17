package se.kth.ki.waitapp.core.model;

import java.util.UUID;

public interface IOwnableModel extends IBaseModel {
    UUID getOwner();

    void setOwner(UUID owner);
}
