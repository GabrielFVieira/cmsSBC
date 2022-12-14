package com.gabrielfigueiredo.cms.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "OrganizerInput")
public class EditionOrganizerInputDTO {
    // @ApiModelProperty(value = "TO BE DEFINED", required = false)

	@NotNull
	private Integer idOrganizador;
}