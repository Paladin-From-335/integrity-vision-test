package com.github.integrityvision.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    @NonNull
    @JsonProperty("words")
    private String[] wordlist;
}
