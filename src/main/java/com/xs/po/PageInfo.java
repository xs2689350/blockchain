package com.xs.po;

import java.util.List;

public class PageInfo 
{
	private Integer total;
	private Integer page;
	private Integer count;
	private List<Object> rows;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Object> getRows() {
		return rows;
	}
	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
	
	public void addPage()
	{
		this.page++;
	}
	public void subPage()
	{
		this.page--;
	}

}
