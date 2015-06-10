package com.crm.core.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.crm.core.domain.PageResult;
import com.crm.core.exception.ClassfindPageException;
import com.crm.utils.ReflectBaseGenericsTypesUtil;

@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<M extends Serializable> implements BaseDao<M> {

	@Autowired
	private SessionFactory sessionFactory;

	/** Model */
	private final Class<M> modelClass;

	/** 查询某实体所有记录的HQL语句(相当于 SELECT * FROM 某实体) */
	private final String HQL_LIST_ALL;
	/** 查询某实体所有记录数的HQL语句(相当于 SELECT COUNT(*) FROM 某实体) */
	private final String HQL_COUNT_ALL;

	public BaseDaoImpl() {
		// 通过ReflectBaseGenericsTypesUtil.getBaseGenericsTypes得到 Model
		this.modelClass = ReflectBaseGenericsTypesUtil.getBaseGenericsTypes(this.getClass());
		// 如果是User实体那么this.modelClass.getSimpleName()返回的结果就是User字符串.
		HQL_LIST_ALL = "FROM " + this.modelClass.getSimpleName() + "  ";
		HQL_COUNT_ALL = "SELECT COUNT(*) FROM " + this.modelClass.getSimpleName() + "  ";
	}

	/**
	 * 供子类是用
	 * 
	 * @return Session
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(M model) {
		getSession().save(model);
	}

	@Override
	public void update(M model) {
		getSession().update(model);
	}

	@Override
	public void save(M model) {
		getSession().saveOrUpdate(model);
	}

	@Override
	public void delete(Serializable id) {
		getSession().delete(get(id));
	}
	

	@Override
	public M get(Serializable id) {
		if (id == null) {
			return null;
		}
		return (M) getSession().get(modelClass, id);
	}
	@Override
	public Collection<M> getByIds(Serializable[] ids) {
		if(ids == null || ids.length == 0){
			return null;
		}
		
		List<M> list = getSession().createQuery(//
				"FROM " + this.modelClass.getSimpleName() + " WHERE id in (:ids)")//
				.setParameterList("ids", ids) //
				.list();
		return list;
	}

	@Override
	public Long findCountAll() {
		return (Long) getSession().createQuery(HQL_COUNT_ALL).uniqueResult();
	}

	@Override
	public List<M> findAll() {
		return getSession().createQuery(HQL_LIST_ALL).list();
	}

	/**
	 * sqlFilter : 分页条件(可选)
	 * jumpPageNumber : 需要那一页的数据
	 * pageSize : 每一页显示多少条数据
	 */
	@Override
	public PageResult findPage(String sqlFilter,final int nextPageNumber,final int pageSize) throws ClassfindPageException {
		if(null == sqlFilter){
			sqlFilter = "";
		}
		
		PageResult pageResult = new PageResult();
		
		// 得到总记录数
		int allRow = ((Long) getSession().createQuery(HQL_COUNT_ALL + sqlFilter).uniqueResult()).intValue();
		
		// 计算总页数
		int totalPage = getTotalPage(pageSize, allRow); 

		// 得到当前页,开始记录(如果是第3页,按每10条记录为一页的话,那么当前也的记录就是 31)
		int pageStartRow = getPageStartRow(pageSize, nextPageNumber); 

		if (pageStartRow < 0) {
			pageStartRow = 0;
		}

		/** 计算当前是第几页 **/
		final int currentPage = getCurrentPage(nextPageNumber);

		List<?> list = getSession().createQuery(HQL_LIST_ALL) // HQL 分页
					.setFirstResult(pageStartRow) // 从数据库中哪一行记录开始取
					.setMaxResults(pageSize) 	  // 取多少条数据
					.list();
		
		/** 设置当前是第几页 **/
		pageResult.setCurrentPage(currentPage);
		/** 设置总记录数 **/
		pageResult.setAllRow(allRow);
		/** 设置总页数 **/
		pageResult.setTotalPage(totalPage);
		/** 设置每页的数据 **/
		pageResult.setList(list);
		
		return pageResult;
	}

	/**
	 * 计算总页数
	 * @param pageSize 每页记录数
	 * @param allRow 总记录数
	 * @return 总页数
	 */
	private int getTotalPage(final int pageSize, final int allRow) {
		
		int totalPage;
		if (allRow != 0) {
			/*
			 * if (总记录数 % 每页记录数 == 0 ) {
			 * 		总页数 = 总记录数 除以 每页记录数
			 * } else {
			 * 		总页数 = 总记录数 除以 每页记录数 + 1
			 * }
			 */
			totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
		} else {
			totalPage = 1;
		}
		return totalPage;
	}
	/**
	 * 计算当前页是从第几条记录开始的,那么就从数据库中那一行开始取数据
	 * @param pageSize 每页记录数
	 * @param currentPage 当前第几页
	 * @return 当前页起始记录号的偏移量
	 */
	private int getPageStartRow(final int pageSize, final int currentPage) {
		// 当前页的开始记录 = 每页显示多少条记录 * (当前第几页 - 1) 
		final int pageStartRow = pageSize * (currentPage - 1);
		return pageStartRow;
	}
	
	/**
	 * 计算当前页,若为0或者请求的URL中没有"?page=",则用1代替
	 * 
	 * @param page 传入的参数(可能为空,即0,则返回1)
	 * @return 当前页
	 */
	private int getCurrentPage(int page) {
		final int curPage = (page == 0 ? 1 : page);
		return curPage;
	}

}
