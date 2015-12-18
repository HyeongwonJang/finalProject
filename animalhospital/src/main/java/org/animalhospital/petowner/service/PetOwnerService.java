package org.animalhospital.petowner.service;

import org.animalhospital.petowner.model.VO.PetOwnerVO;

public interface PetOwnerService {

	public PetOwnerVO loginPetOwner(PetOwnerVO povo);
	public void updatePetOwner(PetOwnerVO povo);
	public String telCheckPetOwner(PetOwnerVO povo);
	public void registerPetOwner(PetOwnerVO povo) throws Exception;
	public void registerPet(PetOwnerVO povo) throws Exception;
	public PetOwnerVO findPetListByTel(PetOwnerVO povo);
	public PetOwnerVO findPetListByPetownerTel(String petOwnerTel);
	public String findPetOwnerById(PetOwnerVO povo);
	public void registerPetOwnerByTel(PetOwnerVO povo) throws Exception;
	public PetOwnerVO findPetListById(PetOwnerVO povo);
	public PetOwnerVO findPetByPetName(PetOwnerVO povo);
	public void updatePet(PetOwnerVO povo);
}