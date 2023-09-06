package com.example.demo2.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoRequest {
    @NotNull(message = "Mandatory userId")
    private Long userId;
    @NotBlank(message = "Mandatory title")
    private String title;

    private Boolean completed;
}
