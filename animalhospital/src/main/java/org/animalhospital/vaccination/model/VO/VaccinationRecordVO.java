package org.animalhospital.vaccination.model.VO;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.vet.model.VO.VetVO;

public class VaccinationRecordVO {
	private int vaccinationRecordNo;
	private String vaccinationHours;
	private String vaccinationContent;
	private String petWeight;
	private PetOwnerVO petOwnerVO;
	private VetVO vetVO;
	private VaccinationVO vaccinationVO;
	public VaccinationRecordVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VaccinationRecordVO(int vaccinationRecordNo,
			String vaccinationHours, String vaccinationContent,
			String petWeight, PetOwnerVO petOwnerVO, VetVO vetVO,
			VaccinationVO vaccinationVO) {
		super();
		this.vaccinationRecordNo = vaccinationRecordNo;
		this.vaccinationHours = vaccinationHours;
		this.vaccinationContent = vaccinationContent;
		this.petWeight = petWeight;
		this.petOwnerVO = petOwnerVO;
		this.vetVO = vetVO;
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
	public String getPetWeight() {
		return petWeight;
	}
	public void setPetWeight(String petWeight) {
		this.petWeight = petWeight;
	}
	public PetOwnerVO getPetOwnerVO() {
		return petOwnerVO;
	}
	public void setPetOwnerVO(PetOwnerVO petOwnerVO) {
		this.petOwnerVO = petOwnerVO;
	}
	public VetVO getVetVO() {
		return vetVO;
	}
	public void setVetVO(VetVO vetVO) {
		this.vetVO = vetVO;
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
				+ ", petOwnerVO=" + petOwnerVO + ", vetVO=" + vetVO
				+ ", vaccinationVO=" + vaccinationVO + "]";
	}
	
	
}