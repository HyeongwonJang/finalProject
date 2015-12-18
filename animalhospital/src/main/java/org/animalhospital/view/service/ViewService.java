package org.animalhospital.view.service;

import java.util.Map;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.vet.model.VO.HospitalVO;

public interface ViewService {
	public Map<String, Object> findPetOwnerMainPageData(PetOwnerVO paramVO);
	public Map<String, Object> findVetOwnerMainPageData(HospitalVO paramVO);
}
