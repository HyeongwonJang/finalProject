package org.animalhospital.petowner.service;

import javax.annotation.Resource;
import org.animalhospital.petowner.model.VO.MemberPetOwnerVO;
import org.animalhospital.vet.model.DAO.PetOwnerDAO;
import org.springframework.stereotype.Service;

@Service
public class PetOwnerServiceImpl implements PetOwnerService {
	@Resource
	private PetOwnerDAO petOwnerDAO;
	
	/* (non-Javadoc)
	 * @see org.animalhospital.petowner.model.PetOwnerService#registerMemberPetOwnerAndPet(org.animalhospital.petowner.model.MemberPetOwnerVO)
	 */
	@Override
	public void registerMemberPetOwnerAndPet(MemberPetOwnerVO mpovo) {
//		petOwnerDAO.registerPetOwner(mpovo);
//		System.out.println("비회원 등록 성공");
//		petOwnerDAO.registerMemberPetOwner(mpovo);
//		System.out.println("회원 등록 성공");
		petOwnerDAO.registerPet(mpovo);
		System.out.println("동물 리스트 등록 성공");
	}
}
