package org.animalhospital.vet.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.animalhospital.vet.model.VO.VetVO;
import org.animalhospital.vet.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VetController {
	@Resource
	private VetService vetService;

	@RequestMapping("findAllHospitalAjax.do")
	@ResponseBody
	public List<HospitalVO> findAllHospitalAjax(){
		return vetService.findAllHospital();
	}
	
	@RequestMapping("test.do")
	public String test(HospitalVO vo, VetVO vvo){
		vo.addListObject(vvo);
		return "test";
	}
	
	/**
	 * 수의사 등록
	 */
	@RequestMapping("registerVet.do")
	public String registerVet(HospitalVO hvo){
		System.out.println(hvo);
		//vetService.registerVet(hvo);
		return "home.do";
	}
	/**
	 * 라이센스 체크
	 *//*
	@RequestMapping("licenseCheck.do")
	public ModelAndView licenseCheck(VetLicenseVO lvo){
		return new ModelAndView("license_check_result_view.do","licenseCheck", vetService.licenseCheck(lvo));
	}
	*//**
	 * 병원 검색
	 *//*
	@RequestMapping("findHospital.do")
	public ModelAndView findHospital(String hospitalName){
		List<HospitalVO> hospitalList=vetService.findHospital(hospitalName);
		return new ModelAndView("find_hospital_result_view.do", "hospitalList", hospitalList);
	}
	*//**
	 * 수의사 아이디 중복 체크
	 *//*
	@RequestMapping("findVetById.do")
	public ModelAndView findVetById(String vetId){
		return new ModelAndView("vet_id_check_result_view.do","vetIdCheck",vetService.findVetById(vetId));
	}
	*//**
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
