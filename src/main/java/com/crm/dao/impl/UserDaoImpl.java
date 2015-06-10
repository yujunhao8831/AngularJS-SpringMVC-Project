package com.crm.dao.impl;


import org.springframework.stereotype.Repository;

import com.crm.core.base.BaseDaoImpl;
import com.crm.dao.UserDao;
import com.crm.domain.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User checkUsernameAndPassword(String username, String password) {
		return (User) getSession().createQuery(//
				"FROM User WHERE username = :username AND password = :password")//
				.setParameter("username", username)//
				.setParameter("password", password)//
				.uniqueResult();
	}
}
