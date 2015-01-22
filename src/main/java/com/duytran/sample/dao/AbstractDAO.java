package com.duytran.sample.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class AbstractDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Query createQuery(String hql) {
		return sessionFactory.getCurrentSession().createQuery(hql);
	}

	public SQLQuery createSQLQuery(String sql) {
		return sessionFactory.getCurrentSession().createSQLQuery(sql);
	}
}
