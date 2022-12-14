package com.gabrielfigueiredo.cms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfigueiredo.cms.service.PageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/page")
@RequiredArgsConstructor
@Api(tags = {"Page"})
public class PageController {
	private final PageService pageService;

	@ApiOperation("Creates a new edition of the given event")
	@GetMapping("/{eventPath}/{editionYear}")
	public String open(@PathVariable("eventPath") String eventPath,
								@PathVariable("editionYear") Integer editionYear) {

		String result = pageService.openPage(eventPath, editionYear);
		return result;
	}
}
