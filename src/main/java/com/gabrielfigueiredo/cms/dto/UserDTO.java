package com.gabrielfigueiredo.cms.dto;

import com.gabrielfigueiredo.cms.model.User;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "User")
public class UserDTO {
    private Integer id;
	private String login;
	private String email;
	private String nome;
	private String afiliacao;

	public UserDTO(User user) {
		this.id = user.getId();
		this.login = user.getLogin();
		this.email = user.getEmail();
		this.nome = user.getNome();
		this.afiliacao = user.getAfiliacao();
	}
}
