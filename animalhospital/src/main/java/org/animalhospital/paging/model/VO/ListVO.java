package org.animalhospital.paging.model.VO;

import java.util.List;

import javax.annotation.Resource;
import org.animalhospital.paging.model.bean.PagingBean;
import org.springframework.stereotype.Component;

@Component
public class ListVO {
	private List<Object> list;
	private String startDate;
	private String endDate;
	private int page;
	@Resource
	private PagingBean pagingBean;
	public ListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListVO(List<Object> list, String startDate, String endDate,
			int page, PagingBean pagingBean) {
		super();
		this.list = list;
		this.startDate = startDate;
		this.endDate = endDate;
		this.page = page;
		this.pagingBean = pagingBean;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public PagingBean getPagingBean() {
		return pagingBean;
	}
	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}
	@Override
	public String toString() {
		return "ListVO [list=" + list + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", page=" + page + ", pagingBean="
				+ pagingBean + "]";
	}
	
	
		
}
