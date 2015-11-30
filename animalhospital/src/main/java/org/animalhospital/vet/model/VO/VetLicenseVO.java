package org.animalhospital.vet.model.VO;

/**
 * 수의사 면허정보를 가지고 있는 VO
 */
public class VetLicenseVO {
	private int vetLicenseNo;
	private String vetName;
	private int residentNo;
	private String getLicenseDate;
	public VetLicenseVO() {
		super();
	}
	public VetLicenseVO(int vetLicenseNo, String vetName, int residentNo,
			String getLicenseDate) {
		super();
		this.vetLicenseNo = vetLicenseNo;
		this.vetName = vetName;
		this.residentNo = residentNo;
		this.getLicenseDate = getLicenseDate;
	}
	public int getVetLicenseNo() {
		return vetLicenseNo;
	}
	public void setVetLicenseNo(int vetLicenseNo) {
		this.vetLicenseNo = vetLicenseNo;
	}
	public String getVetName() {
		return vetName;
	}
	public void setVetName(String vetName) {
		this.vetName = vetName;
	}
	public int getResidentNo() {
		return residentNo;
	}
	public void setResidentNo(int residentNo) {
		this.residentNo = residentNo;
	}
	public String getGetLicenseDate() {
		return getLicenseDate;
	}
	public void setGetLicenseDate(String getLicenseDate) {
		this.getLicenseDate = getLicenseDate;
	}
	@Override
	public String toString() {
		return "VetLicenseVO [vetLicenseNo=" + vetLicenseNo + ", vetName="
				+ vetName + ", residentNo=" + residentNo + ", getLicenseDate="
				+ getLicenseDate + "]";
	}
	
}
