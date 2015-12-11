package org.animalhospital.vaccination.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
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
	
	@Resource
	private ListVO listVO;
	
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
/*	
	@Override
	public List<DiseaseVO> findAllDisease(){
		return vaccinationDAO.findAllDisease();
	}
	
	@Override
	public PetOwnerVO findPetListById(PetOwnerVO povo) {
		return vaccinationDAO.findPetListById(povo);
	}*/

	@Override
	public ListVO findVaccinationRecordByPetOwnerTelAndPetName(
			Map<String, Object> paramMap) {
		List<Object> list = vaccinationDAO.findVaccinationRecordByPetOwnerTelAndPetName(paramMap);
		List<PetVO> petList=((PetOwnerVO) paramMap.get("povo")).getPetVO();
		for(int li=0; li<list.size(); li++){
			((VaccinationRecordVO) list.get(li)).getPetOwnerVO().setPetVO(petList);
		}
		listVO.setList(list);
		listVO.getPagingBean().setNowPage(((ListVO) paramMap.get("listVO")).getPage());
		listVO.getPagingBean().setTotalContents(vaccinationDAO.findAllVaccinationRecord(paramMap));
		return listVO;
	}
}
