package com.duytran.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duytran.sample.dao.impl.ThemeDAO;
import com.duytran.sample.dto.ListDTO;
import com.duytran.sample.dto.impl.ThemeDTO;
import com.duytran.sample.exception.impl.BadRequestException;
import com.duytran.sample.exception.impl.NotFoundException;
import com.duytran.sample.orm.impl.Theme;
import com.duytran.sample.util.StringUtils;

@Service("themeService")
public class ThemeService {

	@Autowired
	private ThemeDAO themeDAO;
	
	public ListDTO<ThemeDTO> listThemes(int firstResult, int maxResult) {
		
		int totalThemes = themeDAO.countAll();
		List<Theme> themeList = themeDAO.list(firstResult, maxResult);
		List<ThemeDTO> dtoList = new ArrayList<>();
		for (Theme t : themeList) {
			dtoList.add(ThemeDTO.createInstance(t));
		}
		
		ListDTO<ThemeDTO> dto = new ListDTO<>();
		dto.setTotal(totalThemes);
		dto.setList(dtoList);
		return dto;
	}
	
	public ThemeDTO addTheme(String name, boolean isDefaults, boolean isActive) 
			throws BadRequestException {
		
		if (StringUtils.isEmpty(name)) {
			throw new BadRequestException();
		}
		
		Theme theme = new Theme();
		theme.setName(name);
		theme.setDefaults(isDefaults);
		theme.setActive(isActive);
		themeDAO.saveOrUpdate(theme);
		
		return ThemeDTO.createInstance(theme);
	}
	
	public ThemeDTO editTheme(int id, String name, boolean isDefaults, boolean isActive) 
			throws NotFoundException, BadRequestException {
		
		if (StringUtils.isEmpty(name)) {
			throw new BadRequestException();
		}
		
		Theme theme = themeDAO.getById(id);
		if (theme == null) {
			throw new NotFoundException();
		}
		
		theme.setName(name);
		theme.setDefaults(isDefaults);
		theme.setActive(isActive);
		themeDAO.saveOrUpdate(theme);
		
		return ThemeDTO.createInstance(theme);
	}
	
	public void deleteTheme(int id) throws NotFoundException {
		
		Theme theme = themeDAO.getById(id);
		if (theme == null) {
			throw new NotFoundException();
		}
		
		themeDAO.delete(theme);
	}
}
