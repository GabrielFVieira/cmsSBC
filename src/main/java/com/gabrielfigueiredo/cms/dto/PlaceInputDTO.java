package com.gabrielfigueiredo.cms.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "Place")
public class PlaceInputDTO {

	@NotBlank
	private String nome;

	@NotBlank
	private String localizacao;

	@NotNull
	private Integer capacidade;

	private List<String> recursos;
}
