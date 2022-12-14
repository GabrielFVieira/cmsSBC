package com.gabrielfigueiredo.cms.dto;

import java.time.LocalTime;
import java.sql.Date;
import com.gabrielfigueiredo.cms.model.Activity;
import com.gabrielfigueiredo.cms.model.ActivityType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "Activity")
@JsonInclude(Include.NON_EMPTY)
public class ActivityDTO {
	private Integer id;
	private String nome;
	private ActivityType tipo;
	private String descricao;
	private Date data;
	private LocalTime horarioInicial;
	private LocalTime horarioFinal;
	private PlaceDTO place;

	public ActivityDTO(Activity activity) {
		this.nome = activity.getNome();
		this.tipo = activity.getTipo();
		this.descricao = activity.getDescricao();
		this.data = activity.getData();
		this.horarioInicial = activity.getHorarioInicial();
		this.horarioFinal = activity.getHorarioFinal();
	}
}