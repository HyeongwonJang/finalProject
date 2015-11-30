package org.animalhospital.petowner.model.DAO;

import java.util.List;

import org.animalhospital.petowner.model.VO.MemberPetOwnerVO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;

public interface PetOwnerDAO {

	public MemberPetOwnerVO findMemberPetOwnerByTel(PetOwnerVO povo);
	public MemberPetOwnerVO findPetByTel(PetOwnerVO povo);
	public void registerPetOwner(MemberPetOwnerVO mpovo);
	public void registerMemberPetOwner(MemberPetOwnerVO mpovo);
	public void registerPet(MemberPetOwnerVO mpovo);
	public List<MemberPetOwnerVO> loginPetOwner(MemberPetOwnerVO mpovo);
	public void updatePetOwner(MemberPetOwnerVO mpovo);
	public void deletePetOwner(MemberPetOwnerVO mpovo);
	
}