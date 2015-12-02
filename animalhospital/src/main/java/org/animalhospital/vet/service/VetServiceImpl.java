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
	
	@Resource(name="vetDAOImpl")
	private VetDAO vetDAO;
	@Override
	public void registerVet(HospitalVO hvo){
		vetDAO.registerVet(hvo);
	}
	@Override
	public List<HospitalVO> findHospital(String hospitalName) {
		return vetDAO.findHospital(hospitalName);
	}
	
	/**
	 * 면허증 번호와 이름으로 면허정보가 있는지 확인한다.
	 * 있으면 1, 없으면 0
	 * 그리고
	 * 면허번호를 사용하고 있는지 확인한다
	 * 사용하고 있다 = 가입을 할 수 없다 = 0
	 * 사용하지 않았다 = 가입을 할 수 있다 = 1
	 */
	public int licenseCheck(VetLicenseVO lvo) {
		if(vetDAO.useVetLicenseCheck(lvo) == 0 && vetDAO.licenseCheck(lvo) == 1){
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public int findVetById(String vetId) {
		return vetDAO.findVetById(vetId);
	}
	@Override
	public VetVO vetLogin(VetVO vvo) {
		return vetDAO.vetLogin(vvo);
	}
	@Override
	public List<VetVO> findVetByHospitalId(int hospitalId) {
		return vetDAO.findVetByHospitalId(hospitalId);
	}
	@Override
	public List<HospitalVO> findAllHospital() {
		return vetDAO.findAllHospital();
	}
	
	
}
