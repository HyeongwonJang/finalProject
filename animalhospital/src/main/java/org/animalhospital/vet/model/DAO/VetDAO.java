package org.animalhospital.vet.model.DAO;

import java.util.List;

import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.animalhospital.vet.model.VO.VetVO;

public interface VetDAO {

	/**
	 * 용도 후에 적기
	 * @param hvo
	 * @return
	 */
	public List<HospitalVO> findHospital(HospitalVO hvo);
	/**
	 * 의사를 등록하는 메서드
	 * @param hvo
	 */
	public void registerVet(HospitalVO hvo);
	/**
	 * 면허증 번호를 조회하는 메서드
	 * @param lvo
	 * @return
	 */
	public int checkVetLicense(VetLicenseVO lvo);
	
	public int useCheckVetVicense(VetLicenseVO lvo);
	/**
	 * 의사를 아이디로 찾는 메서드
	 * @param vetId
	 * @return
	 */
	public int findVetById(String vetId);
	/**
	 * 로그인 처리 메서드
	 * @param vvo
	 * @return
	 */
	public HospitalVO loginVet(VetVO vvo);
	/**
	 * 병원을 아이디로 찾는 메서드
	 * @param hospitalId
	 * @return
	 */
	public List<VetVO> findVetByHospitalId(int hospitalId);
	public List<HospitalVO> findAllHospital();
	public int updateVet(HospitalVO hospitalVO);
	public List<VetLicenseVO> findVetLicenseByHospitalId(String hospitalId);
	public int checkVetByTel(VetVO vetVO);
}