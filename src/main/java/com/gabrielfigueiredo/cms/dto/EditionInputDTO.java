package com.gabrielfigueiredo.cms.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "EditionInput")
public class EditionInputDTO {
    // @ApiModelProperty(value = "TO BE DEFINED", required = false)
	private Integer numero;
	private Integer ano;
	private String cidade;
	private Date dataInicial;
	private Date dataFinal;
}