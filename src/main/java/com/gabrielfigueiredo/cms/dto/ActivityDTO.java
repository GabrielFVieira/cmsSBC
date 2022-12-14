package com.gabrielfigueiredo.cms.dto;

import java.sql.Time;
import java.sql.Date;
import java.util.List;

import com.gabrielfigueiredo.cms.model.Activity;
import com.gabrielfigueiredo.cms.model.ActivityType;
import com.gabrielfigueiredo.cms.model.User;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "Activity")
public class ActivityDTO {
	private Integer id;
	private String nome;
	private ActivityType tipo;
	private String descricao;
	private Date data;
	private Time horarioInicial;
	private Time horarioFinal;

	public ActivityDTO(Activity activity) {
		this.nome = activity.getNome();
		this.tipo = activity.getTipo();
		this.descricao = activity.getDescricao();
		this.data = activity.getData();
		this.horarioInicial = activity.getHorarioInicial();
		this.horarioFinal = activity.getHorarioFinal();
	}
}