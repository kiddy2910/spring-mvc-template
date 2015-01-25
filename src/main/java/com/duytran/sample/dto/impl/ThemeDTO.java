package com.duytran.sample.dto.impl;

import com.duytran.sample.dto.GenericDTO;
import com.duytran.sample.orm.impl.Theme;

public class ThemeDTO implements GenericDTO {
	private static final long serialVersionUID = -3587509354380300160L;

	private Integer id;
	private String name;
	private boolean defaults;
	private boolean active;

	public static ThemeDTO createInstance(Theme theme) {
		ThemeDTO cmp = new ThemeDTO();
		cmp.setId(theme.getId());
		cmp.setName(theme.getName());
		cmp.setDefaults(theme.isDefaults());
		cmp.setActive(theme.isActive());
		return cmp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDefaults() {
		return defaults;
	}

	public void setDefaults(boolean defaults) {
		this.defaults = defaults;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
