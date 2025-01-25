package se.kth.ki.waitapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public abstract class BaseDTO {
    private Long id;
}
