package com.crm.domain;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.crm.core.domain.BaseEntity;



/**
 * 孩子 
 * 孩子和客户的关系,* --- 1
 */
@Entity
@Table(name="CHILDREN_")
public class Children extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	/** 姓名 **/
	private String name; 
	
	/** 性别 **/
	private boolean sex; 
	/** 生日 **/
	private Date birthday; 
	/** 年龄 **/
	private int age;
	/** 爱好 **/
	private String hobbies; 
	/** 描述 **/
	private String description; 
	/** 属于哪个客户的孩子 **/
	private Client client; 
	
	
	@Column(name="NAME_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="SEX_")
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	@Column(name="BIRTHDAY_")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Transient
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Column(name="DESCRIPTION_")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="HOBBIES_")
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CHILDREN_ID_")
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	

	
	
	
}
