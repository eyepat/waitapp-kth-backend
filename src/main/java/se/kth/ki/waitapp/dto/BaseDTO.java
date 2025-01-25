package se.kth.ki.waitapp.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public abstract class BaseDTO {
    private UUID id;
}
