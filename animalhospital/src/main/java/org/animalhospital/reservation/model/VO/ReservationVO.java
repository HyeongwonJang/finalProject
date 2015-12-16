package org.animalhospital.reservation.model.VO;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetVO;

public class ReservationVO {
	private int reservationNo;									//seq 를 이용하여 no지정
	private String reservationDate;							//예약 날짜 년월일 
	private ReservationTimeVO reservationTimeVO; // 예약 시간
	private HospitalVO hospitalVO;
	private PetOwnerVO petOwnerVO;						//petOwnerNo,와 PetName 입력
	private String reservationContent;						//상세내역 입력
	public ReservationVO() {
		super();
	}
	public ReservationVO(int reservationNo, String reservationDate, ReservationTimeVO reservationTimeVO,
			HospitalVO hospitalVO, PetOwnerVO petOwnerVO, String reservationContent) {
		this.reservationNo = reservationNo;
		this.reservationDate = reservationDate;
		this.reservationTimeVO = reservationTimeVO;
		this.hospitalVO = hospitalVO;
		this.petOwnerVO = petOwnerVO;
		this.reservationContent = reservationContent;
	}
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public ReservationTimeVO getReservationTimeVO() {
		return reservationTimeVO;
	}
	public void setReservationTimeVO(ReservationTimeVO reservationTimeVO) {
		this.reservationTimeVO = reservationTimeVO;
	}
	public HospitalVO getHospitalVO() {
		return hospitalVO;
	}
	public void setHospitalVO(HospitalVO hospitalVO) {
		this.hospitalVO = hospitalVO;
	}
	public PetOwnerVO getPetOwnerVO() {
		return petOwnerVO;
	}
	public void setPetOwnerVO(PetOwnerVO petOwnerVO) {
		this.petOwnerVO = petOwnerVO;
	}
	public String getReservationContent() {
		return reservationContent;
	}
	public void setReservationContent(String reservationContent) {
		this.reservationContent = reservationContent;
	}
	@Override
	public String toString() {
		return "ReservationVO [reservationNo=" + reservationNo + ", reservationDate=" + reservationDate
				+ ", reservationTimeVO=" + reservationTimeVO + ", hospitalVO=" + hospitalVO + ", petOwnerVO="
				+ petOwnerVO + ", reservationContent=" + reservationContent + "]";
	}
	
}
