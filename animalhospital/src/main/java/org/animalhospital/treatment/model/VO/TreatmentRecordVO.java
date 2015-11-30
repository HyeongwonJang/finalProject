package org.animalhospital.treatment.model.VO;
import org.animalhospital.petowner.model.VO.MemberPetOwnerVO;
import org.animalhospital.vet.model.VO.HospitalVO;

public class TreatmentRecordVO {
	private String treatmentRecordNo;
	private String treatmentHours;
	private String treatmentContent;
	private double petWeight;
	private MemberPetOwnerVO memberPetOwnerVO;
	private HospitalVO hospitalVO;
	private DiseaseVO diseaseVO;
	
	public TreatmentRecordVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TreatmentRecordVO(String treatmentRecordNo, String treatmentHours,
			String treatmentContent, double petWeight,
			MemberPetOwnerVO memberPetOwnerVO, HospitalVO hospitalVO,
			DiseaseVO diseaseVO) {
		super();
		this.treatmentRecordNo = treatmentRecordNo;
		this.treatmentHours = treatmentHours;
		this.treatmentContent = treatmentContent;
		this.petWeight = petWeight;
		this.memberPetOwnerVO = memberPetOwnerVO;
		this.hospitalVO = hospitalVO;
		this.diseaseVO = diseaseVO;
	}
	public String getTreatmentRecordNo() {
		return treatmentRecordNo;
	}
	public void setTreatmentRecordNo(String treatmentRecordNo) {
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
	public MemberPetOwnerVO getMemberPetOwnerVO() {
		return memberPetOwnerVO;
	}
	public void setMemberPetOwnerVO(MemberPetOwnerVO memberPetOwnerVO) {
		this.memberPetOwnerVO = memberPetOwnerVO;
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
				+ treatmentContent + ", petWeight=" + petWeight
				+ ", memberPetOwnerVO=" + memberPetOwnerVO + ", hospitalVO="
				+ hospitalVO + ", diseaseVO=" + diseaseVO + "]";
	}
	
	
		
}
