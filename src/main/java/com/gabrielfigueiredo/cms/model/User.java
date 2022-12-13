package com.gabrielfigueiredo.cms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="usuario")
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private Long id;

	private String login;

	private String email;

	private String nome;

	private String afiliacao;

	@OneToOne(mappedBy="organizador")
	private Edition edition;

	@ManyToMany
	@JoinTable(
		name = "assoc_usuario_atividade",
		joinColumns = @JoinColumn(name="fk_usuario"),
		inverseJoinColumns = @JoinColumn(name="fk_atividade")
	)
	private List<Activity> atividadesFavoritas;
}
