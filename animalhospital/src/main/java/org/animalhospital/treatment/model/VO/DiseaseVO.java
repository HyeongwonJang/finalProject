package org.animalhospital.treatment.model.VO;

public class DiseaseVO {
	private String diseaseName;
	private String diseaseSymptom;
	public DiseaseVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiseaseVO(String diseaseName, String diseaseSymptom) {
		super();
		this.diseaseName = diseaseName;
		this.diseaseSymptom = diseaseSymptom;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getDiseaseSymptom() {
		return diseaseSymptom;
	}
	public void setDiseaseSymptom(String diseaseSymptom) {
		this.diseaseSymptom = diseaseSymptom;
	}
	@Override
	public String toString() {
		return "DiseaseVO [diseaseName=" + diseaseName + ", diseaseSymptom="
				+ diseaseSymptom + "]";
	}
	
	
}
