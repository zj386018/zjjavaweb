package com.baiyi.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.baiyi.po.User;

public class UserDao {
	private HibernateTemplate hibernateTemplate;

	public void add(User u) {
		System.out.println("UserDao.add()");
		hibernateTemplate.save(u);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}