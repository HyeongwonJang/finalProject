package org.animalhospital.petowner.model.VO;

public class PetVO {
	private String petName;
	private String birthday;
	private String gender;
	private String note;
	private String animalKindName;
	
	public PetVO() {
		super();
	}

	public PetVO(String petName, String birthday, String gender, String note,
			String animalKindName) {
		super();
		this.petName = petName;
		this.birthday = birthday;
		this.gender = gender;
		this.note = note;
		this.animalKindName = animalKindName;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAnimalKindName() {
		return animalKindName;
	}

	public void setAnimalKindName(String animalKindName) {
		this.animalKindName = animalKindName;
	}

	@Override
	public String toString() {
		return "PetVO [petName=" + petName + ", birthday=" + birthday
				+ ", gender=" + gender + ", note=" + note + ", animalKindName="
				+ animalKindName + "]";
	}
	
	
	
}
