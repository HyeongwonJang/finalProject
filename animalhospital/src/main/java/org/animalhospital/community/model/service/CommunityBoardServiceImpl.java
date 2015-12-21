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
	
	/**
	 * 1:1 문의 게시판 글 작성 메서드
	 * @param QuestionBoardVO
	 * @author 강신후 , 곽진혁
	 */
	@Override
	public void writeCommunity(QuestionBoardVO qbvo) {
			communityBoardDAO.writeCommunity(qbvo);
	}

	/**
	 * 1:1 문의 게시판 글 상세 보기 메서드 (showCommunityBoardContent)
	 * 조회수 증가시키는 메서드 (updateCount)
	 * @param int
	 * @author 강신후 , 곽진혁
	 */
	@Override
	   public QuestionBoardVO showCommunityBoardContent(int questionBoardNo){
	      communityBoardDAO.updateCount(questionBoardNo);
	      return communityBoardDAO.showCommunityBoardContent(questionBoardNo);
	   }
	/**
	 * 1:1 문의 게시판 글 상세 보기 메서드 
	 * writeCommunity와 updateCommunityBoard는 조회수를 증가시키지 않는다.
	 * @param int
	 * @author 강신후 , 곽진혁
	 */
	@Override
	public QuestionBoardVO showCommunityBoardContentNoHit(int questionBoardNo) {
		return communityBoardDAO.showCommunityBoardContent(questionBoardNo);
	}


	 /**
	 * 1:1 문의 게시판 전체 글 목록 출력하는 메소드 (findCommunityBoardList)
	 * 전체 글 갯수 구하는 메소드 (totalContent)
	 * @param String
	 * @author 강신후 , 곽진혁
	 */
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

	/**
	 * 1:1 문의 게시판 글 수정 처리하는 메소드
	 * @param QuestionBoardVO
	 * @author 강신후 , 곽진혁
	 */
	@Override
	public void updateCommunityBoard(QuestionBoardVO qbvo) {
		communityBoardDAO.updateCommunityBoard(qbvo);
	}

	/**
	 * 1:1 문의 게시판 글 삭제 처리하는 메소드
	 * @param int
	 * @author 강신후 , 곽진혁
	 */
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
