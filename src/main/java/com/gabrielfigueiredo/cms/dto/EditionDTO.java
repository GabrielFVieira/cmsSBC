package com.gabrielfigueiredo.cms.dto;

import java.util.Date;

import com.gabrielfigueiredo.cms.model.Edition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Edition")
public class EditionDTO {
    // @ApiModelProperty(value = "TO BE DEFINED", required = false)
	private Long id;
	private Integer numero;
	private Integer ano;
	private String cidade;
	private Date dataInicial;
	private Date dataFinal;

    public EditionDTO(Edition input) {
		this.ano = input.getAno();
		this.numero = input.getNumero();
		this.cidade = input.getCidade();
		this.dataInicial = input.getDataInicial();
		this.dataFinal = input.getDataFinal();
	}
}