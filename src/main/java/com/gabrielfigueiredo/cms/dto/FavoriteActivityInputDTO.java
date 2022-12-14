package com.gabrielfigueiredo.cms.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "FavoriteActivity")
public class FavoriteActivityInputDTO {
	@NotNull
	private Integer idAtividade;
}