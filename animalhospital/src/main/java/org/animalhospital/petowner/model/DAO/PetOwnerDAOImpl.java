package org.animalhospital.petowner.model.DAO;


import java.util.HashMap;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class PetOwnerDAOImpl implements PetOwnerDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 신규 보호자 회원가입
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public void registerPetOwner(PetOwnerVO povo) throws Exception{
		sqlSessionTemplate.insert("petOwner.registerPetOwner", povo);
	}
	/**
	 * PET_OWNER table에 전화번호가 등록되어 있는 보호자 회원가입
	 * @param povo
	 * @author 장형원
	 */
	@Override
	public void registerPetOwnerByTel(PetOwnerVO povo) {
		sqlSessionTemplate.update("petOwner.registerPetOwnerByTel", povo);
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
		return sqlSessionTemplate.selectOne("petOwner.loginPetOwner",povo);
	}
	/**
	 * 보호자 회원가입시 petOwnerId 중복 체크
	 * 같은 아이디가 존재하지 않으면 ok
	 * 중복이면 fail
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public int findPetOwnerById(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findPetOwnerById", povo);
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
	public PetOwnerVO checkPetOwnerTel(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.checkPetOwnerTel",povo);
	}
	/**
	 * 보호자 회원 정보 수정
	 * @param request
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public void updatePetOwner(PetOwnerVO povo) {
		sqlSessionTemplate.update("petOwner.updatePetOwner",povo);
	}
	/**
	 * 회원 탈퇴
	 * @param povo
	 * @author 강민호
	 */
	@Override
	public void deletePetOwner(PetOwnerVO povo) {
		sqlSessionTemplate.update("petOwner.deletePetOwner",povo);
	}
	/**
	 * 펫 등록
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public void registerPet(HashMap<String, Object> pom) throws Exception{
		sqlSessionTemplate.insert("petOwner.registerPet", pom);
	}
	
	/**
	 * 펫 정보 수정 처리하는 메서드
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public void updatePet(PetOwnerVO povo) {
		sqlSessionTemplate.update("petOwner.updatePet",povo);
	}
	/**
	 * 펫 정보 수정
	 * petOwnerId를 통하여 보유 동물 목록 조회 
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public PetOwnerVO findPetListById(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findPetListById",povo);
	}
	/**
	 * 펫 정보 수정시 펫 리스트에서 선택된 petName과 session의 petOwnerNo를 이용하여
	 * 펫 정보를 반환
	 * @param povo
	 * @author 강신후, 장형원
	 */
	@Override
	public PetOwnerVO findPetByPetName(HashMap<String, Object> map) {
		return sqlSessionTemplate.selectOne("petOwner.findPetByPetName",map);
	}
	
	
	
	@Override
	public PetOwnerVO findPetListByTel(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findMemberPetOwnerByTel", povo);
	}
	public PetOwnerVO findPetByTel(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findPetByTel", povo);
	}
	@Override
	public TreatmentRecordVO findTreatmentRecordById(PetOwnerVO povo) {
		return sqlSessionTemplate.selectOne("petOwner.findTreatmentRecordById",povo);
	}
	public PetOwnerVO findPetListByPetownerTel(String petOwnerTel){
		return sqlSessionTemplate.selectOne("petOwner.findPetListByPetownerTel",petOwnerTel);
	}

	

	
	
	
}
