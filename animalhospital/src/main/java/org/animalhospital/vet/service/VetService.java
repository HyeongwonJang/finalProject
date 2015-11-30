package org.animalhospital.vet.service;

import java.util.List;

import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.animalhospital.vet.model.VO.VetVO;

public interface VetService {

	void registerVet(HospitalVO hvo);

	/*List<HospitalVO> findHospital(String hospitalName);

	int licenseCheck(VetLicenseVO lvo);

	int findVetById(String vetId);

	VetVO vetLogin(VetVO vvo);*/

}
