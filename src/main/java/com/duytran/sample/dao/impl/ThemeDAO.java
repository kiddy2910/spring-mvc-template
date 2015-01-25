package com.duytran.sample.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.duytran.sample.dao.AbstractDAO;
import com.duytran.sample.orm.impl.Theme;

@Repository("themeDAO")
@Transactional
public class ThemeDAO extends AbstractDAO {

	public Theme getById(int id) {
		String hql = "from Theme where id = :id";
		return (Theme) createQuery(hql)
				.setParameter("id", id)
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Theme> list(int offset, int limit) {
		String hql = "from Theme";
		return (List<Theme>) createQuery(hql)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}
	
	public int countAll() {
		return ((Long) createQuery("select count(id) from Theme")
				.uniqueResult())
				.intValue();
	}
	
}
