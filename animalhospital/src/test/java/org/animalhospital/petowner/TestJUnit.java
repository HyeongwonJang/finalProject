package org.animalhospital.petowner;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.vet.model.DAO.VetDAO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.animalhospital.vet.model.VO.VetVO;
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
	@Test
	public void TestDao2(){
		PetOwnerVO paramVO = new PetOwnerVO();
		paramVO.setPetOwnerId("jsp");
		paramVO.setPetOwnerTel("01011112222");
		System.out.println(PetOwnerDAO.findPetByTel(paramVO));
		//System.out.println(vetDAO.findHospital("동물"));
		
	}
}
