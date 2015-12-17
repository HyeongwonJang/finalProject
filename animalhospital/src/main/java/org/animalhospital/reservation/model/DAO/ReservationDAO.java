package org.animalhospital.reservation.model.DAO;

import java.util.List;

import org.animalhospital.reservation.model.VO.ReservationVO;

public interface ReservationDAO {

	List<ReservationVO> findPetOwnerReservation(String petOwnerId);

	List<ReservationVO> findVetReservation(int hospitalId);

}