package com.crm.service.impl;


import org.springframework.stereotype.Service;

import com.crm.core.base.BaseServiceImpl;
import com.crm.dao.UserDao;
import com.crm.domain.User;
import com.crm.service.UserService;
@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserDao> implements UserService {

	@Override
	public User checkUsernameAndPassword(String username, String password) {
		return dao.checkUsernameAndPassword(username, password);
	}

}
