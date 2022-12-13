package com.gabrielfigueiredo.cms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfigueiredo.cms.dto.UserDTO;
import com.gabrielfigueiredo.cms.dto.UserInputDTO;
import com.gabrielfigueiredo.cms.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Api(tags = {"User"})
public class UserController {
	private final UserService userService;

	@ApiOperation("Creates a new user")
	@PostMapping()
	public UserDTO create(@Valid @RequestBody UserInputDTO user) {
		UserDTO result = userService.create(user);
		return result;
	}

	@ApiOperation("List all users")
	@GetMapping
	public List<UserDTO> list() {
		List<UserDTO> result = userService.list();
		return result;
	}
}
