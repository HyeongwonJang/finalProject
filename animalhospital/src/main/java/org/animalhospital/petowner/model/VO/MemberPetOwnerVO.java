package org.animalhospital.petowner.model.VO;

import java.util.List;

public class MemberPetOwnerVO {
	private String petOwnerId;
	private String petOwnerPassword;
	private String petOwnerAddress;
	private List<PetVO> petVO;
	private PetOwnerVO petOwnerVO;
	
	public MemberPetOwnerVO() {
		super();
	}

	public MemberPetOwnerVO(String petOwnerId, String petOwnerPassword, String petOwnerAddress, List<PetVO> petVO,
			PetOwnerVO petOwnerVO) {
		super();
		this.petOwnerId = petOwnerId;
		this.petOwnerPassword = petOwnerPassword;
		this.petOwnerAddress = petOwnerAddress;
		this.petVO = petVO;
		this.petOwnerVO = petOwnerVO;
	}

	public String getPetOwnerId() {
		return petOwnerId;
	}

	public void setPetOwnerId(String petOwnerId) {
		this.petOwnerId = petOwnerId;
	}

	public String getPetOwnerPassword() {
		return petOwnerPassword;
	}

	public void setPetOwnerPassword(String petOwnerPassword) {
		this.petOwnerPassword = petOwnerPassword;
	}

	public String getPetOwnerAddress() {
		return petOwnerAddress;
	}

	public void setPetOwnerAddress(String petOwnerAddress) {
		this.petOwnerAddress = petOwnerAddress;
	}

	public List<PetVO> getPetVO() {
		return petVO;
	}

	public void setPetVO(List<PetVO> petVO) {
		this.petVO = petVO;
	}

	public PetOwnerVO getPetOwnerVO() {
		return petOwnerVO;
	}

	public void setPetOwnerVO(PetOwnerVO petOwnerVO) {
		this.petOwnerVO = petOwnerVO;
	}

	@Override
	public String toString() {
		return "MemberPetOwnerVO [petOwnerId=" + petOwnerId + ", petOwnerPassword=" + petOwnerPassword
				+ ", petOwnerAddress=" + petOwnerAddress + ", petVO=" + petVO + ", petOwnerVO=" + petOwnerVO + "]";
	}
}
