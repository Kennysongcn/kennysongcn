package com.kennysongcn.providers.common.utils;


public class PageInfo {
	
	//当前页
	private int page;
	
	//每页多少条
	private int rows;
	private int limit;
	
	//开始条数
	@SuppressWarnings("unused")
	private int start;
	
	
	public int getStart() {
		return (page-1)*limit;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPage() {
		return page-1;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
		
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
	
	
	
	//数据列表
//	private List<T> rows;
	
	
	
	
}
