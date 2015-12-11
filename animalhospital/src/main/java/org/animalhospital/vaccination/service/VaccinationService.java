package org.animalhospital.vaccination.service;

import java.util.List;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.DiseaseVO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
import org.animalhospital.vaccination.model.VO.VaccinationVO;

public interface VaccinationService {

	
	/**
	 * 반려동물 정보를 전화번호를 기준으로 검색하는 서비스
	 * @param povo
	 * @return
	 */
	public PetOwnerVO findPetByTel(PetOwnerVO povo);
	
	/**
	 * 질병목록을 전부 다 가져오는 서비스
	 * 
	 */
	public List<VaccinationVO> findAllVaccination();

	public List<DiseaseVO> findAllDisease();

	public PetOwnerVO findPetListById(PetOwnerVO povo);

	public int registerVaccination(VaccinationRecordVO vrvo);
}