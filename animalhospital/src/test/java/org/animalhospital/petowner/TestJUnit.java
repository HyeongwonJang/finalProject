package org.animalhospital.petowner;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.petowner.service.PetOwnerService;
import org.animalhospital.reservation.model.DAO.ReservationDAO;
import org.animalhospital.reservation.model.VO.ReservationVO;
import org.animalhospital.treatment.model.DAO.TreatmentDAO;
import org.animalhospital.treatment.service.TreatmentService;
import org.animalhospital.vaccination.model.DAO.VaccinationDAO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
import org.animalhospital.vaccination.service.VaccinationService;
import org.animalhospital.vaccination.service.VaccinationServiceImpl;
import org.animalhospital.vet.model.DAO.VetDAO;
import org.animalhospital.vet.service.VetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestJUnit {
	@Resource
	private PetOwnerDAO PetOwnerDAO;
	@Resource
	private VetDAO vetDAO;
	@Resource
	private VetService vetService;
	@Resource
	private PetOwnerService petOwnerService;
	@Resource 
	private TreatmentDAO treatmentDAO;
	@Resource
	private TreatmentService treatmentService;
	@Resource
	private VaccinationDAO vaccinationDAO;
	@Resource
	private VaccinationService vaccinationService;
	@Resource
	private ReservationDAO reservationDAO; 
	
	@Test
	public void TestDao2() throws ParseException{
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("petOwnerTel", "01011111111");
		map.put("petName", "비지");
		List<Integer> vaccinationNoList=vaccinationDAO.findVaccinationNoList(map);
		for(int i=0; i<vaccinationNoList.size(); i++){
			map.put("vaccinationNo", vaccinationNoList.get(i));
			VaccinationRecordVO vaccinationRecordHistoryInfo=vaccinationDAO.findLastVaccinationHistoryInfo(map);
			vaccinationRecordHistoryInfo.getPetOwnerVO().addPetVO(new PetVO("두부",null,null,null,null));
			System.out.println(vaccinationRecordHistoryInfo);
		}*/
<<<<<<< HEAD
//		System.out.println(vaccinationService.findAlarmListByPetOwnerTel("01011111111"));
		System.out.println(reservationDAO.findPetOwnerReservation("tp1"));
=======
		vaccinationService.findAlarmListByPetOwnerTel("01011111111");
		//System.out.println(vaccinationService.findAlarmListByPetOwnerTel("01011111111"));
		
>>>>>>> branch 'master' of https://github.com/prototype01/finalProject.git
		

	}
	
}
