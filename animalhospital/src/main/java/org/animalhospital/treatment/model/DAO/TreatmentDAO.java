package org.animalhospital.treatment.model.DAO;

import java.util.List;
import java.util.Map;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;

public interface TreatmentDAO {

	/**
	 * ajax로 진료기록을 가져오기 위해 사용하는 메서드(보호자)
	 * 매개변수: 보호자 번호(시퀀스), 반려동물 이름
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<Object> findTreatmentRecordByPage(
			Map<String, Object> paramMap);

	public int findAllTreatmentRecord(Map<String, Object> paramMap);
	public TreatmentRecordVO findDetailTreatmentRecordByTreatmentNo(int treatmentNo);
	public PetVO findDetailPetRecordByTreatmentNo(int treatmentNo);
}