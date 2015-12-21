package org.animalhospital.community.controller;

import javax.annotation.Resource;

import org.animalhospital.community.model.VO.AnswerBoardVO;
import org.animalhospital.community.model.VO.QuestionBoardVO;
import org.animalhospital.community.model.service.CommunityBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommunityBoardController {
	@Resource
	private CommunityBoardService communityBoardService;
	
	/**
	 * 1:1 문의 게시판 글 작성 메서드
	 * @param QuestionBoardVO
	 * @author 강신후 , 곽진혁
	 */
	@RequestMapping(value="writeCommunity.do",method=RequestMethod.POST)	
	public ModelAndView writeCommunity(QuestionBoardVO qbvo) {
		communityBoardService.writeCommunity(qbvo);
		return new ModelAndView("redirect:showCommunityBoardContentNoHit.do?questionBoardNo="+qbvo.getQuestionBoardNo());
	}	
	
	/**
	 * 1:1 문의 게시판 글 상세 보기 메서드
	 * @param int
	 * @author 강신후 , 곽진혁
	 */
	   @RequestMapping("showCommunityBoardContent.do")
	   public ModelAndView showContent(int questionBoardNo) {      
		 QuestionBoardVO qbvo=communityBoardService.showCommunityBoardContent(questionBoardNo);  
	   return new ModelAndView("showContent_community","qbvo",qbvo);
	   }
	   /**
		 * 1:1 문의 게시판 조회수 증가 시키기는 메소드
		 * @param int
		 * @author 강신후 , 곽진혁
		 */
	   @RequestMapping("showCommunityBoardContentNoHit.do")
	   public ModelAndView showContentNoHit(int questionBoardNo) {      
	      return new ModelAndView("showContent_community","qbvo",communityBoardService.showCommunityBoardContentNoHit(questionBoardNo));
	   }
	   
	   /**
		 * 1:1 문의 게시판 전제 글 목록 출력하는 메소드
		 * @param String
		 * @author 강신후 , 곽진혁
		 */
	   @RequestMapping("findCommunityBoardList.do")
	   public ModelAndView findCommunityBoardList(String pageNo){
	      return new ModelAndView("list_community","lvo",communityBoardService.findCommunityBoardList(pageNo));
	   }
	   
	   /**
		 * 1:1 문의 게시판 글 수정 처리하는 메소드
		 * @param QuestionBoardVO
		 * @author 강신후 , 곽진혁
		 */
	   @RequestMapping(value="updateCommunityBoard.do", method = RequestMethod.POST)
	   public ModelAndView updateCommunityBoard(QuestionBoardVO qbvo){
		   communityBoardService.updateCommunityBoard(qbvo);
		   System.out.println(qbvo);
		   return new ModelAndView("redirect:showCommunityBoardContentNoHit.do?questionBoardNo="+qbvo.getQuestionBoardNo());
	   }
	  
	   /**
		 * 1:1 문의 게시판 글 삭제 처리하는 메소드
		 * @param int
		 * @author 강신후 , 곽진혁
		 */
	   @RequestMapping("deleteCommunityBoard.do")
	   public ModelAndView deleteCommunityBoard(int questionBoardNo){
		   communityBoardService.deleteCommunityBoard(questionBoardNo);
		   return new ModelAndView("redirect:findCommunityBoardList.do");
	   }
	   
	    /**
		 * 답변을 처리 
		 */
		@RequestMapping("replyCommunity.do")
		public ModelAndView reply(AnswerBoardVO abvo){		
			communityBoardService.reply(abvo);		
			return new ModelAndView("redirect:showContentNoHit.do?questionBoardNo="+abvo.getAnswerBoardNo());
		}
	
}
