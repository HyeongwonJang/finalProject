package org.animalhospital.treatment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
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
	
	/*// ajax를 이용한 진료기록 가지고 오기
	@RequestMapping("findTreatmentRecordByPetOwner.do")
	@ResponseBody
	public List<TreatmentRecordVO> findTreatmentRecordByPetOwner(PetOwnerVO povo, 
			String startDate, String endDate){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);
		paramMap.put("povo", povo);
		System.out.println("매개변수: " + paramMap); 
		return treatmentService.findTreatmentRecordByNoAndName(paramMap);
	}*/
	
		@RequestMapping("findTreatmentRecordByPetOwner.do")
		public ModelAndView findTreatmentRecordByPetOwner(PetOwnerVO povo, 
				ListVO lvo){
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("povo", povo);
			paramMap.put("listVO", lvo);
			System.out.println("매개변수:" + paramMap);
			System.out.println("결과값: " + treatmentService.findTreatmentRecordByPage(paramMap)); 
			ModelAndView mav = new ModelAndView("find_petOwner_treatmentRecord", "recordList",
									treatmentService.findTreatmentRecordByPage(paramMap));
			mav.addObject("continueParam", paramMap);
			return mav;
			
		}
}
