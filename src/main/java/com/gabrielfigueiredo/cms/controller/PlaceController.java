package com.gabrielfigueiredo.cms.controller;

import java.util.List;

import javax.validation.Valid;
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

import com.gabrielfigueiredo.cms.dto.PlaceDTO;
import com.gabrielfigueiredo.cms.dto.PlaceInputDTO;
import com.gabrielfigueiredo.cms.service.PlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/place")
@RequiredArgsConstructor
@Api(tags = {"Place"})
public class PlaceController {
	private final PlaceService placeService;

	@ApiOperation("List all places")
	@GetMapping
	public List<PlaceDTO> list() {
		List<PlaceDTO> result = placeService.list();
		return result;
	}

	@ApiOperation("Creates a new place")
	@PostMapping
	public PlaceDTO create(@Valid @RequestBody PlaceInputDTO place) {
		PlaceDTO result = placeService.create(place);
		return result;
	}

	@ApiOperation("Find a place")
	@GetMapping("/{id}")
	public PlaceDTO findById(@PathVariable("id") Integer id) {
		PlaceDTO result = placeService.find(id);
		return result;
	}

	@ApiOperation("Updates a place")
	@PutMapping("/{id}")
	public PlaceDTO update(@PathVariable("id") Integer id, @Valid @RequestBody PlaceInputDTO place) {
		PlaceDTO result = placeService.update(id, place);
		return result;
	}

	@ApiOperation("Delete a place")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remove(@PathVariable("id") Integer id) {
		placeService.remove(id);
		return;
	}
}
