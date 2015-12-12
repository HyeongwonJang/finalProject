package org.animalhospital.petowner.model.DAO;

import java.util.HashMap;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;

public interface PetOwnerDAO {
	public PetOwnerVO loginPetOwner(PetOwnerVO povo);
	public void updatePetOwner(PetOwnerVO povo);
	public PetOwnerVO telCheckPetOwner(PetOwnerVO povo);
	public void deletePetOwner(PetOwnerVO povo);
	public void registerPetOwner(PetOwnerVO povo);
	public void registerPet(HashMap<String, Object> pom);
	public PetOwnerVO findPetListByTel(PetOwnerVO povo);
	public TreatmentRecordVO findTreatmentRecordById(PetOwnerVO povo);
	public PetOwnerVO findPetListByPetownerTel(String petOwnerTel);
	public PetOwnerVO findPetByTel(PetOwnerVO povo);
	public int findPetOwnerById(PetOwnerVO povo);
	public void registerPetOwnerByTel(PetOwnerVO povo);
}
