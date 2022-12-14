package com.gabrielfigueiredo.cms.dto;

import java.util.List;

import com.gabrielfigueiredo.cms.model.Place;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "Place")
@JsonInclude(Include.NON_EMPTY)
public class PlaceDTO {
	private Integer id;
	private String nome;
	private String localizacao;
	private Integer capacidade;
	private List<String> recursos;

	public PlaceDTO(Place place) {
		this.id = place.getId();
		this.nome = place.getNome();
		this.localizacao = place.getLocalizacao();
		this.capacidade = place.getCapacidade();
		this.recursos = place.getRecursos();
	}
}
