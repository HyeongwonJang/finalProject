package org.animalhospital.treatment.service;

import java.util.List;
import java.util.Map;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.DiseaseVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;

public interface TreatmentService {
	/**
	 * 진료기록을 조회하는 메서드
	 * 매개변수는 Map에 담겨있다 -> 시작일, 종료일, 반려동물이름, 보호자 전화번호, 페이지
	 * 검색결과를 DAO에서 받아온 뒤 매개변수로 다시 petLIst를 세팅한다
	 * (resultMap으로 반려동물의 정보를 한 번에 담는 것이 불가능하기 때문)
	 * @author 민호, 윤아
	 */
	public ListVO findTreatmentRecordByByPetOwnerTelAndPetName(Map<String, Object> paramMap);
	/**
	 * 진료기록 상세보기를 출력하는 메서드
	 * 반려동물에 대한 정보, 그 외의 정보를 나누어 DAO에서 정보를 받은 뒤 합쳐서 정보를 제공한다
	 * (resultMap으로 반려동물의 정보를 한 번에 담는 것이 불가능하기 때문)
	 * @author 민호, 윤아
	 */
	public TreatmentRecordVO findDetailTreatmentRecordByTreatmentNo(int treatmentNo);
	public List<DiseaseVO> allDiseaseList();
	
	/**
	 * 입력받은 진료정보를 기록하기 위한 메서드 
	 * @param treatmentRecordVO
	 * @author 두현
	 * @return
	 */
	public int registerTreatmentRecord(TreatmentRecordVO treatmentRecordVO);
	
	public List<TreatmentRecordVO> findTreatmentRecordByPetOwnerTel(String petOwnerTel);
	public List<TreatmentRecordVO> findTreatmentRecordByVetLicenseNo(int vetLicenseNo);
	public int registerNonMember(PetOwnerVO petOwnerVO);
	public int registerNonMemberPet(PetOwnerVO petOwnerVO);
}
