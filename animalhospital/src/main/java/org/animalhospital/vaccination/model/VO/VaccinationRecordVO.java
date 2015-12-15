package org.animalhospital.vaccination.model.VO;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.vet.model.VO.HospitalVO;

public class VaccinationRecordVO {
	private int vaccinationRecordNo;
	private String vaccinationHours;
	private String vaccinationContent;
	private double petWeight;
	private int vaccinationCurrentSection;
	private PetOwnerVO petOwnerVO;
	private HospitalVO hospitalVO;
	private VaccinationVO vaccinationVO;
	public VaccinationRecordVO() {
		super();
	}
	public VaccinationRecordVO(int vaccinationRecordNo,
			String vaccinationHours, String vaccinationContent,
			double petWeight, int vaccinationCurrentSection,
			PetOwnerVO petOwnerVO, HospitalVO hospitalVO,
			VaccinationVO vaccinationVO) {
		super();
		this.vaccinationRecordNo = vaccinationRecordNo;
		this.vaccinationHours = vaccinationHours;
		this.vaccinationContent = vaccinationContent;
		this.petWeight = petWeight;
		this.vaccinationCurrentSection = vaccinationCurrentSection;
		this.petOwnerVO = petOwnerVO;
		this.hospitalVO = hospitalVO;
		this.vaccinationVO = vaccinationVO;
	}
	public int getVaccinationRecordNo() {
		return vaccinationRecordNo;
	}
	public void setVaccinationRecordNo(int vaccinationRecordNo) {
		this.vaccinationRecordNo = vaccinationRecordNo;
	}
	public String getVaccinationHours() {
		return vaccinationHours;
	}
	public void setVaccinationHours(String vaccinationHours) {
		this.vaccinationHours = vaccinationHours;
	}
	public String getVaccinationContent() {
		return vaccinationContent;
	}
	public void setVaccinationContent(String vaccinationContent) {
		this.vaccinationContent = vaccinationContent;
	}
	public double getPetWeight() {
		return petWeight;
	}
	public void setPetWeight(double petWeight) {
		this.petWeight = petWeight;
	}
	public int getVaccinationCurrentSection() {
		return vaccinationCurrentSection;
	}
	public void setVaccinationCurrentSection(int vaccinationCurrentSection) {
		this.vaccinationCurrentSection = vaccinationCurrentSection;
	}
	public PetOwnerVO getPetOwnerVO() {
		return petOwnerVO;
	}
	public void setPetOwnerVO(PetOwnerVO petOwnerVO) {
		this.petOwnerVO = petOwnerVO;
	}
	public HospitalVO getHospitalVO() {
		return hospitalVO;
	}
	public void setHospitalVO(HospitalVO hospitalVO) {
		this.hospitalVO = hospitalVO;
	}
	public VaccinationVO getVaccinationVO() {
		return vaccinationVO;
	}
	public void setVaccinationVO(VaccinationVO vaccinationVO) {
		this.vaccinationVO = vaccinationVO;
	}
	@Override
	public String toString() {
		return "VaccinationRecordVO [vaccinationRecordNo="
				+ vaccinationRecordNo + ", vaccinationHours="
				+ vaccinationHours + ", vaccinationContent="
				+ vaccinationContent + ", petWeight=" + petWeight
				+ ", vaccinationCurrentSection=" + vaccinationCurrentSection
				+ ", petOwnerVO=" + petOwnerVO + ", hospitalVO=" + hospitalVO
				+ ", vaccinationVO=" + vaccinationVO + "]";
	}
	
	
}