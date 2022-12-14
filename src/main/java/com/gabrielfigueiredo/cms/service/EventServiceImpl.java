package com.gabrielfigueiredo.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.gabrielfigueiredo.cms.dto.EditionDTO;
import com.gabrielfigueiredo.cms.dto.EditionInputDTO;
import com.gabrielfigueiredo.cms.dto.EditionOrganizerInputDTO;
import com.gabrielfigueiredo.cms.dto.EventDTO;
import com.gabrielfigueiredo.cms.dto.EventInputDTO;
import com.gabrielfigueiredo.cms.exception.DomainException;
import com.gabrielfigueiredo.cms.exception.InvalidParamException;
import com.gabrielfigueiredo.cms.exception.NotFoundException;
import com.gabrielfigueiredo.cms.exception.ServerException;
import com.gabrielfigueiredo.cms.model.Edition;
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
		try {
			Event entity = new Event(input);
			entity.Validate();
			validateEventPath(entity);

			Event savedEntity = repository.save(entity);
			EventDTO dto = new EventDTO(savedEntity);

			return dto;
		}  catch (InvalidParamException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while creating event");
		}
	}

	@Override
	public List<EventDTO> list() {
		try {
			List<Event> events = repository.findAll();

			List<EventDTO> dtos = new ArrayList<>();
			for (Event event : events) {
				dtos.add(new EventDTO(event));
			}

			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while listing events");
		}
	}

	@Override
	public EventDTO find(Integer id) {
		try {
			Event entity = findById(id);
			EventDTO dto = new EventDTO(entity);

			if (entity.getEdicoes() != null) {
				List<EditionDTO> editions = new ArrayList<>();
				for (Edition edition : entity.getEdicoes()) {
					editions.add(new EditionDTO(edition));
				}

				dto.setEditions(editions);
			}

			return dto;
		}  catch (InvalidParamException | NotFoundException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while fetching event");
		}
	}

	@Override
	public EditionDTO createEdition(Integer eventId, EditionInputDTO input) {
		try {
			Event entity = findById(eventId);
			EditionDTO edition = editionService.create(entity, input);

			return edition;
		}  catch (InvalidParamException | NotFoundException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while creating edition");
		}
	}

	@Override
	public List<EditionDTO> listEditions(Integer eventId) {
		try {
			Event entity = findById(eventId);

			List<EditionDTO> dtos = new ArrayList<>();
			for (Edition edition : entity.getEdicoes()) {
				dtos.add(new EditionDTO(edition));
			}

			return dtos;
		}  catch (InvalidParamException | NotFoundException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while listing editions");
		}
	}

	@Override
	public EditionDTO updateEdition(Integer eventId, Integer editionId, EditionInputDTO input) {
		try {
			Event entity = findById(eventId);
			EditionDTO edition = editionService.update(entity, editionId, input);

			return edition;
		}  catch (InvalidParamException | NotFoundException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while updating edition");
		}
	}

	@Override
	public void addOrganizer(Integer eventId, Integer editionId, EditionOrganizerInputDTO input) {
		try {
			Event entity = findById(eventId);

			Optional<Edition> found = entity.getEdicoes()
										.stream()
										.filter(e -> e.getId() == editionId)
										.findFirst();

			if (!found.isPresent()) {
				throw new NotFoundException("Edition '"+editionId+"' not found on event '"+eventId+"'");
			}

			editionService.addOrganizer(found.get(), input);
			return;
		}  catch (InvalidParamException | NotFoundException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while adding organizer on edition");
		}
	}

	private Event findById(Integer id) {
		Optional<Event> exists = repository.findById(id);

		if (!exists.isPresent()) {
			throw new NotFoundException("Event '"+id+"' not found");
		}

		return exists.get();
	}

	private void validateEventPath(Event event) {
		Event sample = new Event();
		sample.setCaminho(event.getCaminho());

		Optional<Event> foundEvent = repository.findOne(Example.of(sample));

		if (foundEvent.isPresent() && foundEvent.get().getId() != event.getId()) {
			throw new DomainException("Path '"+event.getCaminho()+"' already in use");
		}

		return;
	}
}


