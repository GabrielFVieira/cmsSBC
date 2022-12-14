package com.gabrielfigueiredo.cms.service;

import java.util.ArrayList;
import java.util.List;

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
import com.gabrielfigueiredo.cms.model.User;
import com.gabrielfigueiredo.cms.repository.EditionRepository;
import com.gabrielfigueiredo.cms.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditionServiceImpl implements EditionService {
	private final EditionRepository repository;
	private final UserService userService;

	@Override
	public EditionDTO create(Event event, EditionInputDTO input) {
		try {
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
		// TODO Auto-generated method stub
		return null;
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


