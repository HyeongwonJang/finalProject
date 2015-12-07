package org.animalhospital.petowner.model.DAO;

import java.util.List;
import java.util.HashMap;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;

public interface PetOwnerDAO {
	public PetOwnerVO loginPetOwner(PetOwnerVO povo);
	public void updatePetOwner(PetOwnerVO povo);
	public int telCheckPetOwner(PetOwnerVO povo);
	public void deletePetOwner(PetOwnerVO povo);
	public void registerPetOwner(PetOwnerVO povo);
	public void registerPet(HashMap<String, Object> pom);
	public PetOwnerVO findPetOwnerByTel(PetOwnerVO povo);
	public TreatmentRecordVO findTreatmentRecordById(PetOwnerVO povo);
	
}
