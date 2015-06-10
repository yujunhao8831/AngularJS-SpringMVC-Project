package com.crm.dao;

import com.crm.core.base.BaseDao;
import com.crm.domain.User;

public interface UserDao extends BaseDao<User>{
	/**
	 * 校验用户
	 * @param username
	 * @param password
	 * @return
	 */
	User checkUsernameAndPassword(String username, String password);
}
