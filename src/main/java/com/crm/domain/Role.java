package com.crm.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.crm.core.domain.BaseEntity;

/**
 * 角色
 * 多个角色(Role)对应多个权限(Privilege).	* === *
 * 多个角色(Role)对应多个用户(User).	 	* === *
 *
 */
@Entity
@Table(name="ROLE_")
public class Role extends BaseEntity{
	private static final long serialVersionUID = 1L;

	/** 角色名称 **/
	private String name; 
	/** 角色说明 */
	private String description;  
	/** 多个角色(Role)对应多个权限(Privilege) **/
	private Set<Privilege> privilegeSet; 
	/** 多个角色(Role)对应多个用户(User). **/
	private Set<User> userSet; 
	
	@Column(name="NAME_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="DESCRIPTION_")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="ROLE_PRIVILEGE_", joinColumns={ @JoinColumn(name="ROLE_ID_")},inverseJoinColumns={ @JoinColumn(name = "PRIVILEGE_ID_") })
	public Set<Privilege> getPrivilegeSet() {
		return privilegeSet;
	}
	public void setPrivilegeSet(Set<Privilege> privilegeSet) {
		this.privilegeSet = privilegeSet;
	}
	
	/**
	 * @JoinTable : 因为多对多之间会通过一张中间表来维护两表直接的关系,
	 * 所以通过 JoinTable 这个注解来声明,name就是指定了中间表的名字,
	 * JoinColumns是一个 @JoinColumn类型的数组,
	 * 表示的是我这方在对方中的外键名称,我方是Role,所以在对方外键的名称就是 
	 * user_id_,inverseJoinColumns也是一个 @JoinColumn类型的数组,
	 * 表示的是对方在我这放中的外键名称，对方是User，所以在我方外键的名称就是 role_id_
	 */
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="USER_ROLE_", joinColumns={ @JoinColumn(name="ROLE_ID_")},inverseJoinColumns={ @JoinColumn(name = "USER_ID_") })
	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	
	
	
	
}
