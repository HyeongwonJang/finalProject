package org.animalhospital.treatment.model.DAO;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.VO.DiseaseVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TreatmentDAOImpl implements TreatmentDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 진료기록 목록을 보호자 전화번호 기준으로 5개만 가지고 온다
	 * 사용용도: 메인페이지 조회
	 * @author 민호
	 */
	public List<TreatmentRecordVO> findTreatmentRecordByPetOwnerTel(String petOwnerTel){
		return sqlSessionTemplate.selectList(
				"treatmentRecord.findTreatmentRecordByPetOwnerTel", petOwnerTel);
	}
	
	/**
	 * 진료기록 목록을 수의사 면허번호 기준으로 5개만 가지고 온다
	 * 사용용도: 메인페이지 조회
	 * @param vetLicenseNo
	 * @return
	 * @author 민호
	 */
	public List<TreatmentRecordVO> findTreatmentRecordByVetLicenseNo(int vetLicenseNo){
		return sqlSessionTemplate.selectList(
				"treatmentRecord.findTreatmentRecordByVetLicenseNo", vetLicenseNo);
	}
	
	/**
	 * 진료기록상세조회 중 반려동물에 대한 정보를 제외한 정보를 받아온다
	 * @author 민호
	 */
	public TreatmentRecordVO findDetailTreatmentRecordByTreatmentNo(int treatmentNo){
		return sqlSessionTemplate.selectOne("treatmentRecord.findDetailTreatmentRecordByTreatmentNo", treatmentNo);
	}
	
	/**
	 * 진료기록상세조회 중 반려동물에 대한 정보를 받아온다
	 * @author 민호
	 */
	public PetVO findDetailPetRecordByTreatmentNo(int treatmentNo){
		return sqlSessionTemplate.selectOne("treatmentRecord.findDetailPetRecordByTreatmentNo", treatmentNo);
	}

	/**
	 * 검색한 진료기록의 전체 개수를 받아온다
	 * 페이징을 위한 DAO 메서드
	 * @param paramMap
	 * @return
	 * @author 민호, 윤아
	 */
	@Override
	public int findAllTreatmentRecord(Map<String, Object> paramMap) {
		return sqlSessionTemplate.selectOne("treatmentRecord.findAllTreatmentRecord", paramMap);
	}

	/**
	 * 진료기록목록을 받아오는 메서드
	 * 매개변수: 
	 * @author 민호, 윤아
	 */
	@Override
	public List<Object> findTreatmentRecordByPetOwnerTelAndPetName(
			Map<String, Object> paramMap) {
		return sqlSessionTemplate.selectList("treatmentRecord.findTreatmentRecordByPetOwnerTelAndPetName", paramMap);
	}
	

	public List<DiseaseVO> allDiseaseList(){
		return sqlSessionTemplate.selectList("treatmentRecord.allDiseaseList");
	}
	public int registerTreatmentRecord(TreatmentRecordVO treatmentRecordVO){
		//System.out.println("input date : "+treatmentRecordVO);
		return sqlSessionTemplate.insert("treatmentRecord.registerTreatmentRecord", treatmentRecordVO);
	}
	/**
	 * 비회원 insert, 비회원 pet 
	 * @param petOwnerVO
	 * @return
	 */
	public int registerNonMember(PetOwnerVO petOwnerVO){
		return sqlSessionTemplate.insert("treatmentRecord.registerNonMember",petOwnerVO);
	}
	public int registerNonMemberPet(PetOwnerVO petOwnerVO){
		return sqlSessionTemplate.insert("treatmentRecord.registerNonMemberPet",petOwnerVO);
	}	
}
