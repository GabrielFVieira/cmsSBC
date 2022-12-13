package com.gabrielfigueiredo.cms.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "EventInput")
public class EventInputDTO {
    private String nome;
    private String descricao;
    private String sigla;
    private String caminho;
}