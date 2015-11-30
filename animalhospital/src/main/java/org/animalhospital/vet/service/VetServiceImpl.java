package org.animalhospital.vet.service;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.vet.model.DAO.VetDAO;
import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.animalhospital.vet.model.VO.VetVO;
import org.springframework.stereotype.Service;

@Service
public class VetServiceImpl implements VetService{
	@Resource
	private VetDAO vetDAO;
	@Override
	public void registerVet(HospitalVO hvo){
		vetDAO.registerVet(hvo);
	}
	/*@Override
	public List<HospitalVO> findHospital(String hospitalName) {
		return vetDAO.findHospital(hospitalName);
	}
	@Override
	public int licenseCheck(VetLicenseVO lvo) {
		return vetDAO.licenseCheck(lvo);
	}
	@Override
	public int findVetById(String vetId) {
		return vetDAO.findVetById(vetId);
	}
	@Override
	public VetVO vetLogin(VetVO vvo) {
		return vetDAO.vetLogin(vvo);
	}*/
}
