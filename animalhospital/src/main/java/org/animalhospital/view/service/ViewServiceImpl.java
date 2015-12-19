package org.animalhospital.view.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.reservation.model.DAO.ReservationDAO;
import org.animalhospital.treatment.model.DAO.TreatmentDAO;
import org.animalhospital.vaccination.model.DAO.VaccinationDAO;
import org.animalhospital.vaccination.model.VO.VaccinationRecordVO;
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
	@Resource
	private VaccinationDAO vaccinationDAO;
	
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
	

	/**
	 * 전체 알람목록을 출력한다
	 * 만든 이유: 혹시 다른 알람기능을 사용할 때는 추가해서 사용하기 위하여
	 * 				메소드가 많아지면 private 메소드를 모두 bean으로 보내는 것도 좋은 방법인듯
	 * @param petOwnerTel
	 * @return
	 * @throws ParseException
	 * @author 민호
	 */
	public List<Object> findAlarmListByPetOwnerTel(String petOwnerTel){
		List<Object> alarmList = new ArrayList<Object>();
		List<VaccinationRecordVO> vaccinationList = findVaccinationRecordAlarmByPetOwnerNo(petOwnerTel);
		if(vaccinationList != null){
			alarmList.addAll(vaccinationList);
		} 	
		return alarmList;
	}
	
	/**
	 * 예방접종 알람목록을 출력하는 메서드(보호자 기준)
	 * 작동순서
	 * 	1) 보호자 전화번호로 반려동물 목록을 조회한다.
	 *	2) 조회한 반려동물 목록을 기준으로 반려동물마다의 예방접종목록을 조회한다
	 *	3) 반려동물 이름, 보호자 전화번호, 예방접종번호로 가장 최근의 예방접종목록을 조회한다
	 *	4) 임시 리스트에 예방접종목록을 담는다.
	 *	5) 알람조건에 따라서 판별하는 메소드를 통하여 알람을 알려줄 메소드를 출력한다
	 * 
	 * @param petOwnerTel
	 * @return
	 * @throws ParseException
	 * @author 민호
	 */
	private List<VaccinationRecordVO> findVaccinationRecordAlarmByPetOwnerNo(String petOwnerTel) {
		ArrayList<VaccinationRecordVO> alarmList = new ArrayList<VaccinationRecordVO>();
		List<PetVO> petList = vaccinationDAO.findTookVaccinationPetListByPetOwnerTel(petOwnerTel);
		if(petList != null){
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
					VaccinationRecordVO tempVO = vaccinationDAO.findLastVaccinationHistoryInfo(paramMap);
					tempVO.getPetOwnerVO().addPetName((String) paramMap.get("petName"));
					try {
						if(isCompareVaccinationAlarmDate(tempVO)){
							alarmList.add(tempVO);
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			alarmList = null;
		}
		
		return alarmList;
	}
	
	/**
	 * 가장 최신의 예방접종기록을 기준으로 알람을 출력해야할지 안 해야할지 판별하는 메서드
	 * 판별기준
	 * 	접종시기 < 현재 시간 < 접종시기 + 1주일
	 * 
	 * 매개변수: VaccinationRecordVO
	 * @return 
	 * @throws ParseException
	 * @author 민호
	 */
	private boolean isCompareVaccinationAlarmDate(VaccinationRecordVO paramVO) throws ParseException{
		boolean flag = false;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date minAlarmDate = formatter.parse(paramVO.getVaccinationHours());
		cal.setTime(minAlarmDate);
		// 현재 차수가 최대 차수보다 작을 때 = 기본 접종시간을 적용해야 한다
		// 현재 차수가 최대 차수보다 클 때 = 추가 접종시간을 적용해야 한다
		if(paramVO.getVaccinationCurrentSection() <=
				paramVO.getVaccinationVO().getVaccinationMaximumSection()){
			cal.add(Calendar.DAY_OF_YEAR, paramVO.getVaccinationVO().getVaccinationBasicPeriod());
		} else {
			cal.add(Calendar.DAY_OF_YEAR, paramVO.getVaccinationVO().getVaccinationAddPeriod());
		}
		minAlarmDate = cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, 7);
		Date maxAlarmDate = cal.getTime();
		if(minAlarmDate.getTime() <= new Date().getTime()
				&& new Date().getTime() <= maxAlarmDate.getTime()){
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	
	
}
