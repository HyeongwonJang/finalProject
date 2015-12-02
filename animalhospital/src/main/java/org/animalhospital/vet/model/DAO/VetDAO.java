package org.animalhospital.vet.model.DAO;

import java.util.List;

import org.animalhospital.vet.model.VO.HospitalVO;

public interface VetDAO {

	public abstract int registerVet(HospitalVO vo);
	public HospitalVO findHospitalById(int hospitalId);
	/**
	 * 병원 정보를 모두 가져오는 메서드
	 * 용도: 회원가입 시 병원 리스트를 가져오는데 사용한다.
	 */
	public List<HospitalVO> findAllHospital();
}