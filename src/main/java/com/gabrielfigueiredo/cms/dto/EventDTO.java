package com.gabrielfigueiredo.cms.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "Event")
public class EventDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String sigla;
    private String caminho;
}
