package org.animalhospital.petowner.model.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.MemberPetOwnerVO;
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
	public MemberPetOwnerVO findMemberPetOwnerByTel(PetOwnerVO povo) {
		System.out.println("hello");
		return sqlSessionTemplate.selectOne("petOwner.findMemberPetOwnerByTel", povo);
	}
	
	public MemberPetOwnerVO findPetByTel(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findPetByTel", povo);
	}
	
	public void registerPetOwner(MemberPetOwnerVO mpovo) {
		sqlSessionTemplate.insert("petOwner.registerPetOwner", mpovo);
	}
	public void registerMemberPetOwner(MemberPetOwnerVO mpovo) {
		sqlSessionTemplate.insert("petOwner.registerMemberPetOwner", mpovo);
	}
	public void registerPet(MemberPetOwnerVO mpovo) {
		for(int i=0; i<mpovo.getPetVO().size(); i++)
			sqlSessionTemplate.insert("petOwner.registerPet", mpovo.getPetVO().get(i));
	}

	@Override
	public List<MemberPetOwnerVO> loginPetOwner(MemberPetOwnerVO mpovo) {
		return sqlSessionTemplate.selectList("petOwner.loginPetOwner",mpovo);
	}

	@Override
	public void updatePetOwner(MemberPetOwnerVO mpovo) {
		 sqlSessionTemplate.update("petOwner.updatePetOwner",mpovo);
	}

	@Override
	public void deletePetOwner(MemberPetOwnerVO mpovo) {
		sqlSessionTemplate.update("petOwner.deletePetOwner",mpovo);
	}

	@Override
	public void deletePet(MemberPetOwnerVO mpovo) {
		sqlSessionTemplate.delete("petOwner.deletePet",mpovo);
	}
	
}
