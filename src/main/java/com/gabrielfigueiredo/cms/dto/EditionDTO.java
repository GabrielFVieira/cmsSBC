package com.gabrielfigueiredo.cms.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gabrielfigueiredo.cms.model.Edition;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "Edition")
@JsonInclude(Include.NON_EMPTY)
public class EditionDTO {
    // @ApiModelProperty(value = "TO BE DEFINED", required = false)
	private Integer id;
	private Integer numero;
	private Integer ano;
	private String cidade;
	private Date dataInicial;
	private Date dataFinal;

    public EditionDTO(Edition input) {
		this.id = input.getId();
		this.ano = input.getAno();
		this.numero = input.getNumero();
		this.cidade = input.getCidade();
		this.dataInicial = input.getDataInicial();
		this.dataFinal = input.getDataFinal();
	}
}