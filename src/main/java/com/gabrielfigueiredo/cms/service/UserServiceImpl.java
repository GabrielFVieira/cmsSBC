package com.gabrielfigueiredo.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.gabrielfigueiredo.cms.dto.UserDTO;
import com.gabrielfigueiredo.cms.dto.UserInputDTO;
import com.gabrielfigueiredo.cms.exception.DomainException;
import com.gabrielfigueiredo.cms.exception.InvalidParamException;
import com.gabrielfigueiredo.cms.exception.NotFoundException;
import com.gabrielfigueiredo.cms.exception.ServerException;
import com.gabrielfigueiredo.cms.model.User;
import com.gabrielfigueiredo.cms.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository repository;

	@Override
	public UserDTO create(UserInputDTO input) {
		try {
			User entity = new User(input);
			entity.Validate();
			validateUserLogin(entity);

			User savedEntity = repository.save(entity);
			UserDTO dto = new UserDTO(savedEntity);

			return dto;
		}  catch (InvalidParamException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while creating user");
		}
	}

	@Override
	public List<UserDTO> list() {
		try {
			List<User> users = repository.findAll();

			List<UserDTO> dtos = new ArrayList<>();
			for (User user : users) {
				dtos.add(new UserDTO(user));
			}

			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while listing users");
		}
	}

	@Override
	public UserDTO update(Integer id, UserInputDTO input) {
		try {
			User entity = findById(id);
			entity.Merge(input);
			entity.Validate();
			validateUserLogin(entity);

			User updatedEntity = repository.save(entity);
			UserDTO dto = new UserDTO(updatedEntity);

			return dto;
		}  catch (InvalidParamException | DomainException | NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while updating user");
		}
	}

	@Override
	public void remove(Integer id) {
		try {
			User entity = findById(id);
			repository.delete(entity);

			return;
		}  catch (InvalidParamException | DomainException | NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while deleting user");
		}
	}

	private void validateUserLogin(User user) {
		User sample = new User();
		sample.setLogin(user.getLogin());

		Optional<User> foundUser = repository.findOne(Example.of(sample));

		if (foundUser.isPresent() && foundUser.get().getId() != user.getId()) {
			throw new DomainException("Login '"+user.getLogin()+"' already in use");
		}

		return;
	}

	@Override
	public UserDTO find(Integer id) {
		try {
			User entity = findById(id);
			UserDTO dto = new UserDTO(entity);

			return dto;
		}  catch (NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while fetching user");
		}
	}

	private User findById(Integer id) {
		Optional<User> exists = repository.findById(id);

		if (!exists.isPresent()) {
			throw new NotFoundException("User '"+id+"' not found");
		}

		return exists.get();
	}

	@Override
	public User findEntity(Integer id) {
		try {
			User entity = findById(id);

			return entity;
		}  catch (NotFoundException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while fetching user");
		}
	}
}
