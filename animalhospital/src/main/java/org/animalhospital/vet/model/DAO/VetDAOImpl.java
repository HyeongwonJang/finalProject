package org.animalhospital.vet.model.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.animalhospital.vet.model.VO.VetVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VetDAOImpl implements VetDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<HospitalVO> findHospital(HospitalVO hvo) {
		return sqlSessionTemplate.selectList("vet.findHospital", hvo);
	}

	@Override
	public void registerVet(HospitalVO hvo) {
		sqlSessionTemplate.insert("vet.registerVet", hvo);
	}

	@Override
	public int checkVetLicense(VetLicenseVO lvo) {
		return sqlSessionTemplate.selectOne("vet.checkVetLicense", lvo);
	}

	public int useCheckVetVicense(VetLicenseVO lvo) {
		return sqlSessionTemplate.selectOne("vet.useCheckVetLicense", lvo);
	}

	public List<HospitalVO> findAllHospital() {
		return sqlSessionTemplate.selectList("vet.findAllHospital");
	}

	@Override
	public int findVetById(String vetId) {
		return sqlSessionTemplate.selectOne("vet.findVetById", vetId);
	}

	@Override
	public HospitalVO loginVet(VetVO vvo) {
		return sqlSessionTemplate.selectOne("vet.loginVet", vvo);
	}

	@Override
	public List<VetVO> findVetByHospitalId(int hospitalId) {
		return sqlSessionTemplate.selectList("vet.findVetByHospitalId", hospitalId);
	}

	@Override
	public int updateVet(HospitalVO hospitalVO) {
		return sqlSessionTemplate.update("vet.updateVet", hospitalVO);
	}
}
