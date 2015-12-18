package org.animalhospital.community.model.DAO;

import java.util.List;

import org.animalhospital.community.model.VO.CommunityBoardVO;

public interface CommunityBoardDAO {
	public void writeCommunity(CommunityBoardVO cbvo);
	public  void updateCount(int communityBoardHit);
	public CommunityBoardVO showCommunityBoardContent(int communityBoardNo);
	public List<CommunityBoardVO> findCommunityBoardList(String pageNo);
	public int totalContent();
	public void updateCommunityBoard(CommunityBoardVO cbvo);
	public void deleteCommunityBoard(int communityBoardNo);
}
