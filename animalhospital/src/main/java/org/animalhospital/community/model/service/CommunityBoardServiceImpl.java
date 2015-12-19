package org.animalhospital.community.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.community.model.DAO.CommunityBoardDAO;
import org.animalhospital.community.model.VO.AnswerBoardVO;
import org.animalhospital.community.model.VO.QuestionBoardVO;
import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.paging.model.bean.PagingBean;
import org.springframework.stereotype.Service;

@Service
public class CommunityBoardServiceImpl implements CommunityBoardService{
	@Resource
	private CommunityBoardDAO communityBoardDAO;
	
	@Override
	public void writeCommunity(QuestionBoardVO qbvo) {
			communityBoardDAO.writeCommunity(qbvo);
	}

	@Override
	   public QuestionBoardVO showCommunityBoardContent(int questionBoardNo){
	      communityBoardDAO.updateCount(questionBoardNo);
	      return communityBoardDAO.showCommunityBoardContent(questionBoardNo);
	   }
	
	@Override
	public QuestionBoardVO showCommunityBoardContentNoHit(int questionBoardNo) {
		return communityBoardDAO.showCommunityBoardContent(questionBoardNo);
	}


	@Override
	public ListVO findCommunityBoardList(String pageNo) {
		if(pageNo==null||pageNo=="") 
			pageNo="1";
		List<QuestionBoardVO> boardList=communityBoardDAO.findCommunityBoardList(pageNo);
		int total=communityBoardDAO.totalContent();
		PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
		ListVO lvo=new ListVO(boardList,paging);
		return lvo;
	}

	@Override
	public void updateCommunityBoard(QuestionBoardVO qbvo) {
		communityBoardDAO.updateCommunityBoard(qbvo);
	}

	@Override
	public void deleteCommunityBoard(int questionBoardNo) {
		communityBoardDAO.deleteCommunityBoard(questionBoardNo);
	}

	
	@Override
	public void reply(AnswerBoardVO abvo) {
		int ref = abvo.getRef();
		int restep = abvo.getReStep();
		int relevel = abvo.getReLevel();
		communityBoardDAO.updateRestep(ref, restep);
		abvo.setReStep(restep+1);
		abvo.setReLevel(relevel+1);
		communityBoardDAO.insertRefContent(abvo);//답변 글 입력								
	}

	
	
}
