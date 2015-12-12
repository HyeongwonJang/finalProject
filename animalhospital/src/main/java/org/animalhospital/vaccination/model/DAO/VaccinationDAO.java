package org.animalhospital.vaccination.model.DAO;

import java.util.List;
import java.util.Map;

import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
import org.animalhospital.vaccination.model.VO.VaccinationVO;

public interface VaccinationDAO {

	
	public List<VaccinationVO> findAllVaccination();

	public int registerVaccination(VaccinationRecordVO vrvo);

	public List<Object> findVaccinationRecordByPetOwnerTelAndPetName(
			Map<String, Object> paramMap);

	public int findAllVaccinationRecord(Map<String, Object> paramMap);

	public VaccinationRecordVO findDetailVaccinationRecordByVaccinationRecordNo(
			int vaccinationRecordNo);

	public PetVO findDetailPetRecordByVaccinationtRecordNo(int vaccinationRecordNo);

	
}