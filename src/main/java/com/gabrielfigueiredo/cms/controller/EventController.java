package com.gabrielfigueiredo.cms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfigueiredo.cms.dto.EventDTO;
import com.gabrielfigueiredo.cms.dto.EventInputDTO;
import com.gabrielfigueiredo.cms.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
@Api(tags = {"Event"})
public class EventController {
	private final EventService eventService;

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

	@ApiOperation("List all events")
	@GetMapping("/{id}")
	public EventDTO find(@PathVariable("id") Integer id) {
		EventDTO result = eventService.find(id);
		return result;
	}
}
