package org.animalhospital.treatment.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.DAO.TreatmentDAO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.springframework.stereotype.Service;

@Service
public class TreatmentServiceImpl implements TreatmentService {

	@Resource
	private TreatmentDAO treatmentDAO;
	
	public List<TreatmentRecordVO> findTreatmentRecordByNoAndName(Map<String, Object> paramMap){
		
		
		return treatmentDAO.findTreatmentRecordByNoAndName(paramMap);
	}
	
}
