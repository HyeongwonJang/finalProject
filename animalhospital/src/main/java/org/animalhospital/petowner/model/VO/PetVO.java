package org.animalhospital.petowner.model.VO;

public class PetVO {
	private String petName;
	private String petBirthday;
	private String petGender;
	private String petNote;
	private String animalKindName;
	
	public PetVO() {
		super();
	}

	public PetVO(String petName, String petBirthday, String petGender,
			String petNote, String animalKindName) {
		super();
		this.petName = petName;
		this.petBirthday = petBirthday;
		this.petGender = petGender;
		this.petNote = petNote;
		this.animalKindName = animalKindName;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetBirthday() {
		return petBirthday;
	}

	public void setPetBirthday(String petBirthday) {
		this.petBirthday = petBirthday;
	}

	public String getPetGender() {
		return petGender;
	}

	public void setPetGender(String petGender) {
		this.petGender = petGender;
	}

	public String getPetNote() {
		return petNote;
	}

	public void setPetNote(String petNote) {
		this.petNote = petNote;
	}

	public String getAnimalKindName() {
		return animalKindName;
	}

	public void setAnimalKindName(String animalKindName) {
		this.animalKindName = animalKindName;
	}

	@Override
	public String toString() {
		return "PetVO [petName=" + petName + ", petBirthday=" + petBirthday
				+ ", petGender=" + petGender + ", petNote=" + petNote
				+ ", animalKindName=" + animalKindName + "]";
	}

	
	
	
	
}
