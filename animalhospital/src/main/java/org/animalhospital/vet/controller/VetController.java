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
	 * 라이센스의 이름과 번호가 존재하는지 확인하여 count(*) return
	 * 존재하면 1 존재하지 않으면 0
	 */
	@RequestMapping("licenseCheck.do")
	@ResponseBody
	public int licenseCheck(VetLicenseVO lvo){
		return vetService.licenseCheck(lvo);
	}
	/**
	 * 병원 검색
	 * 병원이름으로 병원을 검색, 입력한 hospitalName을 포함하고 있다면 HospitalVO리스트로 return
	 */
	@RequestMapping("findHospital.do")
	@ResponseBody
	public List<HospitalVO> findHospital(HttpServletRequest request, String hospitalName){
		 List<HospitalVO> hospitalList=vetService.findHospital(hospitalName);
		 request.setAttribute("hospitalList", hospitalList);
		return hospitalList;
	}
	/**
	 * 수의사 아이디 중복 체크
	 * 수의사의 아이디가 존재하는지 존재하지 않는지 count(*) return
	 * 입력한 아이디가 이미 존재하면 1 존재하지 않으면 0
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
	
	/**
	 * 수의사 로그인
	 */
	/*@RequestMapping("vetLogin.do")
	public String vetLogin(HttpServletRequest request, VetVO vvo){
		VetVO loginResult=vetService.vetLogin(vvo);
		if(vvo!=null){
			request.getSession().setAttribute("vetLogin", loginResult);
		}
		return "home.do";
	}*/
}
