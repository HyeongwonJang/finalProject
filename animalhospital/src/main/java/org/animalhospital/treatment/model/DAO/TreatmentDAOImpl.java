package org.animalhospital.treatment.model.DAO;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.VO.DiseaseVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TreatmentDAOImpl implements TreatmentDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<TreatmentRecordVO> findTreatmentRecordByPetOwnerTel(String petOwnerTel){
		return sqlSessionTemplate.selectList("treatmentRecord.findTreatmentRecordByPetOwnerTel", petOwnerTel);
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

		
}
