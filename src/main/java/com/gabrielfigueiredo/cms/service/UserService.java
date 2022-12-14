package com.gabrielfigueiredo.cms.service;

import java.util.List;

import com.gabrielfigueiredo.cms.dto.UserDTO;
import com.gabrielfigueiredo.cms.dto.UserInputDTO;
import com.gabrielfigueiredo.cms.model.User;
import com.gabrielfigueiredo.cms.dto.ActivityInputDTO;
import com.gabrielfigueiredo.cms.dto.FavoriteActivityInputDTO;

public interface UserService {
	public UserDTO create(UserInputDTO input);

	public UserDTO find(Integer id);

	public User findEntity(Integer id);

	public List<UserDTO> list();

	public UserDTO update(Integer id, UserInputDTO input);

	public void remove(Integer id);

	public UserDTO addActivityToFavorites(Integer id, FavoriteActivityInputDTO favorite);

	public UserDTO removeActivityFromFavorites(Integer id, FavoriteActivityInputDTO favorite);

}
