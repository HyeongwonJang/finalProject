package org.animalhospital.vet.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.animalhospital.vet.model.VO.VetVO;
import org.animalhospital.vet.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VetController {
	@Resource
	private VetService vetService;

	@RequestMapping("test.do")
	public String test(HospitalVO vo, VetVO vvo){
		vo.addListObject(vvo);
		return "test";
	}
	
	/**
	 * 수의사 등록
	 */
	@RequestMapping("register_vet.do")
	public String registerVet(HospitalVO hvo){
		vetService.registerVet(hvo);
		return "home.do";
	}
	/**
	 * 라이센스 체크
	 */
	@RequestMapping("licenseCheck.do")
	@ResponseBody
	public int licenseCheck(VetLicenseVO lvo){
		System.out.println(lvo);
		return vetService.licenseCheck(lvo);
	}
	/**
	 * 병원 검색
	 */
	@RequestMapping("findHospital.do")
	@ResponseBody
	public List<HospitalVO> findHospital(HttpServletRequest request, String hospitalName){
		 List<HospitalVO> hospitalList=vetService.findHospital(hospitalName);
		 request.setAttribute("hospitalList", hospitalList);
		return /*new ModelAndView("find_hospital_result_view.do", "hospitalList", hospitalList)*/hospitalList;
	}
	/**
	 * 수의사 아이디 중복 체크
	 */
	@RequestMapping("findVetById.do")
	@ResponseBody
	public int findVetById(HttpServletResponse response, String vetId){
		return vetService.findVetById(vetId);
	}
	
	@RequestMapping("testAjax.do")
	@ResponseBody
	public String testAjax(){
		return "테스트 성공";
	}
	@RequestMapping("findAllHospitalAjax.do")
	@ResponseBody
	public List<HospitalVO> findAllHospitalAjax(){
		return vetService.findAllHospital();
	}
	
	/**
	 * 수의사 로그인
	 *//*
	@RequestMapping("vetLogin.do")
	public String vetLogin(HttpServletRequest request, VetVO vvo){
		VetVO loginResult=vetService.vetLogin(vvo);
		if(vvo!=null){
			request.getSession().setAttribute("vetLogin", loginResult);
		}
		return "home.do";
	}*/
}
