package com.gabrielfigueiredo.cms.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "User")
public class UserDTO {
    private Long id;
	private String login;
	private String email;
	private String nome;
	private String afiliacao;
}
