package com.gabrielfigueiredo.cms.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "OrganizerInput")
public class EditionOrganizerInputDTO {
    // @ApiModelProperty(value = "TO BE DEFINED", required = false)

	@NotNull
	private Integer idOrganizador;
}