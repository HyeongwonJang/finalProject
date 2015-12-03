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
	public List<HospitalVO> findHospital(String hospitalName){
		return  sqlSessionTemplate.selectList("vet.findHospital",hospitalName);
	}
	@Override
	public void registerVet(HospitalVO hvo) {
		sqlSessionTemplate.insert("vet.registerVet",hvo);
	}
	@Override
	public int licenseCheck(VetLicenseVO lvo) {
		return sqlSessionTemplate.selectOne("vet.licenseCheck",lvo);
	}
	
	public int useVetLicenseCheck(VetLicenseVO lvo){
		return sqlSessionTemplate.selectOne("vet.useVetLicenseCheck", lvo);
	}
	
	public List<HospitalVO> findAllHospital(){
		return sqlSessionTemplate.selectList("vet.findAllHospital");
	}
	
	@Override
	public int findVetById(String vetId) {
		return sqlSessionTemplate.selectOne("vet.findVetById",vetId);
	}
	@Override
	public VetVO vetLogin(VetVO vvo) {
		return sqlSessionTemplate.selectOne("vet.vetLogin", vvo);
	}
	@Override
	public List<VetVO> findVetByHospitalId(int hospitalId) {
		return sqlSessionTemplate.selectList("vet.findVetByHospitalId", hospitalId);
	}
	
}
