package org.animalhospital.petowner.service;

import java.util.List;

import org.animalhospital.petowner.model.VO.PetOwnerVO;

public interface PetOwnerService {

	public PetOwnerVO findMemberPetOwnerByTel(PetOwnerVO povo);
	public void registerMemberPetOwnerAndPet(PetOwnerVO povo);
	public List<PetOwnerVO> loginPetOwner(PetOwnerVO povo);

}