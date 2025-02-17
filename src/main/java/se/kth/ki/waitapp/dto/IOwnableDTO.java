package se.kth.ki.waitapp.dto;

import java.util.UUID;

public interface IOwnableDTO extends IBaseDTO {
    UUID getOwner();

    void setOwner(UUID owner);
}
