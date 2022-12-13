package com.gabrielfigueiredo.cms.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="atividade")
@NoArgsConstructor
public class Activity {
	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private ActivityType tipo;

	private String descricao;

	private Date data;

	private Time horarioInicial;

	private Time horarioFinal;

	@OneToOne
	@JoinColumn(name = "fk_local")
	private Place local;

	@ManyToOne
	private Edition edicao;

	@ManyToMany(mappedBy = "atividadesFavoritas")
	private List<User> usuariosQueFavoritaram;
}
