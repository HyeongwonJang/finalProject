package org.animalhospital.petowner;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.service.PetOwnerService;
import org.animalhospital.treatment.model.DAO.TreatmentDAO;
import org.animalhospital.treatment.service.TreatmentService;
import org.animalhospital.vaccination.model.DAO.VaccinationDAO;
import org.animalhospital.vaccination.service.VaccinationService;
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
	
	@Test
	public void TestDao2(){
		/*PetOwnerVO paramVO = new PetOwnerVO();
		List<PetVO> petList = new ArrayList<PetVO>();
		PetVO petVO = new PetVO();
		petVO.setPetName("송이");
		petList.add(petVO);
		paramVO.setPetOwnerNo(1);
		paramVO.setPetOwnerTel("01011112222");
		paramVO.setPetVO(petList);
		ListVO listVO = new ListVO(null, "2000-03-10", "2015-12-06", 1, null);
		//System.out.println("동물:"paramVO.getPetVO().get(0));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("povo", paramVO);
		map.put("listVO", listVO);*/
		//System.out.println("매개변수:" + map);
		//System.out.println(PetOwnerDAO.findPetByTel(paramVO));
		//System.out.println(treatmentService.findTreatmentRecordByNoAndName(map));
		//System.out.println(petOwnerService.findPetListByTel(paramVO));
		//System.out.println(treatmentDAO.findTreatmentRecordByPage(map));
		//System.out.println("총 게시물수:" + treatmentDAO.findAllTreatmentRecord(map));
		//System.out.println("리스트VO:" + treatmentService.findTreatmentRecordByPage(map));
		//System.out.println("검색결과: " + treatmentDAO.findDetailTreatmentRecordByTreatmentNo(42));
/*		System.out.println("반려동물 검색결과: " + treatmentService.findDetailTreatmentRecordByTreatmentNo(42));
		System.out.println("리스트VO:" + treatmentService.findTreatmentRecordVetVerByPage(map));
		System.out.println("진료기록 상세조회 : " + treatmentService.findDetailTreatmentRecordByTreatmentNo(1));*/
		/*VetLicenseVO vo = new VetLicenseVO(4, "이윤아", 0, null);
		System.out.println("서비스 테스트:" + treatmentService.findDetailTreatmentRecordByTreatmentNo(48));
		System.out.println(vaccinationService.findDetailVaccinationRecordByVaccinationRecordNo(1));
		*/
		//System.out.println(vetService.checkVetByTel(new VetVO(null,null, "01011112222", null)));
		testCompareSection();
	}
	public void testCompareSection(){
		int currentSection = 3;
		int maximumSection = 5;
		// 최근예방접종일시 + basic or add <= 현재 날짜 <= 최근예방접종일시 + basic or add + 7일
		// 15-12-10 <= 15-12-15 <= 15-12-17
		// 이면 메세지 전송
		String latelyVaccinationDate = "2015-12-10";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			Date latelyDate = formatter.parse(latelyVaccinationDate);
			cal.setTime(latelyDate);
			cal.add(Calendar.DAY_OF_YEAR, 4);
			latelyDate = cal.getTime();
			cal.add(Calendar.DAY_OF_YEAR, 7);
			Date lastDate = cal.getTime();
			if(latelyDate.getTime() <= new Date().getTime() && new Date().getTime() <= lastDate.getTime()){
				System.out.println("성공 테스트");
			}
			/*System.out.println("****");
			System.out.println("첫 번째 비교시간:" + latelyDate);
			System.out.println("현재시간:" + new Date());
			System.out.println("마지막 비교시간:" + lastDate);
			System.out.println("****");
			*/
			System.out.println("현재 시간:" + new Date());
			System.out.println("테스트 시간: " + latelyDate);
			long currentLong = new Date().getTime();
			long latelyLong = latelyDate.getTime();
			
			if(latelyLong >= currentLong){
				System.out.println("********");
				System.out.println("정상작동");
				System.out.println("********");
			}
			
			cal.setTime(latelyDate);
			cal.add(Calendar.DAY_OF_YEAR, 30 + 7);
			
			System.out.println(formatter.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(currentSection < maximumSection){
			System.out.println("최대차수가 더 크므로 basic date 연산");
		} else {
			System.out.println("최대 차수가 더 작으므로 add date 연산");
		}
	}
}
