package com.crm.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.crm.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * 商品类别
 * 商品类别和商品的关系,* --- * 
 */
@Entity
@Table(name="GOODSCLASSIFICATION_")
public class GoodsClassification extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	/** 类别名称 **/
	private String name;  
	
	/** 商品类别下面的商品,有多个商品 **/
	private Set<Goods> goodsSet = new HashSet<Goods>(); 

	
	
	
	

	@Column(name="NAME_")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(targetEntity=Goods.class,fetch=FetchType.LAZY)
	public Set<Goods> getGoodsSet() {
		return goodsSet;
	}

	public void setGoodsSet(Set<Goods> goodsSet) {
		this.goodsSet = goodsSet;
	}

	
	
	
}
