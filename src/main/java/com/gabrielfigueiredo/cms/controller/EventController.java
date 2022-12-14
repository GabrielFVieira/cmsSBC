package com.gabrielfigueiredo.cms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfigueiredo.cms.dto.EditionDTO;
import com.gabrielfigueiredo.cms.dto.EditionInputDTO;
import com.gabrielfigueiredo.cms.dto.EditionOrganizerInputDTO;
import com.gabrielfigueiredo.cms.dto.EventDTO;
import com.gabrielfigueiredo.cms.dto.EventInputDTO;
import com.gabrielfigueiredo.cms.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("event")
@RequiredArgsConstructor
@Api(tags = {"Event"})
public class EventController {
	private final EventService eventService;

	private static final String EVENT_PATH = "The event path given during creation";

	@ApiOperation("Creates a new event")
	@PostMapping()
	public EventDTO createEvent(@Valid @RequestBody EventInputDTO event) {
		EventDTO result = eventService.create(event);
		return result;
	}

	@ApiOperation("List all events")
	@GetMapping
	public List<EventDTO> list() {
		List<EventDTO> result = eventService.list();
		return result;
	}

	@ApiOperation("Creates a new edition of the given event")
	@PostMapping("/{id}/edition")
	public EditionDTO createEdition(@PathVariable("id") Integer id,
									@Valid @RequestBody EditionInputDTO edition) {

		EditionDTO result = eventService.createEdition(id, edition);
		return result;
	}

	@ApiOperation("Creates or update the event's edition organizer")
	@PutMapping("/{eventid}/edition/{editionId}/organizer")
	public void addOrganizer(@PathVariable("eventid") Integer eventId, @PathVariable("editionId") Integer editionId,
							@Valid @RequestBody EditionOrganizerInputDTO organizer) {

		eventService.addOrganizer(eventId, editionId, organizer);
		return;
	}

	@ApiOperation("Creates a new activity on the event edition")
	@PostMapping("/{eventid}/edition/{editionId}/activity")
	public EditionDTO createActivity(@PathVariable("eventid") Integer eventId, @PathVariable("editionId") Integer editionId,
									@Valid @RequestBody EditionInputDTO edition) {


		return null;
	}
}
