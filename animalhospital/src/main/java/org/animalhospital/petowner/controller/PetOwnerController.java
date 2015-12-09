package org.animalhospital.petowner.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.service.PetOwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetOwnerController {
	@Resource
	private PetOwnerService petOwnerService;
	
	@RequestMapping("findPetListByTel.do")
	@ResponseBody
	public PetOwnerVO findPetListByTel(HttpServletRequest request){
		PetOwnerVO vo = (PetOwnerVO) request.getSession(false).getAttribute("loginVO");
		return petOwnerService.findPetListByTel(vo);
	}
	/**
	 * 보호자 로그인
	 * userLevel로 수의사와 보호자를 구분한다
	 * 수의사 userLevel = "vet"
	 * @param request
	 * @param povo
	 * @return
	 */
	@RequestMapping(value = "loginPetOwner.do", method = RequestMethod.POST)
	public String loginPetOwner(HttpServletRequest request, PetOwnerVO povo){
		PetOwnerVO petOwnerVO = petOwnerService.loginPetOwner(povo);
		if (petOwnerVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", petOwnerVO);
			session.setAttribute("userLevel", "petOwner");
			return "home";
		} else {
			return "account/login_fail";
		}
	}
	//로그아웃
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		return "index";
	}
	
	
	//보호자 회원 정보 수정
	@RequestMapping("updatePetOwner.do")
	public String updatePetOwner(HttpServletRequest request,PetOwnerVO povo){
		petOwnerService.updatePetOwner(povo);
		request.getSession().setAttribute("loginVO", povo);
		return "home";
	}
	// 보호자 전화번호 중복 체크
	@RequestMapping("telCheckAjax.do")
	@ResponseBody
	public String telCheckAjax(PetOwnerVO povo) {		
		return petOwnerService.telCheckPetOwner(povo);
	}
	
	//펫 등록
		@RequestMapping(value = "registerPet.do")
		public String registerPet(PetOwnerVO povo){
			petOwnerService.registerPet(povo);
			return "redirect:registerPetResult.do?" + povo.getPetOwnerNo();
		}
		@RequestMapping("registerPetResult.do")
		public String registerPetResult(){
			return "account/register_pet_result";
		}
	
	//보호자 회원 가입
	@RequestMapping(value = "registerPetOwner.do", method = RequestMethod.POST)
	public String register(PetOwnerVO povo) {
		petOwnerService.registerPetOwner(povo);		
		return "redirect:registerPetOwnerResult.do";
	}											
	@RequestMapping("registerPetOwnerResult.do")
	public String registerPetOwnerResult(){
		return "account/register_petowner_result";
	}
		
		
	
	
	
	
	
	
	
	
}
