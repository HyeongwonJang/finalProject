package org.animalhospital.vet.model.DAO;

import org.animalhospital.vet.model.VO.HospitalVO;

public interface VetDAO {

	public abstract int registerVet(HospitalVO vo);
	public HospitalVO findHospitalById(int hospitalId);
}