package org.animalhospital.vaccination.service;

import java.util.List;
import java.util.Map;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
import org.animalhospital.vaccination.model.VO.VaccinationVO;

public interface VaccinationService {

	
	/**
	 * 반려동물 정보를 전화번호를 기준으로 검색하는 서비스
	 * @param povo
	 * @return
	 */
	public PetOwnerVO findPetByTel(PetOwnerVO povo);

	public List<VaccinationVO> findAllVaccination();

	public int registerVaccination(VaccinationRecordVO vrvo);

	public ListVO findVaccinationRecordByPetOwnerTelAndPetName(
			Map<String, Object> paramMap);
	public VaccinationRecordVO findDetailVaccinationRecordByVaccinationRecordNo(
			int vaccinationRecordNo);
	int registerVetVaccination(VaccinationRecordVO vrvo);
}
