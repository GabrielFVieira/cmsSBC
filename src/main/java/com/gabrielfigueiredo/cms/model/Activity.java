package com.gabrielfigueiredo.cms.model;

import java.sql.Time;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.gabrielfigueiredo.cms.dto.ActivityInputDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="atividade")
@NoArgsConstructor
public class Activity {
	@Id
	@GeneratedValue
	private Integer id;

	private String nome;

	private ActivityType tipo;

	private String descricao;

	private Date data;

	private Time horarioInicial;

	private Time horarioFinal;

	public Activity(ActivityInputDTO input) {
		this.nome = input.getNome();
		this.tipo = input.getTipo();
		this.descricao = input.getDescricao();
		this.data = input.getData();
		this.horarioInicial = input.getHorarioInicial();
		this.horarioFinal = input.getHorarioFinal();
	}

	public void Merge(ActivityInputDTO input) {
		this.nome = input.getNome();
		this.tipo = input.getTipo();
		this.descricao = input.getDescricao();
		this.data = input.getData();
		this.horarioInicial = input.getHorarioInicial();
		this.horarioFinal = input.getHorarioFinal();
	}

	@OneToOne
	@JoinColumn(name = "fk_local")
	private Place local;

	@ManyToOne
	private Edition edicao;

	@ManyToMany(mappedBy = "atividadesFavoritas")
	private List<User> usuariosQueFavoritaram;

	public void Validate() {
		return;
	}
}
