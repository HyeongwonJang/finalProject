package org.animalhospital.vaccination.model.DAO;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
import org.animalhospital.vaccination.model.VO.VaccinationVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VaccinationDAOImpl implements VaccinationDAO {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * registerVaccination insert문 
	 * @author 진혁
	 */
	@Override
	public int registerVaccination(VaccinationRecordVO vrvo){
		return sqlSessionTemplate.insert("vaccination.registerVaccination", vrvo);
	}
	
	/**
	 * registerVetVaccination 수의사 insert문 
	 * @author 진혁
	 */
	@Override
	public int registerVetVaccination(VaccinationRecordVO vrvo){
		return sqlSessionTemplate.insert("vaccination.registerVetVaccination", vrvo);
	}

	/**
	 * findAllVaccination 백신 리스트 출력 
	 * @author 진혁
	 */
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

	@Override
	public VaccinationRecordVO findDetailVaccinationRecordByVaccinationRecordNo(
			int vaccinationRecordNo) {
		return sqlSessionTemplate.selectOne(
				"vaccination.findDetailVaccinationRecordByVaccinationRecordNo",vaccinationRecordNo);
	}
	@Override
	public PetVO findDetailPetRecordByVaccinationtRecordNo(int vaccinationRecordNo){
		return sqlSessionTemplate.selectOne("vaccination.findDetailPetRecordByVaccinationtRecordNo", vaccinationRecordNo);
	}
	
	@Override
	public List<Integer> findVaccinationNoList(Map<String, Object> paramMap){
		return sqlSessionTemplate.selectList("vaccination.findVaccinationNoList", paramMap);
	}
	@Override
	public VaccinationRecordVO findLastVaccinationHistoryInfo(
			Map<String, Object> paramMap) {
		return sqlSessionTemplate.selectOne("vaccination.findLastVaccinationHistoryInfoByVaccinationNo", paramMap);
	}
	public List<PetVO> findTookVaccinationPetListByPetOwnerTel(String petOwnerTel){
		return sqlSessionTemplate.selectList("vaccination.findTookVaccinationPetListByPetOwnerTel", petOwnerTel);
	}

}
