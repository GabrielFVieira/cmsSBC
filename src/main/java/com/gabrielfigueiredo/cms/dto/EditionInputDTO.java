package com.gabrielfigueiredo.cms.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "EditionInput")
public class EditionInputDTO {
    // @ApiModelProperty(value = "TO BE DEFINED", required = false)

	@NotNull
	private Integer numero;

	@NotNull
	private Integer ano;

	@NotBlank
	private String cidade;

	@NotNull
	private Date dataInicial;

	@NotNull
	private Date dataFinal;
}