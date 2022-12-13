package com.gabrielfigueiredo.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gabrielfigueiredo.cms.dto.UserDTO;
import com.gabrielfigueiredo.cms.dto.UserInputDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	// private final EditionRepository repository;

	@Override
	public UserDTO create(UserInputDTO input) {
		return null;
	}

	@Override
	public List<UserDTO> list() {
		return null;
	}
}


