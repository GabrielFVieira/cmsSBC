package com.gabrielfigueiredo.cms.service;

import java.util.List;

import com.gabrielfigueiredo.cms.dto.EventInputDTO;
import com.gabrielfigueiredo.cms.dto.EditionDTO;
import com.gabrielfigueiredo.cms.dto.EditionInputDTO;
import com.gabrielfigueiredo.cms.dto.EventDTO;

public interface EventService {
	public EventDTO create(EventInputDTO input);

	public EditionDTO createEdition(String eventPath, EditionInputDTO input);

	public List<EventDTO> list();
}
