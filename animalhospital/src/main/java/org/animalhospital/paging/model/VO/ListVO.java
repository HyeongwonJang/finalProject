package org.animalhospital.paging.model.VO;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.community.model.VO.CommunityBoardVO;
import org.animalhospital.paging.model.bean.PagingBean;
import org.springframework.stereotype.Component;

@Component
public class ListVO {
	private List<Object> list;
	private List<CommunityBoardVO> boardList;
	private String startDate;
	private String endDate;
	private int page;
	@Resource
	private PagingBean pagingBean;
	public ListVO() {
		super();
	}
	public ListVO(List<CommunityBoardVO> boardList, PagingBean pagingBean) {
		super();
		this.boardList = boardList;
		this.pagingBean = pagingBean;
	}
	public ListVO(List<Object> list, List<CommunityBoardVO> boardList,
			String startDate, String endDate, int page, PagingBean pagingBean) {
		super();
		this.list = list;
		this.boardList = boardList;
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
	public List<CommunityBoardVO> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<CommunityBoardVO> boardList) {
		this.boardList = boardList;
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
		return "ListVO [list=" + list + ", boardList=" + boardList
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", page=" + page + ", pagingBean=" + pagingBean + "]";
	}
	
	
		
}
