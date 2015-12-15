package org.animalhospital.vaccination.model.VO;

public class VaccinationVO {
	private int vaccinationNo;
	private String vaccinationName;
	private String vaccinationBasicPeriod;
	private String vaccinationAddPeriod;
	private int vaccinationMaximumSection;
	
	public VaccinationVO() {
		super();
	}
	public VaccinationVO(int vaccinationNo, String vaccinationName,
			String vaccinationBasicPeriod, String vaccinationAddPeriod,  int vaccinationMaximumSection) {
		super();
		this.vaccinationNo = vaccinationNo;
		this.vaccinationName = vaccinationName;
		this.vaccinationBasicPeriod = vaccinationBasicPeriod;
		this.vaccinationAddPeriod = vaccinationAddPeriod;
		this.vaccinationMaximumSection=vaccinationMaximumSection;
	}
	public int getVaccinationNo() {
		return vaccinationNo;
	}
	public void setVaccinationNo(int vaccinationNo) {
		this.vaccinationNo = vaccinationNo;
	}
	public String getVaccinationName() {
		return vaccinationName;
	}
	public void setVaccinationName(String vaccinationName) {
		this.vaccinationName = vaccinationName;
	}
	public String getVaccinationBasicPeriod() {
		return vaccinationBasicPeriod;
	}
	public void setVaccinationBasicPeriod(String vaccinationBasicPeriod) {
		this.vaccinationBasicPeriod = vaccinationBasicPeriod;
	}
	public String getVaccinationAddPeriod() {
		return vaccinationAddPeriod;
	}
	public void setVaccinationAddPeriod(String vaccinationAddPeriod) {
		this.vaccinationAddPeriod = vaccinationAddPeriod;
	}
	public int getVaccinationMaximumSection() {
		return vaccinationMaximumSection;
	}
	public void setVaccinationMaximumSection(int vaccinationMaximumSection) {
		this.vaccinationMaximumSection = vaccinationMaximumSection;
	}
	@Override
	public String toString() {
		return "VaccinationVO [vaccinationNo=" + vaccinationNo
				+ ", vaccinationName=" + vaccinationName
				+ ", vaccinationBasicPeriod=" + vaccinationBasicPeriod
				+ ", vaccinationAddPeriod=" + vaccinationAddPeriod
				+ ", vaccinationMaximumSection=" + vaccinationMaximumSection
				+ "]";
	}

	
}
