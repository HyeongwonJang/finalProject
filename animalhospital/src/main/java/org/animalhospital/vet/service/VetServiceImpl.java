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
	public List<HospitalVO> findHospital(HospitalVO hvo) {
		return vetDAO.findHospital(hvo);
	}
	
	/**
	 * 면허증 번호와 이름으로 면허정보가 있는지 확인한다.
	 * 있으면 1, 없으면 0
	 * 그리고
	 * 면허번호를 사용하고 있는지 확인한다
	 * 사용하고 있다 = 가입을 할 수 없다 = 0
	 * 사용하지 않았다 = 가입을 할 수 있다 = 1
	 */
	public String checkVetLicense(VetLicenseVO lvo) {
		if(vetDAO.useCheckVetVicense(lvo) == 0 && vetDAO.checkVetLicense(lvo) == 1){
			return "ok";
		} else {
			return "fail";
		}
	}
	
	@Override
	public int findVetById(String vetId) {
		return vetDAO.findVetById(vetId);
	}
	@Override
	public HospitalVO loginVet(VetVO vvo) {
		return vetDAO.loginVet(vvo);
	}
	@Override
	public List<VetVO> findVetByHospitalId(int hospitalId) {
		return vetDAO.findVetByHospitalId(hospitalId);
	}
	@Override
	public List<HospitalVO> findAllHospital() {
		return vetDAO.findAllHospital();
	}
	public int updateVet(HospitalVO hospitalVO){
		return vetDAO.updateVet(hospitalVO);
	}
	@Override
	public List<VetLicenseVO> findVetLicenseByHospitalId(String hospitalId) {
		return vetDAO.findVetLicenseByHospitalId(hospitalId);
	}
	@Override
	public int checkVetByTel(VetVO vetVO) {
		return vetDAO.checkVetByTel(vetVO);
	}
	
	
}
