package org.animalhospital.petowner.service;

import java.util.HashMap;
import javax.annotation.Resource;
import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetOwnerServiceImpl implements PetOwnerService {
	@Resource
	private PetOwnerDAO petOwnerDAO;

	/**
	 * 신규 보호자 회원가입
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Transactional
	@Override
	public void registerPetOwner(PetOwnerVO povo) throws Exception {
		petOwnerDAO.registerPetOwner(povo);
		HashMap<String, Object> pom = new HashMap<String, Object>();
		pom.put("petOwnerNo", povo.getPetOwnerNo());
		if(povo.getPetVO()!=null) {
			for(int i=0; i<povo.getPetVO().size(); i++) {
				pom.put("petVO", povo.getPetVO().get(i));
				petOwnerDAO.registerPet(pom);
			}
		}
	}
	/**
	 * PET_OWNER table에 전화번호가 등록되어 있는 보호자 회원가입
	 * @param povo
	 * @author 장형원
	 */
	@Transactional
	@Override
	public void registerPetOwnerByTel(PetOwnerVO povo) throws Exception {
		petOwnerDAO.registerPetOwnerByTel(povo);
		HashMap<String, Object> pom = new HashMap<String, Object>();
		pom.put("petOwnerNo", petOwnerDAO.loginPetOwner(povo).getPetOwnerNo());
		if(povo.getPetVO()!=null) {
			for(int i=0; i<povo.getPetVO().size(); i++) {
				pom.put("petVO", povo.getPetVO().get(i));
				petOwnerDAO.registerPet(pom);
			}
		}
	}
	
	/**
	 * 보호자 로그인
	 * userLevel로 수의사와 보호자를 구분한다
	 * 보호자 userLevel = "petOwner"
	 * @param request
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public PetOwnerVO loginPetOwner(PetOwnerVO povo) {
		return petOwnerDAO.loginPetOwner(povo);
	}
	/**
	 * 보호자 회원가입시 petOwnerId 중복 체크
	 * 같은 아이디가 존재하지 않으면 ok
	 * 중복이면 fail
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public String findPetOwnerById(PetOwnerVO povo) {
		return petOwnerDAO.findPetOwnerById(povo)==0 ? "ok" : "fail";
	}
	/**
	 * 보호자 회원가입시 전화번호 중복 체크
	 * 전화번호가 존재하고 id가 null이라면 ok_update(비가입, 진료내역이 있음)
	 * 전화번호가 존재하지 않는다면 ok(진료내역이 없는 신규)
	 * 전화번호와 id가 모두 존재한다면 fail(가입한 회원의 전화번호)
	 * @param povo
	 * @author 장형원
	 */
	@Override
	public String checkPetOwnerTel(PetOwnerVO povo) {
		PetOwnerVO telCheckedpovo = petOwnerDAO.checkPetOwnerTel(povo);
		String flag = "fail";
		if(telCheckedpovo != null) {
			if(telCheckedpovo.getPetOwnerTel() != null)
				flag = "fail";
			if(telCheckedpovo.getPetOwnerId() == null) {
				flag = "ok_update";
			}
		} else 
			flag = "ok";
		return flag;
	}

	/**
	 * 보호자 회원 정보 수정
	 * @param request
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public void updatePetOwner(PetOwnerVO povo) {
		petOwnerDAO.updatePetOwner(povo);
	}
	
	/**
	 * 펫 등록
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Transactional
	@Override
	public void registerPet(PetOwnerVO povo) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(povo);
		map.put("petOwnerNo", povo.getPetOwnerNo());
		if(povo.getPetVO()!=null) {
			for(int i=0; i<povo.getPetVO().size(); i++) {
				map.put("petVO", povo.getPetVO().get(i));
				petOwnerDAO.registerPet(map);
			}
		}
	}
	
	/**
	 * 펫 정보 수정 처리하는 메서드
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public void updatePet(PetOwnerVO povo) {
		petOwnerDAO.updatePet(povo);
	}
	/**
	 * 펫 정보 수정
	 * petOwnerId를 통하여 보유 동물 목록 조회 
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public PetOwnerVO findPetListById(PetOwnerVO povo) {
		return petOwnerDAO.findPetListById(povo);
	}
	/**
	 * 펫 정보 수정시 펫 리스트에서 선택된 petName과 session의 petOwnerNo를 이용하여
	 * 펫 정보를 반환
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public PetOwnerVO findPetByPetName(PetOwnerVO povo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(povo);
		map.put("petOwnerNo", povo.getPetOwnerNo());
		if(povo.getPetVO()!=null) {
			for(int i=0; i<povo.getPetVO().size(); i++) {
				map.put("petVO", povo.getPetVO().get(i));
			}
		}
		return petOwnerDAO.findPetByPetName(map);
	}
	
	
	
	

	@Override
	public PetOwnerVO findPetListByTel(PetOwnerVO povo) {
		return petOwnerDAO.findPetListByTel(povo);
	}
	@Override
	public PetOwnerVO findPetListByPetownerTel(String petOwnerTel){
		return petOwnerDAO.findPetListByPetownerTel(petOwnerTel);
	}

	
	
	
	
	
	
}
