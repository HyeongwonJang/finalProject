package org.animalhospital.community.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.community.model.DAO.CommunityBoardDAO;
import org.animalhospital.community.model.VO.CommunityBoardVO;
import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.paging.model.bean.PagingBean;
import org.springframework.stereotype.Service;

@Service
public class CommunityBoardServiceImpl implements CommunityBoardService{
	@Resource
	private CommunityBoardDAO communityBoardDAO;
	
	@Override
	public void writeCommunity(CommunityBoardVO cbvo) {
			communityBoardDAO.writeCommunity(cbvo);
	}

	@Override
	   public CommunityBoardVO showCommunityBoardContent(int communityBoardNo){
	      communityBoardDAO.updateCount(communityBoardNo);
	      return communityBoardDAO.showCommunityBoardContent(communityBoardNo);
	   }
	
	@Override
	public CommunityBoardVO showCommunityBoardContentNoHit(int communityBoardNo) {
		return communityBoardDAO.showCommunityBoardContent(communityBoardNo);
	}


	@Override
	public ListVO findCommunityBoardList(String pageNo) {
		if(pageNo==null||pageNo=="") 
			pageNo="1";
		List<CommunityBoardVO> boardList=communityBoardDAO.findCommunityBoardList(pageNo);
		int total=communityBoardDAO.totalContent();
		PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
		ListVO lvo=new ListVO(boardList,paging);
		return lvo;
	}

	@Override
	public void updateCommunityBoard(CommunityBoardVO cbvo) {
		communityBoardDAO.updateCommunityBoard(cbvo);
	}

	@Override
	public void deleteCommunityBoard(int communityBoardNo) {
		communityBoardDAO.deleteCommunityBoard(communityBoardNo);
	}

	
	
}
