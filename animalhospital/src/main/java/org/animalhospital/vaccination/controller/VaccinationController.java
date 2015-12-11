package org.animalhospital.vaccination.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
import org.animalhospital.vaccination.model.VO.VaccinationVO;
import org.animalhospital.vaccination.service.VaccinationService;
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

	@RequestMapping("registerVaccination.do")
	public String registerVaccination(VaccinationRecordVO vrvo){
		vaccinationService.registerVaccination(vrvo);
		return "redirect:registerVaccinationResult.do";
	}
	
	@RequestMapping("registerVaccinationResult.do")
	public String registerVaccinationResult(){
		return "vaccination/register_result_vaccination";
	}
	
	
	/**
	 * 아이디를 통하여 반려동물 조회
	 */
	@RequestMapping("findPetListById.do")
	@ResponseBody
	public PetOwnerVO findPetListById(HttpServletRequest request ){
		PetOwnerVO povo = (PetOwnerVO) request.getSession(false).getAttribute("loginVO");
		return vaccinationService.findPetListById(povo);
	}
}
