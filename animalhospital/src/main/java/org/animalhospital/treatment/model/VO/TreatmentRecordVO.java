package org.animalhospital.treatment.model.VO;
import org.animalhospital.petowner.model.VO.PetVO;
import org.animalhospital.vet.model.VO.HospitalVO;

public class TreatmentRecordVO {
	private int treatmentRecordNo;
	private String treatmentHours;
	private String treatmentContent;
	private double petWeight;
	private PetVO petVO;
	private HospitalVO hospitalVO;
	private DiseaseVO diseaseVO;
	
	public TreatmentRecordVO() {
		super();
	}

	public TreatmentRecordVO(int treatmentRecordNo, String treatmentHours,
			String treatmentContent, double petWeight, PetVO petVO,
			HospitalVO hospitalVO, DiseaseVO diseaseVO) {
		super();
		this.treatmentRecordNo = treatmentRecordNo;
		this.treatmentHours = treatmentHours;
		this.treatmentContent = treatmentContent;
		this.petWeight = petWeight;
		this.petVO = petVO;
		this.hospitalVO = hospitalVO;
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

	public HospitalVO getHospitalVO() {
		return hospitalVO;
	}

	public void setHospitalVO(HospitalVO hospitalVO) {
		this.hospitalVO = hospitalVO;
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
				+ petVO + ", hospitalVO=" + hospitalVO + ", diseaseVO="
				+ diseaseVO + "]";
	}

	
	
	
	
		
}
