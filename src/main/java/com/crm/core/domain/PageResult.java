package com.crm.core.domain;

import java.util.List;

/**
 * 分页算法
 * 
 * @author 余峻豪
 */
public class PageResult {

	/** 总记录数 **/
	private int allRow;  
	/** 总页数 **/
	private int totalPage;
	/** 当前页 **/
	private int currentPage = 1;
	/** 页面显示多少条数据 **/
	private int pageSize = 10;
	/** 分页的数据 **/
	private List<?> list; // 
	
	
	public int getNextPage() {

		int nextPage = currentPage + 1;
		if (nextPage >= totalPage) {
			return currentPage;
		} else {
			return nextPage;
		}
	}

	public int getPreviousPage() {

		int previousPage = currentPage - 1;
		if (previousPage <= 0) {
			return currentPage;
		} else {
			return previousPage;
		}
	}

	public int getAllRow() {
		return allRow;
	}
	
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	
	
}
