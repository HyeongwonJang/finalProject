package org.animalhospital.treatment.service;

import java.util.List;
import java.util.Map;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;

public interface TreatmentService {
	public List<TreatmentRecordVO> findTreatmentRecordByNoAndName(Map<String, Object> paramMap);
}