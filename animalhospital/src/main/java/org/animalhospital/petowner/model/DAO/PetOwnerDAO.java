package org.animalhospital.petowner.model.DAO;

import java.util.List;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;

public interface PetOwnerDAO {

	public PetOwnerVO findMemberPetOwnerByTel(PetOwnerVO povo);
	public PetOwnerVO findPetByTel(PetOwnerVO povo);
	public void registerPetOwner(PetOwnerVO povo);
	public void registerPet(PetOwnerVO povo);
	public PetOwnerVO loginPetOwner(PetOwnerVO povo);
	public void updatePetOwner(PetOwnerVO povo);
	public void deletePetOwner(PetOwnerVO povo);
	public TreatmentRecordVO findTreatmentRecordById(PetOwnerVO povo);
	
}