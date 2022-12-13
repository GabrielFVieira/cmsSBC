package com.gabrielfigueiredo.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gabrielfigueiredo.cms.dto.EditionDTO;
import com.gabrielfigueiredo.cms.dto.EditionInputDTO;
import com.gabrielfigueiredo.cms.dto.EventDTO;
import com.gabrielfigueiredo.cms.dto.EventInputDTO;
import com.gabrielfigueiredo.cms.model.Edition;
import com.gabrielfigueiredo.cms.model.Event;
import com.gabrielfigueiredo.cms.repository.EditionRepository;
import com.gabrielfigueiredo.cms.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditionServiceImpl implements EditionService {
	private final EditionRepository repository;

	@Override
	public EditionDTO create(Event event, EditionInputDTO input) {
		Edition edition = new Edition(input);
		edition.setEvento(event);

		Edition savedEdition = repository.save(edition);

		return convertToDTO(savedEdition);
	}

	@Override
	public List<EditionDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	private EditionDTO convertToDTO(Edition edition) {
		return new EditionDTO(edition);
	}

}


