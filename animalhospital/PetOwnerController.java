package org.animalhospital.petowner.controller;

import org.animalhospital.petowner.model.VO.MemberPetOwnerVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetOwnerController {
	
	
	@RequestMapping("petownerLogin.do")
	public String petOwnerLogin(MemberPetOwnerVO vo){
		System.out.println(vo);
		// session 구현부 집어넣기
		return "redirect:home.do";
	}
}
