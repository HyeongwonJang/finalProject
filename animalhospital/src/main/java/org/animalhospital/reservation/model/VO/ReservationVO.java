package org.animalhospital.reservation.model.VO;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.vet.model.VO.VetVO;

public class ReservationVO {
	private int ReservationNo;									//seq 를 이용하여 no지정
	private String ReservationDate;							//예약 날짜 년월일 
	private ReservationTimeVO reservationTimeVO; // 예약 시간
	private VetVO vetVO;										//수의사의 정보 LicenseNo 입력
	private PetOwnerVO petOwnerVO;						//petOwnerNo,와 PetName 입력
	private String ReservationContent;						//상세내역 입력
	public ReservationVO(int reservationNo, String reservationDate,
			ReservationTimeVO reservationTimeVO, VetVO vetVO,
			PetOwnerVO petOwnerVO, String reservationContent) {
		super();
		ReservationNo = reservationNo;
		ReservationDate = reservationDate;
		this.reservationTimeVO = reservationTimeVO;
		this.vetVO = vetVO;
		this.petOwnerVO = petOwnerVO;
		ReservationContent = reservationContent;
	}
	public ReservationVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReservationNo() {
		return ReservationNo;
	}
	public void setReservationNo(int reservationNo) {
		ReservationNo = reservationNo;
	}
	public String getReservationDate() {
		return ReservationDate;
	}
	public void setReservationDate(String reservationDate) {
		ReservationDate = reservationDate;
	}
	public ReservationTimeVO getReservationTimeVO() {
		return reservationTimeVO;
	}
	public void setReservationTimeVO(ReservationTimeVO reservationTimeVO) {
		this.reservationTimeVO = reservationTimeVO;
	}
	public VetVO getVetVO() {
		return vetVO;
	}
	public void setVetVO(VetVO vetVO) {
		this.vetVO = vetVO;
	}
	public PetOwnerVO getPetOwnerVO() {
		return petOwnerVO;
	}
	public void setPetOwnerVO(PetOwnerVO petOwnerVO) {
		this.petOwnerVO = petOwnerVO;
	}
	public String getReservationContent() {
		return ReservationContent;
	}
	public void setReservationContent(String reservationContent) {
		ReservationContent = reservationContent;
	}
	@Override
	public String toString() {
		return "ReservationVO [ReservationNo=" + ReservationNo
				+ ", ReservationDate=" + ReservationDate
				+ ", reservationTimeVO=" + reservationTimeVO + ", vetVO="
				+ vetVO + ", petOwnerVO=" + petOwnerVO
				+ ", ReservationContent=" + ReservationContent + "]";
	}
	
	
}
