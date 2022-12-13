package com.gabrielfigueiredo.cms.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "UserInput")
public class UserInputDTO {
	private String login;
	private String email;
	private String nome;
	private String afiliacao;


}