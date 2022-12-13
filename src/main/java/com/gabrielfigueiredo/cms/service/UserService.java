package com.gabrielfigueiredo.cms.service;

import java.util.List;

import com.gabrielfigueiredo.cms.dto.UserDTO;
import com.gabrielfigueiredo.cms.dto.UserInputDTO;

public interface UserService {
	public UserDTO create(UserInputDTO input);

	public List<UserDTO> list();
}
