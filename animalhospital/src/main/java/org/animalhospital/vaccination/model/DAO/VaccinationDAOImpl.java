package org.animalhospital.vaccination.model.DAO;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.DiseaseVO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
import org.animalhospital.vaccination.model.VO.VaccinationVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VaccinationDAOImpl implements VaccinationDAO {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<VaccinationRecordVO> findVaccinationRecordByPetOwnerTelAndPetName(VaccinationRecordVO vrvo){
		return sqlSessionTemplate.selectList("vaccination.findVaccinationRecordByPetOwnerTelAndPetName",vrvo);
	}

	@Override
	public int registerVaccination(VaccinationRecordVO vrvo){
		//System.out.println("date"+ vrvo);
		//System.out.println(sqlSessionTemplate.insert("Vaccination.registerVaccination", vrvo));
		return sqlSessionTemplate.insert("vaccination.registerVaccination", vrvo);
	}


	@Override
	public List<VaccinationVO> findAllVaccination() {
		return sqlSessionTemplate.selectList("vaccination.findAllVaccination");
	}

	@Override
	public List<Object> findVaccinationRecordByPetOwnerTelAndPetName(
			Map<String, Object> paramMap) {
		return sqlSessionTemplate.selectList("vaccination.findVaccinationRecordByPetOwnerTelAndPetName", paramMap);
	}

	@Override
	public int findAllVaccinationRecord(Map<String, Object> paramMap) {
		return sqlSessionTemplate.selectOne("vaccination.findAllVaccinationRecord", paramMap);
	}

}
