package org.animalhospital.petowner;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.petowner.service.PetOwnerService;
import org.animalhospital.treatment.model.DAO.TreatmentDAO;
import org.animalhospital.treatment.service.TreatmentService;
import org.animalhospital.vaccination.model.DAO.VaccinationDAO;
import org.animalhospital.vet.model.DAO.VetDAO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
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
	
	@Test
	public void TestDao2(){
		PetOwnerVO paramVO = new PetOwnerVO();
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
		map.put("listVO", listVO);
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
		VetLicenseVO vo = new VetLicenseVO(4, "이윤아", 0, null);
		System.out.println("서비스 테스트:" + vetService.checkVetLicense(vo));
	}
}
