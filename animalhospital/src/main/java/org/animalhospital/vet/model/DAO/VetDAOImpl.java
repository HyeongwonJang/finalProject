package org.animalhospital.vet.model.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VetDAOImpl implements VetDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 병원 정보를 모두 가져오는 메서드
	 * 용도: 회원가입 시 병원 리스트를 가져오는데 사용한다.
	 */
	public List<HospitalVO> findAllHospital(){
		return sqlSessionTemplate.selectList("vet.findAllHospital");
	}
	
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
