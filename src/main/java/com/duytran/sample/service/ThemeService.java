package com.duytran.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duytran.sample.dao.impl.ThemeDAO;
import com.duytran.sample.dto.BaseDTO;
import com.duytran.sample.dto.ListDTO;
import com.duytran.sample.dto.StatusCode;
import com.duytran.sample.dto.impl.ThemeCmp;
import com.duytran.sample.orm.impl.Theme;
import com.duytran.sample.utils.StringUtils;

@Service("themeService")
public class ThemeService {

	@Autowired
	private ThemeDAO themeDAO;
	
	public ListDTO<ThemeCmp> listThemes(int firstResult, int maxResult) {
		List<ThemeCmp> cmpList = new ArrayList<>();
		int totalThemes = themeDAO.countAll();
		List<Theme> themeList = themeDAO.list(firstResult, maxResult);
		for (Theme t : themeList) {
			cmpList.add(ThemeCmp.createInstance(t));
		}
		
		ListDTO<ThemeCmp> dto = new ListDTO<>(StatusCode.SUCCESS_OK);
		dto.setTotal(totalThemes);
		dto.setList(cmpList);
		return dto;
	}
	
	public BaseDTO addTheme(String name, boolean isDefaults, boolean isActive) {
		if (StringUtils.hasText(name)) {
			return new BaseDTO(StatusCode.ERROR_INVALID_PARAMETER);
		}
		
		Theme theme = new Theme();
		theme.setName(name);
		theme.setDefaults(isDefaults);
		theme.setActive(isActive);
		themeDAO.save(theme);
		
		return new BaseDTO(StatusCode.SUCCESS_OK);
	}
	
	public BaseDTO editTheme(int id, String name, boolean isDefaults, boolean isActive) {
		if (StringUtils.hasText(name)) {
			return new BaseDTO(StatusCode.ERROR_INVALID_PARAMETER);
		}
		
		Theme theme = themeDAO.getById(id);
		if (theme == null) {
			return new BaseDTO(StatusCode.ERROR_DATA_NOT_FOUND);
		}
		
		theme.setName(name);
		theme.setDefaults(isDefaults);
		theme.setActive(isActive);
		themeDAO.save(theme);
		
		return new BaseDTO(StatusCode.SUCCESS_OK);
	}
	
	public BaseDTO deleteTheme(int id) {
		Theme theme = themeDAO.getById(id);
		if (theme == null) {
			return new BaseDTO(StatusCode.ERROR_DATA_NOT_FOUND);
		}
		
		themeDAO.delete(theme);
		return new BaseDTO(StatusCode.SUCCESS_OK);
	}
}
