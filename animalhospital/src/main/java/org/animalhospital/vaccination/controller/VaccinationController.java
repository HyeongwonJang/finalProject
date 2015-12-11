package org.animalhospital.vaccination.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
import org.animalhospital.vaccination.service.VaccinationService;
import org.animalhospital.vet.model.VO.HospitalVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VaccinationController {

	@Resource(name="vaccinationServiceImpl")
	private VaccinationService vaccinationService;

	/**
	 * 예방접종등록 페이지를 호출하는 컨트롤러
	 * 반려동물 정보를 세션에 담긴 정보를 기반으로 호출한다
	 * 또한 예방접종목록 정보를 호출한다
	 * @return
	 */
	@RequestMapping("registerVaccinationView.do")
	public ModelAndView registerVaccinationView() {
		return new ModelAndView("register_vaccination", 
				"VaccinationList", vaccinationService.findAllVaccination());
	}
	@RequestMapping("registerVaccination.do")
	public String registerVaccination(HttpServletRequest request, VaccinationRecordVO vrvo){
		if(request.getSession().getAttribute("userLevel").equals("vet")){
			System.out.println(request.getSession().getAttribute("userLevel"));
			vrvo.setHospitalVO(((HospitalVO)request.getSession().getAttribute("loginVO")));
		}
		System.out.println(vrvo);
		vaccinationService.registerVaccination(vrvo);
		return "redirect:registerVaccinationResult.do";
	}
	@RequestMapping("registerVaccinationResult.do")
	public String registerVaccinationResult(){
		return "vaccination/register_vaccination_result";
	}
	
	@RequestMapping("findVaccinationRecordByPetOwnerTelAndPetName.do")
	public ModelAndView findVaccinationRecordByPetOwnerTelAndPetName(
			HttpServletRequest request, PetOwnerVO povo, ListVO lvo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("povo", povo);
		paramMap.put("listVO", lvo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("recordList", vaccinationService.findVaccinationRecordByPetOwnerTelAndPetName(paramMap));
		mav.addObject("continueParam", paramMap);
		System.out.println(paramMap);
		if(request.getSession(false).getAttribute("userLevel").equals("vet")){
			mav.setViewName("find_vet_vaccination");
		} else if(request.getSession(false).getAttribute("userLevel").equals("petOwner")){
			mav.setViewName("find_petOwner_vaccination");
		}
		return mav;
	}
	
	
	
/*	*//**
	 * 아이디를 통하여 반려동물 조회
	 *//*
	@RequestMapping("findPetListById.do")
	@ResponseBody
	public PetOwnerVO findPetListById(HttpServletRequest request ){
		PetOwnerVO povo = (PetOwnerVO) request.getSession(false).getAttribute("loginVO");
		return vaccinationService.findPetListById(povo);
	}*/
}
