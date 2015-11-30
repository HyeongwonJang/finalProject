package org.animalhospital.vet.model.DAO;

import org.animalhospital.petowner.model.VO.MemberPetOwnerVO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;

public interface PetOwnerDAO {

	MemberPetOwnerVO findMemberPetOwnerByTel(PetOwnerVO povo);
	MemberPetOwnerVO findPetByTel(PetOwnerVO povo);
	public void registerPetOwner(MemberPetOwnerVO mpovo);
	public void registerMemberPetOwner(MemberPetOwnerVO mpovo);
	public void registerPet(MemberPetOwnerVO mpovo);
}