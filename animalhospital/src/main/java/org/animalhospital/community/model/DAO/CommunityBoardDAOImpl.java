package org.animalhospital.community.model.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.community.model.VO.CommunityBoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityBoardDAOImpl implements CommunityBoardDAO{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void writeCommunity(CommunityBoardVO cbvo) {
		sqlSessionTemplate.insert("communityBoard.writeCommunity",cbvo);
	}

	@Override
	public void updateCount(int communityBoardHit) {
		sqlSessionTemplate.update("communityBoard.updateCommunityBoardHit",communityBoardHit);
	}

	@Override
	   public CommunityBoardVO showCommunityBoardContent(int communityBoardNo){
	      return (CommunityBoardVO)sqlSessionTemplate.selectOne("communityBoard.showCommunityBoardContent",communityBoardNo);
	   }

	@Override
	public List<CommunityBoardVO> findCommunityBoardList(String pageNo) {
		return sqlSessionTemplate.selectList("communityBoard.findCommunityBoardList",pageNo);
	}

	@Override
	public int totalContent() {
		return sqlSessionTemplate.selectOne("communityBoard.totalContent");
	}

	@Override
	public void updateCommunityBoard(CommunityBoardVO cbvo) {
		sqlSessionTemplate.update("communityBoard.updateCommunityBoard",cbvo);
	}

	@Override
	public void deleteCommunityBoard(int communityBoardNo) {
		sqlSessionTemplate.delete("communityBoard.deleteCommunityBoard",communityBoardNo);
	}

	
	
	
	
}
