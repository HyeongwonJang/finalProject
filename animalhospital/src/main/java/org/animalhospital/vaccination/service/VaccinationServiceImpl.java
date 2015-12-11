package org.animalhospital.vaccination.service;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.DiseaseVO;
import org.animalhospital.vaccination.model.DAO.VaccinationDAO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
import org.animalhospital.vaccination.model.VO.VaccinationVO;
import org.springframework.stereotype.Service;

@Service
public class VaccinationServiceImpl implements VaccinationService {
	
	@Resource(name="vaccinationDAOImpl")
	private VaccinationDAO vaccinationDAO;
	
	@Resource(name="petOwnerDAOImpl")
	private PetOwnerDAO petOwnerDAO;
	
	/* (non-Javadoc)
	 * @see org.animalhospital.vaccination.service.VaccinationService#registerVaccination(org.animalhospital.vaccination.model.VO.VaccinationVO)
	 */
	@Override
	public int registerVaccination(VaccinationRecordVO vrvo){
		return vaccinationDAO.registerVaccination(vrvo);
	}

	@Override
	public PetOwnerVO findPetByTel(PetOwnerVO povo) {
		return petOwnerDAO.findPetByTel(povo);
	}

	@Override
	public List<VaccinationVO> findAllVaccination() {
		return vaccinationDAO.findAllVaccination();
	}
	
	@Override
	public List<DiseaseVO> findAllDisease(){
		return vaccinationDAO.findAllDisease();
	}
	
	@Override
	public PetOwnerVO findPetListById(PetOwnerVO povo) {
		return vaccinationDAO.findPetListById(povo);
	}
}
