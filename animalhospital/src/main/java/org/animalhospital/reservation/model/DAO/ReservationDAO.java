package org.animalhospital.reservation.model.DAO;

import java.util.HashMap;
import java.util.List;

import org.animalhospital.reservation.model.VO.ReservationTimeVO;
import org.animalhospital.reservation.model.VO.ReservationVO;

public interface ReservationDAO {

	List<ReservationVO> findPetOwnerReservation(String petOwnerId);

	List<ReservationVO> findVetReservation(int hospitalId);
	
	List<ReservationTimeVO> findPossableReservationTime(HashMap map);
	
	int registerPetOwnerReservation(ReservationVO reservationVO);

}