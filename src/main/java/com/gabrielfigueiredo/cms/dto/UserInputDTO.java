package com.gabrielfigueiredo.cms.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.gabrielfigueiredo.cms.model.Activity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "UserInput")
public class UserInputDTO {
	@NotBlank
	private String login;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String afiliacao;

	private List<Activity> atividadesFavoritas;
}