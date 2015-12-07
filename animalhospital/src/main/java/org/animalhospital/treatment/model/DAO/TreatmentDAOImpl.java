package org.animalhospital.treatment.model.DAO;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TreatmentDAOImpl implements TreatmentDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public List<TreatmentRecordVO> findTreatmentRecordByNoAndName(Map<String, Object> paramMap){
		return sqlSessionTemplate.selectList("tratmentRecord.findTreatmentRecordByNoAndName", paramMap);
	}
		
}
