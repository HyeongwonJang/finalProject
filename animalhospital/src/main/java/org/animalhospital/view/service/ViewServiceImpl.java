package org.animalhospital.view.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.reservation.model.DAO.ReservationDAO;
import org.animalhospital.treatment.model.DAO.TreatmentDAO;
import org.animalhospital.vet.model.DAO.VetDAO;
import org.animalhospital.vet.model.VO.HospitalVO;
import org.springframework.stereotype.Service;

@Service
public class ViewServiceImpl implements ViewService {
	@Resource
	private PetOwnerDAO petOwnerDAO;
	@Resource
	private TreatmentDAO treatmentDAO;
	@Resource
	private ReservationDAO reservationDAO;
	@Resource
	private VetDAO vetDAO;
	
	@Override
	public Map<String, Object> findPetOwnerMainPageData(PetOwnerVO paramVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("treatmentList", treatmentDAO.findTreatmentRecordByPetOwnerTel(
				paramVO.getPetOwnerTel()));
		map.put("reservationList", 
				reservationDAO.findTodayPetOwnerReservation(paramVO.getPetOwnerId()));
		map.put("petList", petOwnerDAO.findPetListByPetownerTel(paramVO.getPetOwnerTel()));
		return map;
	}

	@Override
	public Map<String, Object> findVetOwnerMainPageData(HospitalVO paramVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		int vetLicenseNo = paramVO.getVetList().get(0).getVetLicenseVO().getVetLicenseNo();
		map.put("treatmentList", 
				treatmentDAO.findTreatmentRecordByVetLicenseNo(
						vetLicenseNo));
		map.put("reservationList", 
				reservationDAO.findTodayVetReservation(
						vetLicenseNo));
		map.put("vetList", vetDAO.findVetByHospitalId(paramVO.getHospitalId()));
		return map;
	}

	
	
}
