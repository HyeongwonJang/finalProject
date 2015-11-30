package org.animalhospital.vet.controller;

import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
	
	@RequestMapping("test.do")
	public String test(HospitalVO vo, VetVO vvo){
		vo.addListObject(vvo);
		return "test";
	}
	
	
	
	
}
