package com.gabrielfigueiredo.cms.exception;

import java.util.ArrayList;
import java.util.List;

import com.gabrielfigueiredo.cms.dto.InvalidFieldDTO;

import lombok.Getter;

public class InvalidParamException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_MESSAGE = "Invalid parameter(s)";

	@Getter
	private List<InvalidFieldDTO> invalidFields;

	public InvalidParamException(InvalidFieldDTO... fields) {
		super(DEFAULT_MESSAGE);

		if (fields != null) {
			this.invalidFields = new ArrayList<>();
			for (InvalidFieldDTO field : fields) {
				this.invalidFields.add(field);
			}
		}
	}
}
