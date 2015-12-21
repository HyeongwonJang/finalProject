package org.animalhospital.petowner.model.DAO;

import java.util.HashMap;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;

public interface PetOwnerDAO {
	public PetOwnerVO loginPetOwner(PetOwnerVO povo);
	public void updatePetOwner(PetOwnerVO povo);
	public PetOwnerVO checkPetOwnerTel(PetOwnerVO povo);
	public void deletePetOwner(PetOwnerVO povo);
	public void registerPetOwner(PetOwnerVO povo) throws Exception;
	public void registerPet(HashMap<String, Object> pom) throws Exception;
	public PetOwnerVO findPetListByTel(PetOwnerVO povo);
	public TreatmentRecordVO findTreatmentRecordById(PetOwnerVO povo);
	public PetOwnerVO findPetListByPetownerTel(String petOwnerTel);
	public PetOwnerVO findPetByTel(PetOwnerVO povo);
	public int findPetOwnerById(PetOwnerVO povo);
	public void registerPetOwnerByTel(PetOwnerVO povo);
	public PetOwnerVO findPetListById(PetOwnerVO povo);
	public PetOwnerVO findPetByPetName(HashMap<String, Object> map);
	public void updatePet(PetOwnerVO povo);
}
