package org.animalhospital.vaccination.model.VO;

import java.util.List;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;

public class VaccinationRecordVO {
	private int vaccinationRecordno;
	private String vaccinationHours;
	private String vaccinationContent;
	private TreatmentRecordVO treatmentRecordVO;
	private PetOwnerVO petownerVO;
	private VetLicenseVO vetlicenseVO;
	private VaccinationVO vaccinationVO;
	
	
	
	public VaccinationRecordVO() {
		super();
	}



	public VaccinationRecordVO(int vaccinationRecordno,
			String vaccinationHours, String vaccinationContent,
			TreatmentRecordVO treatmentRecordVO, PetOwnerVO petownerVO,
			VetLicenseVO vetlicenseVO, VaccinationVO vaccinationVO) {
		super();
		this.vaccinationRecordno = vaccinationRecordno;
		this.vaccinationHours = vaccinationHours;
		this.vaccinationContent = vaccinationContent;
		this.treatmentRecordVO = treatmentRecordVO;
		this.petownerVO = petownerVO;
		this.vetlicenseVO = vetlicenseVO;
		this.vaccinationVO = vaccinationVO;
	}



	public int getVaccinationRecordno() {
		return vaccinationRecordno;
	}



	public void setVaccinationRecordno(int vaccinationRecordno) {
		this.vaccinationRecordno = vaccinationRecordno;
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



	public TreatmentRecordVO getTreatmentRecordVO() {
		return treatmentRecordVO;
	}



	public void setTreatmentRecordVO(TreatmentRecordVO treatmentRecordVO) {
		this.treatmentRecordVO = treatmentRecordVO;
	}



	public PetOwnerVO getPetownerVO() {
		return petownerVO;
	}



	public void setPetownerVO(PetOwnerVO petownerVO) {
		this.petownerVO = petownerVO;
	}



	public VetLicenseVO getVetlicenseVO() {
		return vetlicenseVO;
	}



	public void setVetlicenseVO(VetLicenseVO vetlicenseVO) {
		this.vetlicenseVO = vetlicenseVO;
	}



	public VaccinationVO getVaccinationVO() {
		return vaccinationVO;
	}



	public void setVaccinationVO(VaccinationVO vaccinationVO) {
		this.vaccinationVO = vaccinationVO;
	}

	@Override
	public String toString() {
		return "VaccinationRecordVO [vaccinationRecordno="
				+ vaccinationRecordno + ", vaccinationHours="
				+ vaccinationHours + ", vaccinationContent="
				+ vaccinationContent + ", treatmentRecordVO="
				+ treatmentRecordVO + ", petownerVO=" + petownerVO
				+ ", vetlicenseVO=" + vetlicenseVO + ", vaccinationVO="
				+ vaccinationVO + "]";
	}


}
