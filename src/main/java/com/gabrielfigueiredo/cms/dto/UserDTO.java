package com.gabrielfigueiredo.cms.dto;

import com.gabrielfigueiredo.cms.model.User;
import com.gabrielfigueiredo.cms.model.Activity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "User")
@JsonInclude(Include.NON_EMPTY)
public class UserDTO {
    private Integer id;
	private String login;
	private String email;
	private String nome;
	private String afiliacao;
	private List<Activity> atividadesFavoritas;

	public UserDTO(User user) {
		this.id = user.getId();
		this.login = user.getLogin();
		this.email = user.getEmail();
		this.nome = user.getNome();
		this.afiliacao = user.getAfiliacao();
		this.atividadesFavoritas = user.getAtividadesFavoritas();
	}
}
