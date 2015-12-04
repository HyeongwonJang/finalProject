package org.animalhospital.petowner.model.DAO;

<<<<<<< HEAD
import java.util.List;
=======
import java.util.HashMap;
>>>>>>> branch 'master' of https://github.com/prototype01/finalProject.git

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;

public interface PetOwnerDAO {

	public void registerPetOwner(PetOwnerVO povo);
	public void registerPet(HashMap<String, Object> pom);
	public PetOwnerVO loginPetOwner(PetOwnerVO povo);
	public void updatePetOwner(PetOwnerVO povo);
	public void deletePetOwner(PetOwnerVO povo);
	public TreatmentRecordVO findTreatmentRecordById(PetOwnerVO povo);
	
}
