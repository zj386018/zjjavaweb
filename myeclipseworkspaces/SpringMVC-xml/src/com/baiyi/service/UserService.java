package com.baiyi.service;

import com.baiyi.dao.UserDao;
import com.baiyi.po.User;

public class UserService {
	
	private UserDao userDao;
	
	public void add(String uname){
		System.out.println("UserService.add()");
		User u = new User();
		u.setUname(uname);
		userDao.add(u);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}