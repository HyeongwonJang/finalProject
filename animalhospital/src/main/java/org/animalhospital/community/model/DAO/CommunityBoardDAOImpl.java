package org.animalhospital.community.model.DAO;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.community.model.VO.AnswerBoardVO;
import org.animalhospital.community.model.VO.QuestionBoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityBoardDAOImpl implements CommunityBoardDAO{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void writeCommunity(QuestionBoardVO qbvo) {
		sqlSessionTemplate.insert("communityBoard.writeCommunity",qbvo);
	}

	@Override
	public void updateCount(int questionBoardHit) {
		sqlSessionTemplate.update("communityBoard.updateCommunityBoardHit",questionBoardHit);
	}

	@Override
	   public QuestionBoardVO showCommunityBoardContent(int questionBoardNo){
	      return (QuestionBoardVO)sqlSessionTemplate.selectOne("communityBoard.showCommunityBoardContent",questionBoardNo);
	   }

	@Override
	public List<QuestionBoardVO> findCommunityBoardList(String pageNo) {
		return sqlSessionTemplate.selectList("communityBoard.findCommunityBoardList",pageNo);
	}

	@Override
	public int totalContent() {
		return sqlSessionTemplate.selectOne("communityBoard.totalContent");
	}

	@Override
	public void updateCommunityBoard(QuestionBoardVO qbvo) {
		sqlSessionTemplate.update("communityBoard.updateCommunityBoard",qbvo);
	}

	@Override
	public void deleteCommunityBoard(int questionBoardNo) {
		sqlSessionTemplate.delete("communityBoard.deleteCommunityBoard",questionBoardNo);
	}

	@Override
	public void updateRestep(int ref, int restep) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("ref", ref);
		map.put("restep", restep);
		sqlSessionTemplate.update("communityBoard.updateRestep", map);		
	}
	@Override
	public void insertRefContent(AnswerBoardVO abvo){
		sqlSessionTemplate.insert("communityBoard.writeReply", abvo);		
	}

	
	
	
	
}
