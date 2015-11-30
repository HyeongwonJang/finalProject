package org.animalhospital.vet.model.VO;

/**
 * 수의사 정보를 가지는 VO
 */
public class VetVO {
	/*
	 * VO는 그릇
	 * 회원등록 id, password, tel, 면허번호, 병원 아이디
	 * 회원탈퇴: id, password 기준으로 삭제
	 * 회원조회: 
	 */
	private String vetId;
	private String vetPassword;
	private String vetTel;
	private VetLicenseVO vetLicenseVO;
	public VetVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VetVO(String vetId, String vetPassword, String vetTel,
			VetLicenseVO vetLicenseVO) {
		super();
		this.vetId = vetId;
		this.vetPassword = vetPassword;
		this.vetTel = vetTel;
		this.vetLicenseVO = vetLicenseVO;
	}
	public String getVetId() {
		return vetId;
	}
	public void setVetId(String vetId) {
		this.vetId = vetId;
	}
	public String getVetPassword() {
		return vetPassword;
	}
	public void setVetPassword(String vetPassword) {
		this.vetPassword = vetPassword;
	}
	public String getVetTel() {
		return vetTel;
	}
	public void setVetTel(String vetTel) {
		this.vetTel = vetTel;
	}
	public VetLicenseVO getVetLicenseVO() {
		return vetLicenseVO;
	}
	public void setVetLicenseVO(VetLicenseVO vetLicenseVO) {
		this.vetLicenseVO = vetLicenseVO;
	}
	@Override
	public String toString() {
		return "VetVO [vetId=" + vetId + ", vetPassword=" + vetPassword
				+ ", vetTel=" + vetTel + ", vetLicenseVO=" + vetLicenseVO + "]";
	}
	
	
}
