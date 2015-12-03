package org.animalhospital.petowner.service;

import org.animalhospital.petowner.model.VO.PetOwnerVO;

public interface PetOwnerService {

	public PetOwnerVO findMemberPetOwnerByTel(PetOwnerVO povo);
	public void registerMemberPetOwnerAndPet(PetOwnerVO povo);
	public PetOwnerVO loginPetOwner(PetOwnerVO povo);
	public void updatePetOwner(PetOwnerVO povo);
	public void registerPetOwner(PetOwnerVO povo);

}