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
	
	public void registerPetOwner(PetOwnerVO povo) {
		sqlSessionTemplate.insert("petOwner.registerPetOwner", povo);
	}
	public void registerPet(HashMap<String, Object> pom) {
		sqlSessionTemplate.insert("petOwner.registerPet", pom);
	}

	@Override
	public PetOwnerVO loginPetOwner(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.loginPetOwner",povo);
	}

	@Override
	public void updatePetOwner(PetOwnerVO povo) {
		 sqlSessionTemplate.update("petOwner.updatePetOwner",povo);
	}

	@Override
	public void deletePetOwner(PetOwnerVO povo) {
		sqlSessionTemplate.update("petOwner.deletePetOwner",povo);
	}

	@Override
	public TreatmentRecordVO findTreatmentRecordById(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findTreatmentRecordById",povo);
	}

	
	
}
