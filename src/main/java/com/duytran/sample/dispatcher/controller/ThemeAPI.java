package com.duytran.sample.dispatcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duytran.sample.dto.BaseDTO;
import com.duytran.sample.dto.ListDTO;
import com.duytran.sample.dto.StatusCode;
import com.duytran.sample.dto.impl.ThemeCmp;
import com.duytran.sample.service.ThemeService;

@RestController("themeAPI")
public class ThemeAPI {
	
	@Autowired
	private ThemeService themeService;
	
	@RequestMapping("/")
	public BaseDTO index() {
		return new BaseDTO(StatusCode.SUCCESS_OK);
	}

	@RequestMapping(value = "/themes", method = RequestMethod.GET)
	public ListDTO<ThemeCmp> list(
			@RequestParam("firstResult") int firstResult,
			@RequestParam("maxResult") int maxResult) {
		return themeService.listThemes(firstResult, maxResult);
	}
	
	@RequestMapping(value = "/themes", method = RequestMethod.POST)
	public BaseDTO add(
			@RequestParam("name") String name,
			@RequestParam("isDefaults") boolean isDefaults,
			@RequestParam("isActive") boolean isActive) {
		return themeService.addTheme(name, isDefaults, isActive);
	}
	
	@RequestMapping(value = "/themes/{id}", method = RequestMethod.PUT)
	public BaseDTO edit(
			@PathVariable("id") int id,
			@RequestParam("name") String name,
			@RequestParam("isDefaults") boolean isDefaults,
			@RequestParam("isActive") boolean isActive) {
		return themeService.editTheme(id, name, isDefaults, isActive);
	}
	
	@RequestMapping(value = "/themes/{id}", method = RequestMethod.DELETE)
	public BaseDTO delete(@PathVariable("id") int id) {
		return themeService.deleteTheme(id);
	}
}
