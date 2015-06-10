package com.crm.service;


import com.crm.core.base.BaseService;
import com.crm.dao.UserDao;
import com.crm.domain.User;


public interface UserService extends BaseService<User,UserDao>{

	User checkUsernameAndPassword(String username, String password);
	
}
