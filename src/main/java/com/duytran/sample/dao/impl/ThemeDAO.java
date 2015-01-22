package com.duytran.sample.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.duytran.sample.dao.AbstractDAO;
import com.duytran.sample.orm.impl.Theme;

@Repository("themeDAO")
public class ThemeDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Theme> list(int firstResult, int maxResult) {
		String hql = "from Theme";
		return (List<Theme>) createQuery(hql)
				.setFirstResult(firstResult)
				.setMaxResults(maxResult)
				.list();
	}
}
