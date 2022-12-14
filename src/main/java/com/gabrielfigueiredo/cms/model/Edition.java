package com.gabrielfigueiredo.cms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

import com.gabrielfigueiredo.cms.dto.EditionInputDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="edicao", uniqueConstraints = @UniqueConstraint(columnNames = {"numero", "fk_evento"}))
@NoArgsConstructor
public class Edition {
	@Id
	@GeneratedValue
	private Integer id;

	@NonNull
	private Integer numero;

	@NonNull
	private Integer ano;

	@NonNull
	private String cidade;

	@NonNull
	private Date dataInicial;

	@NonNull
	private Date dataFinal;

	@OneToOne
	@JoinColumn(name = "fk_organizador")
	private User organizador;

	@NonNull
	@ManyToOne
	@JoinColumn(name = "fk_evento")
	private Event evento;

	@OneToMany(mappedBy = "edicao")
	private List<Activity> atividades;

	public Edition(EditionInputDTO input) {
		Merge(input);
	}

	public void Merge(EditionInputDTO input) {
		this.ano = input.getAno();
		this.numero = input.getNumero();
		this.cidade = input.getCidade();
		this.dataInicial = input.getDataInicial();
		this.dataFinal = input.getDataFinal();
	}

	public void Validate() {
		return;
	}
}
