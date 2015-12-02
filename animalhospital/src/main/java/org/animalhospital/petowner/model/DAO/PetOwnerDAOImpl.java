package org.animalhospital.petowner.model.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class PetOwnerDAOImpl implements PetOwnerDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/* (non-Javadoc)
	 * @see org.animalhospital.petowner.model.MemberPetOwnerDAO#findMemberPetOwnerByTel(org.animalhospital.petowner.model.PetOwnerVO)
	 */
	@Override
	public PetOwnerVO findMemberPetOwnerByTel(PetOwnerVO povo) {
		System.out.println("hello");
		return sqlSessionTemplate.selectOne("petOwner.findMemberPetOwnerByTel", povo);
	}
	
	public PetOwnerVO findPetByTel(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findPetByTel", povo);
	}
	
	public void registerPetOwner(PetOwnerVO povo) {
		sqlSessionTemplate.insert("petOwner.registerPetOwner", povo);
	}
	public void registerMemberPetOwner(PetOwnerVO povo) {
		sqlSessionTemplate.insert("petOwner.registerMemberPetOwner", povo);
	}
	public void registerPet(PetOwnerVO povo) {
		for(int i=0; i<povo.getPetVO().size(); i++)
			sqlSessionTemplate.insert("petOwner.registerPet", povo.getPetVO().get(i));
	}

	@Override
	public List<PetOwnerVO> loginPetOwner(PetOwnerVO povo) {
		return sqlSessionTemplate.selectList("petOwner.loginPetOwner",povo);
	}

	@Override
	public void updatePetOwner(PetOwnerVO povo) {
		 sqlSessionTemplate.update("petOwner.updatePetOwner",povo);
	}

	@Override
	public void deletePetOwner(PetOwnerVO povo) {
		sqlSessionTemplate.update("petOwner.deletePetOwner",povo);
	}

	
	
}
