package com.gabrielfigueiredo.cms.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.gabrielfigueiredo.cms.dto.PlaceInputDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="espaco")
@NoArgsConstructor
public class Place {
	@Id
	@GeneratedValue
	private Integer id;

	@NonNull
	private String nome;

	@NonNull
	private String localizacao;

	@NonNull
	private int capacidade;

	@ElementCollection
    @CollectionTable(name = "espaco_recursos", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "recursos")
	private List<String> recursos;

	public Place(PlaceInputDTO input) {
		Merge(input);
	}

	public void Merge(PlaceInputDTO input) {
		this.nome = input.getNome();
		this.localizacao = input.getLocalizacao();
		this.capacidade = input.getCapacidade();
		this.recursos = input.getRecursos();
	}

	public void Validate() {
		return;
	}
}
