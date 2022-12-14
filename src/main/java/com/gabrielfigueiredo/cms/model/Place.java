package com.gabrielfigueiredo.cms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

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

	@NonNull
	@ElementCollection
    @CollectionTable(name = "espaco_recursos", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "recursos")
	private List<String> recursos;


}
