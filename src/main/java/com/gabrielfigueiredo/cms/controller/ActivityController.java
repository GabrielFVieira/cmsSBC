package com.gabrielfigueiredo.cms.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfigueiredo.cms.dto.ActivityDTO;
import com.gabrielfigueiredo.cms.dto.ActivityInputDTO;
import com.gabrielfigueiredo.cms.service.ActivityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/activity")
@RequiredArgsConstructor
@Api(tags = {"Activity"})
public class ActivityController {
	private final ActivityService activityService;

	@ApiOperation("List all activities")
	@GetMapping
	public List<ActivityDTO> list() {
		List<ActivityDTO> result = activityService.list();
		return result;
	}

	@ApiOperation("Creates a new activity")
	@PostMapping
	public ActivityDTO create(@Valid @RequestBody ActivityInputDTO activity) {
		ActivityDTO result = activityService.create(activity);
		return result;
	}

	@ApiOperation("Updates a activity")
	@PutMapping("/{id}")
	public ActivityDTO update(@PathVariable("id") Integer id, @Valid @RequestBody ActivityInputDTO activity) {
		ActivityDTO result = activityService.update(id, activity);
		return result;
	}

	@ApiOperation("Delete a activity")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remove(@PathVariable("id") Integer id) {
		activityService.remove(id);
		return;
	}
}
