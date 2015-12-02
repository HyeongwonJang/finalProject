package org.animalhospital.petowner.controller;

import java.util.List;

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
	
/*	@RequestMapping("registerPetOwner.do")
	public void registerPetOwner(MemberPetOwnerVO mpovo) {
		System.out.println(mpovo);
	}*/
	
	@RequestMapping(value = "petOwnerLogin.do", method = RequestMethod.POST)
	public String loginPetOwner(HttpServletRequest request, PetOwnerVO povo){
		PetOwnerVO resultVO = petOwnerService.loginPetOwner(povo);
		if (resultVO == null) {
			return "account/login_fail";
		} else {
			request.getSession().setAttribute("povo", resultVO);
			return "redirect:home.do";
		}
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		return "redirect:home.do";
	}
	
}
