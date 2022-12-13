package com.gabrielfigueiredo.cms.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "EventInput")
public class EventInputDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private String sigla;

    @NotBlank
    private String caminho;
}