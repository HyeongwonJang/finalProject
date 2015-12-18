package org.animalhospital.community.controller;

import javax.annotation.Resource;

import org.animalhospital.community.model.VO.CommunityBoardVO;
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
	 * 게시글을 insert 
	 * 새로고침시 재입력을 막기 위해 redirect 시킨다. 
	 * post 방식일때만 등록가능
	 * 회원정보를 세션에서 반환받아 BoardVO에 할당한다 
	 */
	@RequestMapping(value="writeCommunity.do",method=RequestMethod.POST)	
	public ModelAndView writeCommunity(CommunityBoardVO cbvo) {
		communityBoardService.writeCommunity(cbvo);
		return new ModelAndView("redirect:showCommunityBoardContentNoHit.do?communityBoardNo="+cbvo.getCommunityBoardNo());
	}	
	
	/**
	    * 게시글 조회 , 조회수 업데이트
	    * 개별 게시물 보여준다.    
	    * @param request
	    * @param response
	    * @return
	    * @
	    */
	   @RequestMapping("showCommunityBoardContent.do")
	   public ModelAndView showContent(int communityBoardNo) {      
	      CommunityBoardVO cbvo=communityBoardService.showCommunityBoardContent(communityBoardNo);   
	      return new ModelAndView("showContent_community","cbvo",cbvo);
	   }
	   @RequestMapping("showCommunityBoardContentNoHit.do")
	   public ModelAndView showContentNoHit(int communityBoardNo) {      
	      return new ModelAndView("showContent_community","cbvo",communityBoardService.showCommunityBoardContentNoHit(communityBoardNo));
	   }
	   
	   /**
	    * 게시판 목록 
	    * @param pageNo
	    * @return
	    */
	   @RequestMapping("findCommunityBoardList.do")
	   public ModelAndView findCommunityBoardList(String pageNo){
	      return new ModelAndView("list_community","lvo",communityBoardService.findCommunityBoardList(pageNo));
	   }
	   
	   /**
	    * 게시판 수정 
	    * @param pageNo
	    * @return
	    */
	   @RequestMapping("updateCommunityView.do")
		public ModelAndView updateCommunityView(int communityBoardNo){
			return new ModelAndView("update_community","cbvo",communityBoardService.showCommunityBoardContentNoHit(communityBoardNo));
		}
	   @RequestMapping(value="updateCommunityBoard.do", method = RequestMethod.POST)
	   public ModelAndView updateCommunityBoard(CommunityBoardVO cbvo){
		   communityBoardService.updateCommunityBoard(cbvo);
		   System.out.println(cbvo);
		   return new ModelAndView("redirect:showCommunityBoardContentNoHit.do?communityBoardNo="+cbvo.getCommunityBoardNo());
	   }
	  
	   /**
	    * 게시판 삭제 
	    * @param pageNo
	    * @return
	    */
	   @RequestMapping("deleteCommunityBoard.do")
	   public ModelAndView deleteCommunityBoard(int communityBoardNo){
		   communityBoardService.deleteCommunityBoard(communityBoardNo);
		   return new ModelAndView("redirect:findCommunityBoardList.do");
	   }
	
}
