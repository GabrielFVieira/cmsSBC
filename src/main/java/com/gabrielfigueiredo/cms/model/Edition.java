package com.gabrielfigueiredo.cms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import com.gabrielfigueiredo.cms.dto.EditionInputDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="edicao")
@NoArgsConstructor
public class Edition {
	@Id
	@GeneratedValue
	private Long id;

	private Integer numero;

	private Integer ano;

	private String cidade;

	private Date dataInicial;

	private Date dataFinal;

	@OneToOne
	@JoinColumn(name = "fk_organizador")
	private User organizador;

	@ManyToOne
	@JoinColumn(name = "fk_evento")
	private Event evento;

	@OneToMany(mappedBy = "edicao")
	private List<Activity> atividades;

	public Edition(EditionInputDTO input) {
		this.ano = input.getAno();
		this.numero = input.getNumero();
		this.cidade = input.getCidade();
		this.dataInicial = input.getDataInicial();
		this.dataFinal = input.getDataFinal();
	}
}
