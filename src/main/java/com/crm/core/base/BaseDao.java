package com.crm.core.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.crm.core.domain.PageResult;
import com.crm.core.exception.ClassfindPageException;


/**
 * 所有Dao的基类
 * 所有的增删改查以及分页的实现
 * 子类如有特殊业务需求,自行添加即可
 * @author 余峻豪
 * 
 * @param <M>  : 模型(实体)
 * @param <PK> : ID(映射到数据库的主键类型)
 */
public interface BaseDao<M extends Serializable> {

	/** 增加 */
	 void add(M model);
	/** 修改 */
	 void update(M model);
	/** 增加Or修改 */
	 void save(M model);
	/** 删除 */
	 void delete(Serializable id);
	/** 加载,查询 */
	 M get(Serializable id);
	 /** 批量查询 */
	 Collection<M> getByIds(Serializable[] ids);
	
	 /** 查询所有记录数 */
	 Long findCountAll();
	 
	/** 查询所有 */
	 List<M> findAll();
	
	/**
	 * 分页查询
	 * 不同模块查询时，有具体不同的代码
	 * 为了能是代码能够得到更大的重用.
	 * 一般分页大致上是相同的,但是可能有具体查询条件,比如说 : 
	 * 		部门模块中,按照部门名称,部门编号查询.
	 * 		职位模块中,按照薪水多少,家庭住址查询.
	 * 
	 * @param  sqlFilter 		 : 分页条件 (WHERE ....)
	 * @param  nextPageNumber    : 需要拿到那一页的数据 
	 * @param  pageSize  	     : 每页行数
	 * 
	 * @return PageResult(result : 一页数据,rowCount : 总页数).
	 * @throws ClassfindPageException : 查询实体失败,没有这个实体
	 */
	PageResult findPage(String sqlFilter, int nextPageNumber, int pageSize) throws ClassfindPageException;
	
	
//	void ExcelReader(InputStream inputStream);

}
