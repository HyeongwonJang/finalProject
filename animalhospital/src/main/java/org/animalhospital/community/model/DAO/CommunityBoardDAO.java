package org.animalhospital.community.model.DAO;

import java.util.List;

import org.animalhospital.community.model.VO.AnswerBoardVO;
import org.animalhospital.community.model.VO.QuestionBoardVO;

public interface CommunityBoardDAO {

	public void writeCommunity(QuestionBoardVO qbvo);

	public void updateCount(int questionBoardHit);

	public QuestionBoardVO showCommunityBoardContent(int questionBoardNo);

	public List<QuestionBoardVO> findCommunityBoardList(String pageNo);

	public int totalContent();

	public void updateCommunityBoard(QuestionBoardVO qbvo);

	public void deleteCommunityBoard(int questionBoardNo);

	public void updateRestep(int ref, int restep);

	public void insertRefContent(AnswerBoardVO abvo);

	
}
