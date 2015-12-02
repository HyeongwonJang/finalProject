package org.animalhospital.petowner.service;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.petowner.model.DAO.PetOwnerDAO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.vet.model.VO.HospitalVO;
import org.springframework.stereotype.Service;

@Service
public class PetOwnerServiceImpl implements PetOwnerService {
	@Resource
	private PetOwnerDAO petOwnerDAO;
	
	/* (non-Javadoc)
	 * @see org.animalhospital.petowner.model.PetOwnerService#registerMemberPetOwnerAndPet(org.animalhospital.petowner.model.MemberPetOwnerVO)
	 */
	@Override
	public void registerMemberPetOwnerAndPet(PetOwnerVO povo) {
//		petOwnerDAO.registerPetOwner(mpovo);
//		System.out.println("비회원 등록 성공");
//		petOwnerDAO.registerMemberPetOwner(mpovo);
//		System.out.println("회원 등록 성공");
		petOwnerDAO.registerPet(povo);
		System.out.println("동물 리스트 등록 성공");
	}

	@Override
	public PetOwnerVO findMemberPetOwnerByTel(PetOwnerVO povo) {
		return petOwnerDAO.findMemberPetOwnerByTel(povo);
	}

	@Override
	public PetOwnerVO loginPetOwner(PetOwnerVO povo) {
		return petOwnerDAO.loginPetOwner(povo);
	}

	
}
