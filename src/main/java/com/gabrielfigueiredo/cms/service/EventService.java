package com.gabrielfigueiredo.cms.service;

import java.util.List;

import com.gabrielfigueiredo.cms.dto.EventInputDTO;
import com.gabrielfigueiredo.cms.dto.EditionDTO;
import com.gabrielfigueiredo.cms.dto.EditionInputDTO;
import com.gabrielfigueiredo.cms.dto.EditionOrganizerInputDTO;
import com.gabrielfigueiredo.cms.dto.EventDTO;

public interface EventService {
	public EventDTO create(EventInputDTO input);

	public EditionDTO createEdition(Integer eventId, EditionInputDTO input);

	public void addOrganizer(Integer eventId, Integer editionId, EditionOrganizerInputDTO input);

	public List<EventDTO> list();
}