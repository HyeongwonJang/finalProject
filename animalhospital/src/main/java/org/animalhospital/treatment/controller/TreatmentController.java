package org.animalhospital.treatment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.animalhospital.treatment.service.DAO.TreatmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TreatmentController {
	@Resource
	private TreatmentService treatmentService;
	
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
	}
}
