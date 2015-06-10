package com.crm.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.crm.core.domain.BaseEntity;

/**
 * 用户
 * 用于登陆系统页面
 * 多个用户(User)对应多个角色(Role).		* === *
 * 多个用户(User)对应多个权限(Privilege).	* === *
 */
@Entity
@Table(name="USER_")
public class User extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	/** 用户名 **/
	private String username;
	/** 密码 **/
	private String password;
	
	/** 用户角色 多个用户(User)对应多个角色(Role). **/
	private Set<Role> roleSet; 
	
	@Column(name="USERNAME_")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="PASSWORD_")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @ManyToMany : 指定多对多的关联关系 
	 * mappedBy="userSet"属性 :  表示由userSet那一方来进行维护
	 */
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="userSet") 
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	
	
	
	
}
