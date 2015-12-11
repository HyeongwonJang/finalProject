package org.animalhospital.treatment.model.DAO;

import java.util.List;
import java.util.Map;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.VO.DiseaseVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;

public interface TreatmentDAO {

	/**
	 * 진료기록상세조회 중 반려동물에 대한 정보를 제외한 정보를 받아온다
	 * @author 민호
	 */
	public TreatmentRecordVO findDetailTreatmentRecordByTreatmentNo(int treatmentNo);
	/**
	 * 진료기록상세조회 중 반려동물에 대한 정보를 받아온다
	 * @author 민호
	 */
	public PetVO findDetailPetRecordByTreatmentNo(int treatmentNo);
	/**
	 * 검색한 진료기록의 전체 개수를 받아온다
	 * 페이징을 위한 DAO 메서드
	 * @param paramMap
	 * @return
	 * @author 민호, 윤아
	 */
	int findAllTreatmentRecord(Map<String, Object> paramMap);
	
	/**
	 * 진료기록목록을 받아오는 메서드
	 * @author 민호, 윤아
	 */
	public List<Object> findTreatmentRecordByPetOwnerTelAndPetName(
			Map<String, Object> paramMap);
	
	public List<DiseaseVO> allDiseaseList();
	public int registerTreatmentRecord(TreatmentRecordVO treatmentRecordVO);
}
