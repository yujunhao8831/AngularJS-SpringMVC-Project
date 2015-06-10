package com.crm.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @MappedSuperclass : 父类的注解,子类都可以得到继承 
 * 
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	@Id
	@GeneratedValue
	@Column(name = "id_")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}