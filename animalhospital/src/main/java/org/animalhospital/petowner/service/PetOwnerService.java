package org.animalhospital.petowner.service;

import java.util.List;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.vet.model.VO.HospitalVO;

public interface PetOwnerService {
	
	public PetOwnerVO findMemberPetOwnerByTel(PetOwnerVO povo);
	public void registerMemberPetOwnerAndPet(PetOwnerVO povo);
	public PetOwnerVO loginPetOwner(PetOwnerVO povo);

}