package org.animalhospital.treatment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.service.PetOwnerService;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.animalhospital.treatment.service.TreatmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TreatmentController {
	@Resource
	private TreatmentService treatmentService;
	@Resource
	private PetOwnerService petOwnerService;

	/*
	 * // ajax를 이용한 진료기록 가지고 오기
	 * 
	 * @RequestMapping("findTreatmentRecordByPetOwner.do")
	 * 
	 * @ResponseBody public List<TreatmentRecordVO>
	 * findTreatmentRecordByPetOwner(PetOwnerVO povo, String startDate, String
	 * endDate){ Map<String, Object> paramMap = new HashMap<String, Object>();
	 * paramMap.put("startDate", startDate); paramMap.put("endDate", endDate);
	 * paramMap.put("povo", povo); System.out.println("매개변수: " + paramMap);
	 * return treatmentService.findTreatmentRecordByNoAndName(paramMap); }
	 */

	@RequestMapping("findTreatmentRecordByPetOwner.do")
	public ModelAndView findTreatmentRecordByPetOwner(PetOwnerVO povo,
			ListVO lvo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("povo", povo);
		paramMap.put("listVO", lvo);
		System.out.println("매개변수:" + paramMap);
		System.out.println("결과값: "
				+ treatmentService.findTreatmentRecordByPage(paramMap));
		ModelAndView mav = new ModelAndView("find_petOwner_treatmentRecord",
				"recordList",
				treatmentService.findTreatmentRecordByPage(paramMap));
		mav.addObject("continueParam", paramMap);
		return mav;

	}

	@RequestMapping("findTreatmentRecordByPetOwnerTel.do")
	public ModelAndView findTreatmentRecordByPetOwnerTel(PetOwnerVO povo,
			ListVO lvo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("povo", povo);
		paramMap.put("listVO", lvo);
		System.out.println("매개변수:" + paramMap);
		System.out.println("결과값: "
				+ treatmentService.findTreatmentRecordVetVerByPage(paramMap));
		ModelAndView mav = new ModelAndView("find_vet_treatmentRecord",
				"recordList",
				treatmentService.findTreatmentRecordVetVerByPage(paramMap));
		mav.addObject("continueParam", paramMap);
		return mav;

	}
	
	
	/**
	 * 보호자 전화번호에 따른 반려동물 리스트 가져오기
	 * userLevel로 수의사와 보호자를 구분(수의사 : vet, 보호자 : petOwner)하여
	 * 보호자일 때는 session loginVO의 tel를 이용하고
	 * 수의사일 때는 find_vet_treatmentRecord.jsp에서 입력받은 tel값을 이용함
	 * @param request
	 * @param petOwnerVO
	 * @return
	 */
	@RequestMapping("findPetListByTel.do")
	@ResponseBody
	public PetOwnerVO findPetListByTel(HttpServletRequest request, PetOwnerVO petOwnerVO){
		if(petOwnerVO == null){
			petOwnerVO = (PetOwnerVO) request.getSession(false).getAttribute("loginVO");
		}
		return petOwnerService.findPetListByTel(petOwnerVO);
	}	

	@RequestMapping("registerTreatmentRecord.do")
	public String registerTreatmentRecord(HttpServletRequest request,
			TreatmentRecordVO treatmentRecordVO) {
		treatmentService.registerTreatmentRecord(treatmentRecordVO);
		return "redirect:registerTreatmentRecord_result.do";
	}

	@RequestMapping("registerTreatmentRecord_result.do")
	public String registerTreatmentRecordResult(HttpServletRequest request,
			TreatmentRecordVO treatmentRecordVO) {
		return "treatmentRecord/treatment_record_result";
	}

	@RequestMapping(value = "findPetListByPetOwnerTel.do")
	@ResponseBody
	public PetOwnerVO findPetListByPetownerTel(String petOwnerTel) {
		return petOwnerService.findPetListByPetownerTel(petOwnerTel);
	}

}
