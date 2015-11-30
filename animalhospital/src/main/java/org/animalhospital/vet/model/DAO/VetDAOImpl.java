package org.animalhospital.vet.model.DAO;

import javax.annotation.Resource;

import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VetDAOImpl implements VetDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int registerVet(HospitalVO vo){
		return sqlSessionTemplate.insert("vet.registerVet", vo);
	}
	
	public HospitalVO findHospitalById(int hospitalId){
		return sqlSessionTemplate.selectOne("vet.findHospitalById",hospitalId);
	}
	
	public VetLicenseVO findVetLicenseByNoAndName(VetLicenseVO vo){
		return sqlSessionTemplate.selectOne("vet.findVetLicenseByNoAndName", vo);
	}
	
}
