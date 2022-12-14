package com.gabrielfigueiredo.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gabrielfigueiredo.cms.dto.EditionDTO;
import com.gabrielfigueiredo.cms.dto.EditionInputDTO;
import com.gabrielfigueiredo.cms.dto.EditionOrganizerInputDTO;
import com.gabrielfigueiredo.cms.exception.DomainException;
import com.gabrielfigueiredo.cms.exception.InvalidParamException;
import com.gabrielfigueiredo.cms.exception.NotFoundException;
import com.gabrielfigueiredo.cms.exception.ServerException;
import com.gabrielfigueiredo.cms.model.Edition;
import com.gabrielfigueiredo.cms.model.Event;
import com.gabrielfigueiredo.cms.model.User;
import com.gabrielfigueiredo.cms.repository.EditionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditionServiceImpl implements EditionService {
	private final EditionRepository repository;
	private final UserService userService;

	@Override
	public Edition findEntity(Integer id) {
		try {
			Optional<Edition> exists = repository.findById(id);

			if (!exists.isPresent()) {
				throw new NotFoundException("Edition '"+id+"' not found");
			}

			return exists.get();
		}  catch (InvalidParamException | NotFoundException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while fetching edition");
		}
	}

	@Override
	public EditionDTO create(Event event, EditionInputDTO input) {
		try {
			Optional<Edition> found = event.getEdicoes()
										.stream()
										.filter(e -> e.getNumero() == input.getNumero())
										.findFirst();

			if (found.isPresent()) {
				throw new DomainException("An edition with number '"+input.getNumero()+"' already exists in this event");
			}

			Edition edition = new Edition(input);
			edition.setEvento(event);
			edition.Validate();

			Edition savedEdition = repository.save(edition);
			EditionDTO dto = new EditionDTO(savedEdition);

			return dto;
		}  catch (InvalidParamException | NotFoundException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while creating edition");
		}
	}

	@Override
	public List<EditionDTO> list() {
		try {
			List<Edition> editions = repository.findAll();

			List<EditionDTO> dtos = new ArrayList<>();
			for (Edition edition : editions) {
				dtos.add(new EditionDTO(edition));
			}

			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while listing editions");
		}
	}

	@Override
	public EditionDTO update(Event event, Integer id, EditionInputDTO input) {
		try {
			Optional<Edition> exists = event.getEdicoes()
										.stream()
										.filter(e -> e.getId() == id)
										.findFirst();

			if (!exists.isPresent()) {
				throw new NotFoundException("Edition '"+id+"' not found");
			}

			Optional<Edition> found = event.getEdicoes()
										.stream()
										.filter(e -> e.getNumero() == input.getNumero() && e.getId() != id)
										.findFirst();

			if (found.isPresent()) {
				throw new DomainException("An edition with number '"+input.getNumero()+"' already exists in this event");
			}

			Edition edition = exists.get();
			edition.Merge(input);
			edition.Validate();

			Edition savedEdition = repository.save(edition);
			EditionDTO dto = new EditionDTO(savedEdition);

			return dto;
		}  catch (InvalidParamException | NotFoundException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while updating edition");
		}
	}

	@Override
	public void addOrganizer(Edition edition, EditionOrganizerInputDTO organizer) {
		try {
			User user = userService.findEntity(organizer.getIdOrganizador());
			edition.setOrganizador(user);

			repository.save(edition);
			return;
		}  catch (InvalidParamException | NotFoundException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while adding organizer");
		}
	}

}


