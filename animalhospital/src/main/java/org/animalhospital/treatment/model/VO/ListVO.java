package org.animalhospital.treatment.model.VO;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.treatment.model.bean.PagingBean;
import org.springframework.stereotype.Component;

@Component
public class ListVO {
	private List<Object> list;
	@Resource
	private PagingBean pagingBean;
	public ListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListVO(List<Object> list, PagingBean pagingBean) {
		super();
		this.list = list;
		this.pagingBean = pagingBean;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public PagingBean getPagingBean() {
		return pagingBean;
	}
	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}
	
	
		
}
