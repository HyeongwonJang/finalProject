package org.animalhospital.petowner.model.VO;

import java.util.List;

public class PetOwnerVO {
	private int petOwnerNo;
	private String petOwnerTel;
	private String petOwnerName;
	private String petOwnerId;
	private String petOwnerPassword;
	private String petOwnerAddress;
	private List<PetVO> petVO;
	
	public PetOwnerVO() {
		super();
	}

	public PetOwnerVO(int petOwnerNo, String petOwnerTel, String petOwnerName,
			String petOwnerId, String petOwnerPassword, String petOwnerAddress,
			List<PetVO> petVO) {
		super();
		this.petOwnerNo = petOwnerNo;
		this.petOwnerTel = petOwnerTel;
		this.petOwnerName = petOwnerName;
		this.petOwnerId = petOwnerId;
		this.petOwnerPassword = petOwnerPassword;
		this.petOwnerAddress = petOwnerAddress;
		this.petVO = petVO;
	}

	public int getPetOwnerNo() {
		return petOwnerNo;
	}

	public void setPetOwnerNo(int petOwnerNo) {
		this.petOwnerNo = petOwnerNo;
	}

	public String getPetOwnerTel() {
		return petOwnerTel;
	}

	public void setPetOwnerTel(String petOwnerTel) {
		this.petOwnerTel = petOwnerTel;
	}

	public String getPetOwnerName() {
		return petOwnerName;
	}

	public void setPetOwnerName(String petOwnerName) {
		this.petOwnerName = petOwnerName;
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

	@Override
	public String toString() {
		return "PetOwnerVO [petOwnerNo=" + petOwnerNo + ", petOwnerTel="
				+ petOwnerTel + ", petOwnerName=" + petOwnerName
				+ ", petOwnerId=" + petOwnerId + ", petOwnerPassword="
				+ petOwnerPassword + ", petOwnerAddress=" + petOwnerAddress
				+ ", petVO=" + petVO + "]";
	}
	
	
	
	
}
