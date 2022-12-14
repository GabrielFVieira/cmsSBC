package com.gabrielfigueiredo.cms.dto;

import java.util.List;

import com.gabrielfigueiredo.cms.model.Place;
import com.gabrielfigueiredo.cms.model.User;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "Place")
public class PlaceDTO {
	private Integer id;
	private String nome;
	private String localizacao;
	private int capacidade;
	private List<String> recursos;

	public PlaceDTO(Place place) {
		this.id = place.getId();
		this.nome = place.getNome();
		this.localizacao = place.getLocalizacao();
		this.capacidade = place.getCapacidade();
		this.recursos = place.getRecursos();
	}
}
