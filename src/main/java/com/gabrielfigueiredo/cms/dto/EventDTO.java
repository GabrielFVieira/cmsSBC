package com.gabrielfigueiredo.cms.dto;

import com.gabrielfigueiredo.cms.model.Event;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "Event")
@JsonInclude(Include.NON_EMPTY)
public class EventDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private String sigla;
    private String caminho;

    private List<EditionDTO> editions;

    public EventDTO(Event input) {
        this.id = input.getId();
		this.nome = input.getNome();
		this.sigla = input.getSigla();
		this.descricao = input.getDescricao();
		this.caminho = input.getCaminho();
	}
}
