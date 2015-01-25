package com.duytran.sample.dispatcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duytran.sample.dto.ListDTO;
import com.duytran.sample.dto.impl.ThemeDTO;
import com.duytran.sample.exception.impl.BadRequestException;
import com.duytran.sample.exception.impl.NotFoundException;
import com.duytran.sample.service.ThemeService;

@RestController("themeController")
@RequestMapping("/themes")
public class ThemeController {
	
	@Autowired
	private ThemeService themeService;

	@RequestMapping(method = RequestMethod.GET)
	ListDTO<ThemeDTO> list(
			@RequestParam("firstResult") int firstResult,
			@RequestParam("maxResult") int maxResult) {
		return themeService.listThemes(firstResult, maxResult);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<ThemeDTO> add(
			@RequestParam("name") String name,
			@RequestParam("isDefaults") boolean isDefaults,
			@RequestParam("isActive") boolean isActive) 
					throws BadRequestException {
		
		ThemeDTO dto = themeService.addTheme(name, isDefaults, isActive);
		return new ResponseEntity<ThemeDTO>(dto, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	ResponseEntity<ThemeDTO> edit(
			@PathVariable("id") int id,
			@RequestParam("name") String name,
			@RequestParam("isDefaults") boolean isDefaults,
			@RequestParam("isActive") boolean isActive) 
					throws NotFoundException, BadRequestException {
		
		ThemeDTO dto = themeService.editTheme(id, name, isDefaults, isActive);
		return new ResponseEntity<ThemeDTO>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<String> delete(@PathVariable("id") int id) 
			throws NotFoundException {
		
		themeService.deleteTheme(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
