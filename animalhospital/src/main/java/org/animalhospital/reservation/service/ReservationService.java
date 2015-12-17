package org.animalhospital.reservation.service;

import java.util.List;

import org.animalhospital.reservation.model.VO.ReservationVO;

public interface ReservationService {

	List<ReservationVO> findPetOwnerReservation(String petOwnerId);

	List<ReservationVO> findVetReservation(int hospitalId);

}