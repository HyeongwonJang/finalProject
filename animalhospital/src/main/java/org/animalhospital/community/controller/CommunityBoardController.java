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
	    * 글 작성
	    */
	@RequestMapping(value="writeCommunity.do",method=RequestMethod.POST)	
	public ModelAndView writeCommunity(QuestionBoardVO qbvo) {
		communityBoardService.writeCommunity(qbvo);
		return new ModelAndView("redirect:showCommunityBoardContentNoHit.do?questionBoardNo="+qbvo.getQuestionBoardNo());
	}	
	
	    /**
	    * 글 상세 보기, 조회수 증가
	    */
	   @RequestMapping("showCommunityBoardContent.do")
	   public ModelAndView showContent(int questionBoardNo) {      
		   QuestionBoardVO qbvo=communityBoardService.showCommunityBoardContent(questionBoardNo);  
		   System.out.println("조회값: " + qbvo);
	      return new ModelAndView("showContent_community","qbvo",qbvo);
	   }
	   @RequestMapping("showCommunityBoardContentNoHit.do")
	   public ModelAndView showContentNoHit(int questionBoardNo) {      
	      return new ModelAndView("showContent_community","qbvo",communityBoardService.showCommunityBoardContentNoHit(questionBoardNo));
	   }
	   
	   /**
	    * 게시판 목록 
	    */
	   @RequestMapping("findCommunityBoardList.do")
	   public ModelAndView findCommunityBoardList(String pageNo){
	      return new ModelAndView("list_community","lvo",communityBoardService.findCommunityBoardList(pageNo));
	   }
	   
	   /**
	    * 게시판 수정 
	    */
	   @RequestMapping("updateCommunityView.do")
		public ModelAndView updateCommunityView(int questionBoardNo){
			return new ModelAndView("update_community","qbvo",communityBoardService.showCommunityBoardContentNoHit(questionBoardNo));
		}
	   @RequestMapping(value="updateCommunityBoard.do", method = RequestMethod.POST)
	   public ModelAndView updateCommunityBoard(QuestionBoardVO qbvo){
		   communityBoardService.updateCommunityBoard(qbvo);
		   System.out.println(qbvo);
		   return new ModelAndView("redirect:showCommunityBoardContentNoHit.do?questionBoardNo="+qbvo.getQuestionBoardNo());
	   }
	  
	   /**
	    * 게시판 삭제 
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
