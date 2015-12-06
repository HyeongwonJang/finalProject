package org.animalhospital.petowner.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.springframework.stereotype.Service;

@Service
public class PetOwnerServiceImpl implements PetOwnerService {
	@Resource
	private PetOwnerDAO petOwnerDAO;

	@Override
	public PetOwnerVO loginPetOwner(PetOwnerVO povo) {
		return petOwnerDAO.loginPetOwner(povo);
	}

	@Override
	public void updatePetOwner(PetOwnerVO povo) {
		petOwnerDAO.updatePetOwner(povo);
	}

	@Override
	public void registerPetOwner(PetOwnerVO povo) {
		petOwnerDAO.registerPetOwner(povo);
		HashMap<String, Object> pom = new HashMap<String, Object>();
		System.out.println(povo);
		pom.put("petOwnerNo", povo.getPetOwnerNo());
		if(povo.getPetVO()!=null) {
			for(int i=0; i<povo.getPetVO().size(); i++) {
				pom.put("petVO", povo.getPetVO().get(i));
				petOwnerDAO.registerPet(pom);
			}
		}
	}

	@Override
	public PetOwnerVO findPetOwnerByTel(PetOwnerVO povo) {
		return petOwnerDAO.findPetOwnerByTel(povo);
	}
}
