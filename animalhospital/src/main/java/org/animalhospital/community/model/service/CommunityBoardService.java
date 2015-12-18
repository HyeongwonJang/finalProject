package org.animalhospital.community.model.service;

import org.animalhospital.community.model.VO.CommunityBoardVO;
import org.animalhospital.paging.model.VO.ListVO;

public interface CommunityBoardService {
	public void writeCommunity(CommunityBoardVO cbvo);

	public CommunityBoardVO showCommunityBoardContent(int communityBoardNo);
	
	public CommunityBoardVO showCommunityBoardContentNoHit(int communityBoardNo);

	public ListVO findCommunityBoardList(String pageNo);

	public void updateCommunityBoard(CommunityBoardVO cbvo);

	public void deleteCommunityBoard(int communityBoardNo);


}
