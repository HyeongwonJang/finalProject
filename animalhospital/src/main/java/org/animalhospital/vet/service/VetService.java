package org.animalhospital.vet.service;

import java.util.List;

import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.animalhospital.vet.model.VO.VetVO;

public interface VetService {

	public void registerVet(HospitalVO hvo);

	public List<HospitalVO> findHospital(String hospitalName);

	public int checkVetLicense(VetLicenseVO lvo);

	public int findVetById(String vetId);

	public HospitalVO loginVet(VetVO vvo);

	public List<VetVO> findVetByHospitalId(int hospitalId);
	
	public List<HospitalVO> findAllHospital();
	
	public int updateVet(HospitalVO hospitalVO);
}
