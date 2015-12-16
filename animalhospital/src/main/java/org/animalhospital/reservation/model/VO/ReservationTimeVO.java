package org.animalhospital.reservation.model.VO;

public class ReservationTimeVO {
	private int timeNo;
	private String reservationTime;
	public ReservationTimeVO() {
		super();
	}
	public ReservationTimeVO(int timeNo, String reservationTime) {
		super();
		this.timeNo = timeNo;
		this.reservationTime = reservationTime;
	}
	public int getTimeNo() {
		return timeNo;
	}
	public void setTimeNo(int timeNo) {
		this.timeNo = timeNo;
	}
	public String getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}
	@Override
	public String toString() {
		return "ReservationTimeVO [timeNo=" + timeNo + ", reservationTime=" + reservationTime + "]";
	}
}
