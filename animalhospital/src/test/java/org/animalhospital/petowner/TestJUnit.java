package org.animalhospital.petowner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.MemberPetOwnerVO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.vet.model.DAO.PetOwnerDAO;
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
//	@Test
//	public void TestDao(){
//		System.out.println(PetOwnerDAO.findMemberPetOwnerByTel(new PetOwnerVO("01012341234", null)));
//	}
	@Test
	public void TestDao2(){
		ArrayList<PetVO> petVO = new ArrayList<PetVO>();
		petVO.add(new PetVO("까미", "2010-5-13", "수컷", "겁쟁이", "개"));
		petVO.add(new PetVO("백구", "2009-7-6", "암컷", "굉장히 순함", "개"));
		PetOwnerVO petOwnerVO = new PetOwnerVO("01012341234", "강신후");
		MemberPetOwnerVO mpovo = new MemberPetOwnerVO("php", "1111", "인천", petVO, petOwnerVO);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", petVO);
		
		
		
		
		System.out.println("성공");
	}
//	@Test
//	public void TestDao3() {
//		System.out.println(PetOwnerDAO.findPetByTel(new PetOwnerVO("01012341234", null)));
//	}
}
