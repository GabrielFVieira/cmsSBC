package com.gabrielfigueiredo.cms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfigueiredo.cms.dto.ActivityInputDTO;
import com.gabrielfigueiredo.cms.dto.UserDTO;
import com.gabrielfigueiredo.cms.dto.UserInputDTO;
import com.gabrielfigueiredo.cms.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Api(tags = {"User"})
public class UserController {
	private final UserService userService;

	@ApiOperation("List all users")
	@GetMapping
	public List<UserDTO> list() {
		List<UserDTO> result = userService.list();
		return result;
	}

	@ApiOperation("Creates a new user")
	@PostMapping
	public UserDTO create(@Valid @RequestBody UserInputDTO user) {
		UserDTO result = userService.create(user);
		return result;
	}

	@ApiOperation("Find a user")
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable("id") Integer id) {
		UserDTO result = userService.find(id);
		return result;
	}

	@ApiOperation("Updates a user")
	@PutMapping("/{id}")
	public UserDTO update(@PathVariable("id") Integer id, @Valid @RequestBody UserInputDTO user) {
		UserDTO result = userService.update(id, user);
		return result;
	}

	@ApiOperation("Deletes a user")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remove(@PathVariable("id") Integer id) {
		userService.remove(id);
		return;
	}

	@ApiOperation("Adds an activity to an user's favorites")
	@PutMapping("/{id}")
	public UserDTO addActivityToFavorites(@PathVariable("id") Integer id, @Valid @RequestBody UserInputDTO userDTO, @Valid @RequestBody ActivityInputDTO activityDTO) {
		UserDTO result = userService.addActivityToFavorites(id, userDTO, activityDTO);
		return result;
	}

	@ApiOperation("Removess an activity from an user's favorites")
	@PutMapping("/{id}")
	public UserDTO removeActivityFromFavorites(@PathVariable("id") Integer id, @Valid @RequestBody UserInputDTO userDTO, @Valid @RequestBody ActivityInputDTO activityDTO) {
		UserDTO result = userService.removeActivityFromFavorites(id, userDTO, activityDTO);
		return result;
	}
}