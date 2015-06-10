package com.crm.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.crm.core.domain.BaseEntity;


/**
 * 权限
 * 多个权限(Privilege)对应多个角色(Role).   * === *
 * 多个权限(Privilege)对应多个用户(User).   * === *
 * ----------------------------------------------
 * ( 某权限就是使用某功能的许可，也就是某URL的访问许可 ) 
 * ( 功能的使用许可，也就是某URL的访问许可。 )
 */
@Entity
@Table(name="PRIVILEGE_")
public class Privilege extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	/** 权限名称 **/
	private String name; 
	/** 权限URL. **/
	private String url; 

	/** 该权限的上级权限. **/
	private Privilege parent; 
	/** 该权限下级的权限. **/
	private Set<Privilege> children = new HashSet<Privilege>(); 

	/** 多个权限(Privilege)对应多个角色(Role).  **/
	private Set<Role> roleSet; 
	
	/**
	 * 
	 * @param name 	 该权限名
	 * @param url  	 该权限对应的URL
	 * @param parent 该权限的上级权限
	 */
	public Privilege(String name, String url, Privilege parent) {
		super();
		this.name = name;
		this.url = url;
		this.parent = parent;
	}
	
	public Privilege() {
		super();
	}
	
	@Column(name="NAME_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="URL_")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * # ManyToMany：多对多
	 *    # fetch = FetchType.LAZY：使用延时加载，相当于xml中的lazy=true
	 *    # mappedBy = "privilegeSet"，设置当前类是否关联关系,相当于inverse="true"(代表放弃维护关联关系,对方管)
	 *    	# resources：对方的关联属性
	 *      # 相当于xml中inverse=true
	 *      也就是 privilege 这个'属性'所在的类,维护关联关系.! -> 也就是 Role private Set<Privilege> privilegeSet; 有这个属性,那么它来维护关联关系.
	 */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "privilegeSet")
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID_")
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	
//	@OrderBy("order") // OrderBy指定排序字段
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	
	

}
