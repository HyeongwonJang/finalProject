package org.animalhospital.vet.model.VO;

import java.util.ArrayList;
import java.util.List;

/**
 * HOSPITAL TABLE 정보를 저장할 VO
 */

public class HospitalVO {
	private int hospitalId;
	private String hospitalName;
	private String hospitalAddress;
	private String hospitalTel;
	private List<VetVO> vetList;
	public HospitalVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HospitalVO(int hospitalId, String hospitalName,
			String hospitalAddress, String hospitalTel, List<VetVO> vetList) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.hospitalAddress = hospitalAddress;
		this.hospitalTel = hospitalTel;
		this.vetList = vetList;
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	public String getHospitalTel() {
		return hospitalTel;
	}
	public void setHospitalTel(String hospitalTel) {
		this.hospitalTel = hospitalTel;
	}
	// 리스트가 추가될 가능성이 있으면 유틸성 메소드 추가
	public List<VetVO> getVetList() {
		return vetList;
	}
	public void setVetList(List<VetVO> vetList) {
		this.vetList = vetList;
	}
	
	/**
	 * List를 만들어주는 유틸성 메서드
	 * 사견: private 메서드로 돌려도 괜찮을듯
	 * @return
	 */
	public List<VetVO> toCreateArrayList(){
		return vetList = new ArrayList<VetVO>();
	}
	
	/**
	 * List에 수의사 정보를 추가해주는 메서드 
	 * 첫 등록일 때는 List 객체를 만들어주고 생성하고
	 * 아닐 때는 수의사 정보를 등록한다
	 * @param vo
	 */
	public void addListObject(VetVO vo){
		if(vetList == null){
			toCreateArrayList();
			vetList.add(vo);
		} else {
			vetList.add(vo);
		}
	}
	
	@Override
	public String toString() {
		return "HospitalVO [hospitalId=" + hospitalId + ", hospitalName="
				+ hospitalName + ", hospitalAddress=" + hospitalAddress
				+ ", hospitalTel=" + hospitalTel + ", vetList=" + vetList + "]";
	}
	
	
	
	
}
