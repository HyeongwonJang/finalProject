package org.animalhospital.petowner.model.DAO;


import java.util.HashMap;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class PetOwnerDAOImpl implements PetOwnerDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public PetOwnerVO loginPetOwner(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.loginPetOwner",povo);
	}
	
	
	@Override
	public void updatePetOwner(PetOwnerVO povo) {
		sqlSessionTemplate.update("petOwner.updatePetOwner",povo);
	}
	@Override
	public PetOwnerVO telCheckPetOwner(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.telCheckPetOwner",povo);
	}
	@Override
	public void deletePetOwner(PetOwnerVO povo) {
		sqlSessionTemplate.update("petOwner.deletePetOwner",povo);
	}
	
	@Override
	public void registerPetOwner(PetOwnerVO povo) throws Exception{
		sqlSessionTemplate.insert("petOwner.registerPetOwner", povo);
	}
	@Override
	public void registerPet(HashMap<String, Object> pom) throws Exception{
		sqlSessionTemplate.insert("petOwner.registerPet", pom);
	}
	
	
	@Override
	public PetOwnerVO findPetListByTel(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findMemberPetOwnerByTel", povo);
	}
	public PetOwnerVO findPetByTel(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findPetByTel", povo);
	}


	@Override
	public TreatmentRecordVO findTreatmentRecordById(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findTreatmentRecordById",povo);
	}

	public PetOwnerVO findPetListByPetownerTel(String petOwnerTel){
		return sqlSessionTemplate.selectOne("petOwner.findPetListByPetownerTel",petOwnerTel);
	}

	@Override
	public int findPetOwnerById(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findPetOwnerById", povo);
	}

	@Override
	public void registerPetOwnerByTel(PetOwnerVO povo) {
		sqlSessionTemplate.update("petOwner.registerPetOwnerByTel", povo);
	}
	@Override
	public PetOwnerVO findPetListById(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findPetListById",povo);
	}
	@Override
	public PetOwnerVO findPetByPetName(HashMap<String, Object> map) {
		return sqlSessionTemplate.selectOne("petOwner.findPetByPetName",map);
	}
	@Override
	public void updatePet(PetOwnerVO povo) {
		sqlSessionTemplate.update("petOwner.updatePet",povo);
	}
	
}
