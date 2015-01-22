package com.duytran.sample.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public abstract class AbstractDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Query createQuery(String hql) {
		return sessionFactory.getCurrentSession().createQuery(hql);
	}

	public SQLQuery createSQLQuery(String sql) {
		return sessionFactory.getCurrentSession().createSQLQuery(sql);
	}
	
	public void save(Object obj) {
		sessionFactory.getCurrentSession().save(obj);
	}
	
	public void update(Object obj) {
		sessionFactory.getCurrentSession().update(obj);
	}
	
	public void delete(Object obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}
}
