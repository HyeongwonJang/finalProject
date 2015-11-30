package org.animalhospital.petowner;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.vet.model.DAO.VetDAO;
import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.animalhospital.vet.model.VO.VetVO;
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
//	@Test
//	public void TestDao(){
//		System.out.println(PetOwnerDAO.findMemberPetOwnerByTel(new PetOwnerVO("01012341234", null)));
//	}
	@Test
	public void TestDao2(){
		/*HospitalVO vo = new HospitalVO();
		List<VetVO> list  = new ArrayList<VetVO>();
		list.add(new VetVO("java", "1234", "01011112222", new VetLicenseVO(2, null, 0, null)));
		vo.setHospitalId(4);
		vo.setVetList(list);
		
		
		vetDAOImpl.registerVet(vo);*/
		
		System.out.println(vetDAO.findHospitalById(2));
		System.out.println("성공");
	}
//	@Test
//	public void TestDao3() {
//		System.out.println(PetOwnerDAO.findPetByTel(new PetOwnerVO("01012341234", null)));
//	}
}
