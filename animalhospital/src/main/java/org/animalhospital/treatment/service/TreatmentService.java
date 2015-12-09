package org.animalhospital.treatment.service;

import java.util.List;
import java.util.Map;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;

public interface TreatmentService {
	public ListVO findTreatmentRecordByPage(Map<String, Object> paramMap);

	public ListVO findTreatmentRecordVetVerByPage(Map<String, Object> paramMap);
}