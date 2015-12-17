package org.animalhospital.reservation.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.reservation.model.DAO.ReservationDAO;
import org.animalhospital.reservation.model.VO.ReservationTimeVO;
import org.animalhospital.reservation.model.VO.ReservationVO;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Resource
	private ReservationDAO reservationDAO;
	
	@Override
	public List<ReservationVO> findPetOwnerReservation(String petOwnerId) {
		return reservationDAO.findPetOwnerReservation(petOwnerId);
	}

	@Override
	public List<ReservationVO> findVetReservation(int hospitalId) {
		return reservationDAO.findVetReservation(hospitalId);
	}
	
	@Override
	public List<ReservationTimeVO> findPossableReservationTime(HashMap map){
		return reservationDAO.findPossableReservationTime(map);
	}
	
	@Override
	public int registerPetOwnerReservation(ReservationVO reservationVO){
		return reservationDAO.registerPetOwnerReservation(reservationVO);
	}
	
}
