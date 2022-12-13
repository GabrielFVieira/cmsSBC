package com.gabrielfigueiredo.cms.utils;

import java.util.Optional;

import com.gabrielfigueiredo.cms.dto.InvalidFieldDTO;

public class Validation {
    public static InvalidFieldDTO validateRequired(String fieldValue, String fieldName) {
        if (fieldValue == "" || fieldValue == null) {
            return new InvalidFieldDTO(fieldName, "Field '"+fieldName+"' must not be empty");
        }

        return null;
    }
}
