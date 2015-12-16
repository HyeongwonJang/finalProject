package org.animalhospital.vaccination.controller;

import java.text.ParseException;
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
	 * 예방접종 등록
	 * userLevel이 vet인 경우 
	 * 예방접종 등록페이지에서 받아온 vrvo의 hospitalVO에 session loginVO정보를 등록한 뒤 service로 보냄 
	 * @param request
	 * @param vrvo
	 * @return
	 */
	@RequestMapping("registerVaccination.do")
	public String registerVaccination(HttpServletRequest request, VaccinationRecordVO vrvo){
		if(request.getSession().getAttribute("userLevel").equals("vet")){
			vrvo.setHospitalVO(((HospitalVO)request.getSession().getAttribute("loginVO")));
			vaccinationService.registerVetVaccination(vrvo);
		}
		else{
			vaccinationService.registerVaccination(vrvo);
		}
		return "redirect:registerVaccinationResult.do";
	}
	@RequestMapping("registerVaccinationResult.do")
	public String registerVaccinationResult(){
		return "vaccination/register_result_vaccination";
	}
	
	/**
	 * 백신진료내역 조회
	 * @param request
	 * @param povo
	 * @param lvo
	 * @return
	 */
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
	
	@RequestMapping("findDetailVaccinationRecordByVaccinationRecordNo.do")
	@ResponseBody
	public VaccinationRecordVO findDetailVaccinationRecordByVaccinationRecordNo(int vaccinationRecordNo){
		System.out.println("ajax 실행결과: " 
				+ vaccinationService.findDetailVaccinationRecordByVaccinationRecordNo(vaccinationRecordNo));
		return vaccinationService.findDetailVaccinationRecordByVaccinationRecordNo(vaccinationRecordNo);
	}

	/**
	 * 세션에 있는 보호자 전화번호를 기준으로 알람데이터를 받아온다
	 * ajax로 처리하도록 구성
	 * 차후 테이블을 새로 생성하여 쿼리의 부담을 덜어주게 할 예정
	 * @param petOwnerTel
	 * @return
	 */
	@RequestMapping("findAllAlarmDataByPetOwnerTel.do")
	@ResponseBody
	public List<Object> findAllAlarmDataByPetOwnerTel(String petOwnerTel){
		List<Object> list = null;
		try {
			list = vaccinationService.findAlarmListByPetOwnerTel(petOwnerTel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}
}
