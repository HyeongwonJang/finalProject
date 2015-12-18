package org.animalhospital.treatment.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.DAO.TreatmentDAO;
import org.animalhospital.treatment.model.VO.DiseaseVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.springframework.stereotype.Service;

@Service
public class TreatmentServiceImpl implements TreatmentService {
	@Resource
	private TreatmentDAO treatmentDAO;
	@Resource
	private ListVO listVO;
	
	

	/**
	 * 진료기록을 조회하는 메서드
	 * 매개변수는 Map에 담겨있다 -> 시작일, 종료일, 반려동물이름, 보호자 전화번호, 페이지
	 * 검색결과를 DAO에서 받아온 뒤 매개변수로 다시 petLIst를 세팅한다
	 * (resultMap으로 반려동물의 정보를 한 번에 담는 것이 불가능하기 때문)
	 * @author 민호, 윤아
	 */
	public ListVO findTreatmentRecordByByPetOwnerTelAndPetName(Map<String, Object> paramMap) {
		System.out.println("매개변수:" + paramMap);
		List<Object> list = treatmentDAO.findTreatmentRecordByPetOwnerTelAndPetName(paramMap);
		List<PetVO> petList=((PetOwnerVO) paramMap.get("povo")).getPetVO();
		for(int li=0; li<list.size(); li++){
			((TreatmentRecordVO) list.get(li)).getPetOwnerVO().setPetVO(petList);
		}
		listVO.setList(list);
		listVO.getPagingBean().setNowPage(((ListVO) paramMap.get("listVO")).getPage());
		listVO.getPagingBean().setTotalContents(treatmentDAO.findAllTreatmentRecord(paramMap));
		return listVO;
		
	}
	
	/**
	 * 진료기록 상세보기를 출력하는 메서드
	 * 반려동물에 대한 정보, 그 외의 정보를 나누어 DAO에서 정보를 받은 뒤 합쳐서 정보를 제공한다
	 * (resultMap으로 반려동물의 정보를 한 번에 담는 것이 불가능하기 때문)
	 * @author 민호, 윤아
	 */
	public TreatmentRecordVO findDetailTreatmentRecordByTreatmentNo(int treatmentNo){
		PetVO detailPetVO = treatmentDAO.findDetailPetRecordByTreatmentNo(treatmentNo);
		TreatmentRecordVO searchTreatmentVO = treatmentDAO.findDetailTreatmentRecordByTreatmentNo(treatmentNo);
		searchTreatmentVO.getPetOwnerVO().addPetVO(detailPetVO);
		return searchTreatmentVO;
	}
	

	public List<DiseaseVO> allDiseaseList(){
		return treatmentDAO.allDiseaseList();
	}
	public int registerTreatmentRecord(TreatmentRecordVO treatmentRecordVO){
		return treatmentDAO.registerTreatmentRecord(treatmentRecordVO);
	}

	/**
	 * 진료기록 5개를 전화번호 기준으로 호출하는 서비스 계층 메서드 
	 * 사용용도: 메인페이지 조회
	 * @author 민호
	 */
	@Override
	public List<TreatmentRecordVO> findTreatmentRecordByPetOwnerTel(
			String petOwnerTel) {
		return treatmentDAO.findTreatmentRecordByPetOwnerTel(petOwnerTel);
	}
	
	/**
	 * 진료기록 5개를 수의사 면허번호 기준으로 호출하는 서비스 계층 메서드 
	 * 사용용도: 메인페이지 조회
	 * @author 민호
	 */
	public List<TreatmentRecordVO> findTreatmentRecordByVetLicenseNo(int vetLicenseNo){
		return treatmentDAO.findTreatmentRecordByVetLicenseNo(vetLicenseNo);
	}
	
	
	
}
