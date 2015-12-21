package org.animalhospital.reservation.model.DAO;

import java.util.HashMap;
import java.util.List;

import org.animalhospital.reservation.model.VO.ReservationTimeVO;
import org.animalhospital.reservation.model.VO.ReservationVO;

public interface ReservationDAO {
	
	public List<ReservationVO> findTodayPetOwnerReservation(String petOwnerId);
	
	public List<ReservationVO> findTodayVetReservation(int hospitalId);

	List<ReservationVO> findPetOwnerReservation(String petOwnerId);

	List<ReservationVO> findVetReservation(int hospitalId);
	
	List<ReservationTimeVO> findPossableReservationTime(HashMap map);
	
	int registerReservation(ReservationVO reservationVO);

}