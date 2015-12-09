package org.animalhospital.treatment.model.DAO;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TreatmentDAOImpl implements TreatmentDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public TreatmentRecordVO findDetailTreatmentRecordByTreatmentNo(int treatmentNo){
		return sqlSessionTemplate.selectOne("treatmentRecord.findDetailTreatmentRecordByTreatmentNo", treatmentNo);
	}
	public PetVO findDetailPetRecordByTreatmentNo(int treatmentNo){
		return sqlSessionTemplate.selectOne("treatmentRecord.findDetailPetRecordByTreatmentNo", treatmentNo);
	}
	
	/**
	 * 페이지, 기간, 반려동물명, 주인의 시퀀스 값으로
	 * 진료기록조회
	 * 
	 */
	public List<Object> findTreatmentRecordByPage(Map<String, Object> paramMap){
		return sqlSessionTemplate.selectList("treatmentRecord.findTreatmentRecordByPage", paramMap);
	}
	
	

	@Override
	public int findAllTreatmentRecord(Map<String, Object> paramMap) {
		return sqlSessionTemplate.selectOne("treatmentRecord.findAllTreatmentRecord", paramMap);
	}
	
	@Override
	public int findAllTreatmentRecordVetVer(Map<String, Object> paramMap) {
		return sqlSessionTemplate.selectOne("treatmentRecord.findAllTreatmentRecordVetVer", paramMap);
	}


	@Override
	public List<Object> findTreatmentRecordVetVerByPage(
			Map<String, Object> paramMap) {
		return sqlSessionTemplate.selectList("treatmentRecord.findTreatmentRecordVetVerByPage", paramMap);
	}
	
	
		
}
