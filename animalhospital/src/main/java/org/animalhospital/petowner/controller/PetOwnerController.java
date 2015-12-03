package org.animalhospital.petowner.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.service.PetOwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PetOwnerController {
	@Resource
	private PetOwnerService petOwnerService;
	
	@RequestMapping(value = "petOwnerLogin.do", method = RequestMethod.POST)
	public String loginPetOwner(HttpServletRequest request, PetOwnerVO povo){
		PetOwnerVO petOwnerVO = petOwnerService.loginPetOwner(povo);
		if (petOwnerVO != null) {
			request.getSession().setAttribute("povo", petOwnerVO);
			return "home";
		} else {
			return "account/login_fail";
		}
	}
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		return "index";
	}
	
	@RequestMapping(value = "registerPetOwner.do", method = RequestMethod.POST)
	public String register(PetOwnerVO povo) {
		petOwnerService.registerPetOwner(povo);		
		return "redirect:registerResultView" + povo.getPetOwnerId();
	}
	
	@RequestMapping(value = "updatePetOwner.do", method = RequestMethod.POST)
	public String updatePetOwner(HttpServletRequest request, PetOwnerVO povo) {
		HttpSession session = request.getSession(false);
		String path = "redirect:login";
		if (session != null) {
			petOwnerService.updatePetOwner(povo);
			session.setAttribute("povo", povo);
			path = "redirect:update_result";
		}
		return path;
	} 
	
}
