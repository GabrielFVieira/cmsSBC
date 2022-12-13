package com.gabrielfigueiredo.cms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

import com.gabrielfigueiredo.cms.dto.EventInputDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="evento", uniqueConstraints = @UniqueConstraint(columnNames = {"caminho"}))
@NoArgsConstructor
public class Event {
	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String nome;

	@NonNull
	private String sigla;

	@NonNull
	private String descricao;

	@NonNull
	private String caminho;

	@OneToMany(mappedBy = "evento")
	private List<Edition> edicao;

	public Event(EventInputDTO input) {
		this.nome = input.getNome();
		this.sigla = input.getSigla();
		this.descricao = input.getDescricao();
		this.caminho = input.getCaminho();
	}
}
