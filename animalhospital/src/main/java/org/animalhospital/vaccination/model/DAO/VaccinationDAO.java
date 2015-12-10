package org.animalhospital.vaccination.model.DAO;

import java.util.List;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.DiseaseVO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
import org.animalhospital.vaccination.model.VO.VaccinationVO;

public interface VaccinationDAO {

	public void registerVaccination(VaccinationRecordVO vrvo);
	
	/**
	 * 질병목록을 전부 다 가져오는 서비스
	 * 
	 */
	public List<VaccinationVO> findAllVaccination();

	public List<DiseaseVO> findAllDisease();

	public PetOwnerVO findPetListById(PetOwnerVO povo);

	
}