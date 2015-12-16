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
		map.put("petName", "두부");
		List<Integer> vaccinationNoList=vaccinationDAO.findVaccinationNoList(map);
		for(int i=0; i<vaccinationNoList.size(); i++){
			map.put("vaccinationNo", vaccinationNoList.get(i));
			VaccinationRecordVO vaccinationRecordHistoryInfo=vaccinationDAO.findLastVaccinationHistoryInfo(map);
			vaccinationRecordHistoryInfo.getPetOwnerVO().addPetVO(new PetVO("두부",null,null,null,null));
			System.out.println(vaccinationRecordHistoryInfo);
		}*/
//		System.out.println(vaccinationService.findAlarmListByPetOwnerTel("01011111111"));
		System.out.println(reservationDAO.findPetOwnerReservation("tp1"));
		

	}
	/*
	public List<VaccinationRecordVO> findVaccinationRecordAlarmByPetOwnerNo(String petOwnerTel) throws ParseException{
		List<VaccinationRecordVO> alarmList = new ArrayList<VaccinationRecordVO>();
		ArrayList<VaccinationRecordVO> latelyRecord = new ArrayList<VaccinationRecordVO>();
		List<PetVO> petList = PetOwnerDAO.findPetListByPetownerTel(petOwnerTel).getPetVO();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("petOwnerTel", petOwnerTel);
		// 펫 마리수만큼 반복
		for(int pi=0; pi<petList.size(); pi++){
			paramMap.put("petName", petList.get(pi).getPetName());
			List<Integer> vaccinationList = vaccinationDAO.findVaccinationNoList(paramMap);
			// 접종 받은 예방접종 종류만큼 반복
			for(int vi=0; vi<vaccinationList.size(); vi++){
				paramMap.put("vaccinationNo", vaccinationList.get(vi));
				//최신 예방접종 조회
				latelyRecord.add(vaccinationDAO.findLastVaccinationHistoryInfo(paramMap));
				latelyRecord.get(vi).getPetOwnerVO().addPetVO(
						new PetVO(petList.get(pi).getPetName(), null, null, null, null));
			}
		}
		for(int ai=0; ai<latelyRecord.size(); ai++){
			if(((VaccinationServiceImpl) vaccinationService).
					isCompareVaccinationAlarmDate(latelyRecord.get(ai))){
				alarmList.add(latelyRecord.get(ai));
			} 
		}
		return alarmList;
	}*/
}
