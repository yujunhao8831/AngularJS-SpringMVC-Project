package com.crm.core.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.core.domain.PageResult;
import com.crm.core.exception.ClassfindPageException;


public abstract class BaseServiceImpl<M extends Serializable,DAO extends BaseDao<M>> implements BaseService<M,DAO> {

	@Autowired
	protected DAO dao;

	@Override
	public PageResult findPage(String sqlFilter, int nextPageNumber, int pageSize) throws ClassfindPageException {
		return dao.findPage(sqlFilter, nextPageNumber, pageSize);
	}

	@Override
	public void add(M model) {
		dao.add(model);
	}

	@Override
	public void update(M model) {
		dao.update(model);
	}

	@Override
	public void save(M model) {
		dao.save(model);
	}

	@Override
	public void delete(Serializable id) {
		dao.delete(id);
	}

	@Override
	public M get(Serializable id) {
		return dao.get(id);
	}
	
	@Override
	public Collection<M> getByIds(Serializable[] ids) {
		return dao.getByIds(ids);
	}

	@Override
	public List<M> findAll() {
		return (List<M>) dao.findAll();
	}

	@Override
	public Long findCountAll() {
		return dao.findCountAll();
	}

}
