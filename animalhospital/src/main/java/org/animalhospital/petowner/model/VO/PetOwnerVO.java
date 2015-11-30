package org.animalhospital.petowner.model.VO;

public class PetOwnerVO {
	private String petOwnerTel;
	private String petOwnerName;
	public PetOwnerVO() {
		super();
	}
	public PetOwnerVO(String petOwnerTel, String petOwnerName) {
		super();
		this.petOwnerTel = petOwnerTel;
		this.petOwnerName = petOwnerName;
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
	@Override
	public String toString() {
		return "PetOwner [petOwnerTel=" + petOwnerTel + ", petOwnerName="
				+ petOwnerName + "]";
	}
	
	
	
}
