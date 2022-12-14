package com.gabrielfigueiredo.cms.dto;

import java.time.LocalTime;
import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.gabrielfigueiredo.cms.model.ActivityType;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "ActivityInput")
public class ActivityInputDTO {

    @NotBlank
    private String nome;

    @NotNull
    private ActivityType tipo;

    @NotBlank
    private String descricao;

    @NotNull
    private Date data;

    @NotNull
	private LocalTime horarioInicial;

    @NotNull
	private LocalTime horarioFinal;

    @NotNull
    private Integer idLocal;

    @NotNull
    private Integer idEdicao;
}