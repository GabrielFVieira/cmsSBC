package com.gabrielfigueiredo.cms.service;

import java.util.List;

import com.gabrielfigueiredo.cms.dto.EditionInputDTO;
import com.gabrielfigueiredo.cms.model.Event;
import com.gabrielfigueiredo.cms.dto.EditionDTO;

public interface EditionService {
	public EditionDTO create(Event event, EditionInputDTO input);

	public List<EditionDTO> list();
}
