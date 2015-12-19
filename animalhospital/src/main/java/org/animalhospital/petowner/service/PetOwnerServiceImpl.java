package org.animalhospital.petowner.service;

import java.util.HashMap;
import javax.annotation.Resource;
import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public String telCheckPetOwner(PetOwnerVO povo) {
		PetOwnerVO telCheckedpovo = petOwnerDAO.telCheckPetOwner(povo);
		String flag = "fail";
		if(telCheckedpovo != null) {
			if(telCheckedpovo.getPetOwnerTel() != null)
				flag = "fail";
			if(telCheckedpovo.getPetOwnerId() == null) {
				flag = "ok_update";
			}
		} else 
			flag = "ok";
		return flag;
	}
	
	@Transactional
	@Override
	public void registerPetOwner(PetOwnerVO povo) throws Exception {
		petOwnerDAO.registerPetOwner(povo);
		HashMap<String, Object> pom = new HashMap<String, Object>();
		pom.put("petOwnerNo", povo.getPetOwnerNo());
		if(povo.getPetVO()!=null) {
			for(int i=0; i<povo.getPetVO().size(); i++) {
				pom.put("petVO", povo.getPetVO().get(i));
				petOwnerDAO.registerPet(pom);
			}
		}
	}
	
	@Transactional
	@Override
	public void registerPet(PetOwnerVO povo) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(povo);
		map.put("petOwnerNo", povo.getPetOwnerNo());
		if(povo.getPetVO()!=null) {
			for(int i=0; i<povo.getPetVO().size(); i++) {
				map.put("petVO", povo.getPetVO().get(i));
				petOwnerDAO.registerPet(map);
			}
		}
	}

	@Override
	public PetOwnerVO findPetListByTel(PetOwnerVO povo) {
		return petOwnerDAO.findPetListByTel(povo);
	}
	public PetOwnerVO findPetListByPetownerTel(String petOwnerTel){
		return petOwnerDAO.findPetListByPetownerTel(petOwnerTel);
	}

	@Override
	public String findPetOwnerById(PetOwnerVO povo) {
		return petOwnerDAO.findPetOwnerById(povo)==0 ? "ok" : "fail";
	}
	@Transactional
	@Override
	public void registerPetOwnerByTel(PetOwnerVO povo) throws Exception {
		petOwnerDAO.registerPetOwnerByTel(povo);
		HashMap<String, Object> pom = new HashMap<String, Object>();
		pom.put("petOwnerNo", petOwnerDAO.loginPetOwner(povo).getPetOwnerNo());
		if(povo.getPetVO()!=null) {
			for(int i=0; i<povo.getPetVO().size(); i++) {
				pom.put("petVO", povo.getPetVO().get(i));
				petOwnerDAO.registerPet(pom);
			}
		}
	}
	
	@Override
	public PetOwnerVO findPetListById(PetOwnerVO povo) {
		return petOwnerDAO.findPetListById(povo);
	}

	@Override
	public PetOwnerVO findPetByPetName(PetOwnerVO povo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(povo);
		map.put("petOwnerNo", povo.getPetOwnerNo());
		if(povo.getPetVO()!=null) {
			for(int i=0; i<povo.getPetVO().size(); i++) {
				map.put("petVO", povo.getPetVO().get(i));
			}
		}
		return petOwnerDAO.findPetByPetName(map);
	}
	@Override
	public void updatePet(PetOwnerVO povo) {
		petOwnerDAO.updatePet(povo);
	}
	
	
}
