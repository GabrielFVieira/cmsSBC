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
import com.gabrielfigueiredo.cms.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/event/{eventId}/edition")
@RequiredArgsConstructor
@Api(tags = {"Event"})
public class EditionController {
	private final EventService eventService;

	@ApiOperation("Creates a new edition of the given event")
	@PostMapping
	public EditionDTO create(@PathVariable("eventId") Integer id,
								@Valid @RequestBody EditionInputDTO edition) {

		EditionDTO result = eventService.createEdition(id, edition);
		return result;
	}

	@ApiOperation("List all editions of the given event")
	@GetMapping
	public List<EditionDTO> list(@PathVariable("eventId") Integer id) {
		List<EditionDTO> result = eventService.listEditions(id);
		return result;
	}

	@ApiOperation("Updates a edition of the given event")
	@PutMapping("/{id}")
	public EditionDTO update(@PathVariable("eventId") Integer id, @PathVariable("id") Integer editionId,
								@Valid @RequestBody EditionInputDTO edition) {

		EditionDTO result = eventService.updateEdition(id, editionId, edition);
		return result;
	}

	@ApiOperation("Creates or update the event's edition organizer")
	@PutMapping("/{id}/organizer")
	public void addOrganizer(@PathVariable("eventId") Integer eventId, @PathVariable("id") Integer editionId,
							@Valid @RequestBody EditionOrganizerInputDTO organizer) {

		eventService.addOrganizer(eventId, editionId, organizer);
		return;
	}

	@ApiOperation("Creates a new activity on the event edition")
	@PostMapping("/{id}/activity")
	public EditionDTO createActivity(@PathVariable("eventid") Integer eventId, @PathVariable("id") Integer editionId,
									@Valid @RequestBody EditionInputDTO edition) {


		return null;
	}
}
