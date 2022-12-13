package com.gabrielfigueiredo.cms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidFieldDTO {
    private String field;
    private String reason;
}
