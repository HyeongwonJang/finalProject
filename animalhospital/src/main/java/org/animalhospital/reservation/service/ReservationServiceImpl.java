package org.animalhospital.reservation.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
	/**
	 * 해당의사,날짜에게 진료 가능한 시간을 출력해 주는 서비스 
	 * vet_license_no와 reservation_date 값을 map 형식으로 받아
	 * 해당의사의 진료 가능 시간을 출력해 주도록 한다.
	 * @author 두현
	 */
	@Override
	public List<ReservationTimeVO> findPossableReservationTime(HashMap map){
		return reservationDAO.findPossableReservationTime(map);
	}
	/**
	 * ReservationVO 타입으로 값을 입력받아
	 * PetOwner가 진료 예약을 할 수 있도록 도와주는 메서드
	 * @author 두현
	 */
	@Override
	public int registerReservation(ReservationVO reservationVO){
		return reservationDAO.registerReservation(reservationVO);
	}
	
}
