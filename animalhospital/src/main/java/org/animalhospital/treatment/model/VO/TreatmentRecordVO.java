package org.animalhospital.treatment.model.VO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;

public class TreatmentRecordVO {
	private int treatmentRecordNo;
	private String treatmentHours;
	private String treatmentContent;
	private double petWeight;
	private PetVO petVO;
	private VetLicenseVO vetLicenseVO;
	private DiseaseVO diseaseVO;
	
	public TreatmentRecordVO() {
		super();
	}

	public TreatmentRecordVO(int treatmentRecordNo, String treatmentHours,
			String treatmentContent, double petWeight, PetVO petVO,
			VetLicenseVO vetLicenseVO, DiseaseVO diseaseVO) {
		super();
		this.treatmentRecordNo = treatmentRecordNo;
		this.treatmentHours = treatmentHours;
		this.treatmentContent = treatmentContent;
		this.petWeight = petWeight;
		this.petVO = petVO;
		this.vetLicenseVO = vetLicenseVO;
		this.diseaseVO = diseaseVO;
	}

	public int getTreatmentRecordNo() {
		return treatmentRecordNo;
	}

	public void setTreatmentRecordNo(int treatmentRecordNo) {
		this.treatmentRecordNo = treatmentRecordNo;
	}

	public String getTreatmentHours() {
		return treatmentHours;
	}

	public void setTreatmentHours(String treatmentHours) {
		this.treatmentHours = treatmentHours;
	}

	public String getTreatmentContent() {
		return treatmentContent;
	}

	public void setTreatmentContent(String treatmentContent) {
		this.treatmentContent = treatmentContent;
	}

	public double getPetWeight() {
		return petWeight;
	}

	public void setPetWeight(double petWeight) {
		this.petWeight = petWeight;
	}

	public PetVO getPetVO() {
		return petVO;
	}

	public void setPetVO(PetVO petVO) {
		this.petVO = petVO;
	}

	public VetLicenseVO getVetLicenseVO() {
		return vetLicenseVO;
	}

	public void setVetLicenseVO(VetLicenseVO vetLicenseVO) {
		this.vetLicenseVO = vetLicenseVO;
	}

	public DiseaseVO getDiseaseVO() {
		return diseaseVO;
	}

	public void setDiseaseVO(DiseaseVO diseaseVO) {
		this.diseaseVO = diseaseVO;
	}

	@Override
	public String toString() {
		return "TreatmentRecordVO [treatmentRecordNo=" + treatmentRecordNo
				+ ", treatmentHours=" + treatmentHours + ", treatmentContent="
				+ treatmentContent + ", petWeight=" + petWeight + ", petVO="
				+ petVO + ", vetLicenseVO=" + vetLicenseVO + ", diseaseVO="
				+ diseaseVO + "]";
	}
	
	
	
		
}
