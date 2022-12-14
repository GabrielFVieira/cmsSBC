package com.gabrielfigueiredo.cms.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gabrielfigueiredo.cms.exception.DomainException;
import com.gabrielfigueiredo.cms.exception.InvalidParamException;
import com.gabrielfigueiredo.cms.exception.NotFoundException;
import com.gabrielfigueiredo.cms.exception.ServerException;
import com.gabrielfigueiredo.cms.model.Edition;
import com.gabrielfigueiredo.cms.model.Event;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {
	private final EventService eventService;

	@Override
	public String openPage(String eventPath, Integer editionYear) {
		try {
			Event event = eventService.findByPath(eventPath);

			Optional<Edition> edition = event.getEdicoes()
											.stream()
											.filter(e -> editionYear.equals(e.getAno()))
											.findAny();

			if (!edition.isPresent()) {
				throw new NotFoundException("Edition of year '"+editionYear+"' not found on this event");
			}


			String msg = "<!DOCTYPE html><html><body><h1>Opening page for event '" + event.getNome() + "', edition of number '" + edition.get().getNumero() + "'</h1></body></html>";
			return msg;
		}  catch (InvalidParamException | NotFoundException | DomainException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error while opening event page");
		}
	}

}
