package com.gabrielfigueiredo.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gabrielfigueiredo.cms.dto.EditionDTO;
import com.gabrielfigueiredo.cms.dto.EditionInputDTO;
import com.gabrielfigueiredo.cms.dto.EventDTO;
import com.gabrielfigueiredo.cms.dto.EventInputDTO;
import com.gabrielfigueiredo.cms.model.Event;
import com.gabrielfigueiredo.cms.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
	private final EventRepository repository;
	private final EditionService editionService;

	@Override
	public EventDTO create(EventInputDTO input) {
		Event event = new Event(input);
		Event savedEvent = repository.save(event);

		return convertToDTO(savedEvent);
	}

	@Override
	public List<EventDTO> list() {
		List<Event> events = repository.findAll();

		List<EventDTO> dtos = new ArrayList<>();
		for (Event event : events) {
			dtos.add(convertToDTO(event));
		}

		return dtos;
	}

	private EventDTO convertToDTO(Event event) {
		EventDTO dto = new EventDTO();
		dto.setId(event.getId());
		dto.setNome(event.getNome());
		dto.setDescricao(event.getDescricao());
		dto.setSigla(event.getSigla());
		dto.setCaminho(event.getCaminho());

		return dto;
	}

	@Override
	public EditionDTO createEdition(String eventPath, EditionInputDTO input) {
		Event event = repository.findByPath(eventPath);
		EditionDTO edition = editionService.create(event, input);

		return edition;
	}
}


