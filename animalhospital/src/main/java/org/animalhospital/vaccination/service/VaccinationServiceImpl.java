package org.animalhospital.vaccination.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
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
	public int registerVetVaccination(VaccinationRecordVO vrvo){
		return vaccinationDAO.registerVetVaccination(vrvo);
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

	@Override
	public VaccinationRecordVO findDetailVaccinationRecordByVaccinationRecordNo(
			int vaccinationRecordNo) {
		PetVO detailPetVO = vaccinationDAO.findDetailPetRecordByVaccinationtRecordNo(vaccinationRecordNo);
		VaccinationRecordVO searchVaccinationVO = vaccinationDAO.findDetailVaccinationRecordByVaccinationRecordNo(vaccinationRecordNo);
		searchVaccinationVO.getPetOwnerVO().addPetVO(detailPetVO);
		return searchVaccinationVO;
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
	public List<Object> findAlarmListByPetOwnerTel(String petOwnerTel) throws ParseException{
		List<Object> alarmList = new ArrayList<Object>();
		List<VaccinationRecordVO> vaccinationList = findVaccinationRecordAlarmByPetOwnerNo(petOwnerTel);
		alarmList.addAll(vaccinationList);
		
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
	private List<VaccinationRecordVO> findVaccinationRecordAlarmByPetOwnerNo(String petOwnerTel) throws ParseException{
		List<VaccinationRecordVO> alarmList = new ArrayList<VaccinationRecordVO>();
		ArrayList<VaccinationRecordVO> latelyRecord = new ArrayList<VaccinationRecordVO>();
		List<PetVO> petList = petOwnerDAO.findPetListByPetownerTel(petOwnerTel).getPetVO();
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
				latelyRecord.add(tempVO);
			}
		}
		for(int ai=0; ai<latelyRecord.size(); ai++){
			if(isCompareVaccinationAlarmDate(latelyRecord.get(ai))){
				alarmList.add(latelyRecord.get(ai));
			} 
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
