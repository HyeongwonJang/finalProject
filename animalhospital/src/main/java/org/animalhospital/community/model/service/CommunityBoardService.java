package org.animalhospital.community.model.service;

import org.animalhospital.community.model.VO.AnswerBoardVO;
import org.animalhospital.community.model.VO.QuestionBoardVO;
import org.animalhospital.paging.model.VO.ListVO;

public interface CommunityBoardService {
	public void writeCommunity(QuestionBoardVO qbvo);

	public QuestionBoardVO showCommunityBoardContent(int questionBoardNo);
	
	public QuestionBoardVO showCommunityBoardContentNoHit(int questionBoardNo);

	public ListVO findCommunityBoardList(String pageNo);

	public void updateCommunityBoard(QuestionBoardVO qbvo);

	public void deleteCommunityBoard(int questionBoardNo);

	public void reply(AnswerBoardVO abvo);


}
