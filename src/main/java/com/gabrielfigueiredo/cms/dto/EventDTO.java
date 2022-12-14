package com.gabrielfigueiredo.cms.dto;

import com.gabrielfigueiredo.cms.model.Event;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "Event")
public class EventDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private String sigla;
    private String caminho;

    public EventDTO(Event input) {
        this.id = input.getId();
		this.nome = input.getNome();
		this.sigla = input.getSigla();
		this.descricao = input.getDescricao();
		this.caminho = input.getCaminho();
	}
}
