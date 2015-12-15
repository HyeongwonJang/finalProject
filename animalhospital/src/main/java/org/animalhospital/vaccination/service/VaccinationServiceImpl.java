package org.animalhospital.vaccination.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
