package org.animalhospital.reservation.model.VO;

public class ReservationTimeVO {
	private int TimeNo;
	private String ReservationTime;
	
	public ReservationTimeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservationTimeVO(int timeNo, String reservationTime) {
		super();
		TimeNo = timeNo;
		ReservationTime = reservationTime;
	}
	public int getTimeNo() {
		return TimeNo;
	}
	public void setTimeNo(int timeNo) {
		TimeNo = timeNo;
	}
	public String getReservationTime() {
		return ReservationTime;
	}
	public void setReservationTime(String reservationTime) {
		ReservationTime = reservationTime;
	}
	@Override
	public String toString() {
		return "ReservationTime [TimeNo=" + TimeNo + ", ReservationTime="
				+ ReservationTime + "]";
	}
	
}
