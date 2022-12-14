package com.gabrielfigueiredo.cms.dto;

import java.sql.Time;
import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.gabrielfigueiredo.cms.model.ActivityType;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "ActivityInput")
public class ActivityInputDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private ActivityType tipo;

    @NotBlank
    private String descricao;

    @NotBlank
    private Date data;

    @NotBlank
	private Time horarioInicial;
	
    @NotBlank
	private Time horarioFinal;
}