package com.gabrielfigueiredo.cms.service;

import java.util.List;

import com.gabrielfigueiredo.cms.dto.PlaceDTO;
import com.gabrielfigueiredo.cms.dto.PlaceInputDTO;
import com.gabrielfigueiredo.cms.model.Place;

public interface PlaceService {
	public PlaceDTO create(PlaceInputDTO input);

	public PlaceDTO find(Integer id);

	public Place findEntity(Integer id);

	public List<PlaceDTO> list();

	public PlaceDTO update(Integer id, PlaceInputDTO input);

	public void remove(Integer id);
}
