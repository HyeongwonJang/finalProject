package org.animalhospital.vaccination.model.VO;

public class VaccinationVO {
	private String vaccinationName;

	public VaccinationVO() {
		super();
	}

	public VaccinationVO(String vaccinationName) {
		super();
		this.vaccinationName = vaccinationName;
	}

	public String getVaccinationName() {
		return vaccinationName;
	}

	public void setVaccinationName(String vaccinationName) {
		this.vaccinationName = vaccinationName;
	}

	@Override
	public String toString() {
		return "VaccinationVO [vaccinationName=" + vaccinationName + "]";
	}


}
