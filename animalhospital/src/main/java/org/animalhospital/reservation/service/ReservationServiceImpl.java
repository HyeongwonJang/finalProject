package org.animalhospital.reservation.service;

import java.text.ParseException;
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
	
	public List<ReservationVO> findPetOwnerReservationToTodayReservation(String petOwnerId){
		List<ReservationVO> originList = reservationDAO.findPetOwnerReservation(petOwnerId);
		List<ReservationVO> alarmList = new ArrayList<ReservationVO>();
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter = (SimpleDateFormat) SimpleDateFormat.getInstance();
		formatter.applyPattern("yyyy-MM-dd");
		String tempToday = formatter.format(new Date());
		Date today = null;
		try {
			today = formatter.parse(tempToday);
			for(int li = 0; li<originList.size(); li++){
				if((today.getTime() - 
						formatter.parse(originList.get(li).getReservationDate()).getTime()) == 0){
					alarmList.add(originList.get(li));
				}
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		return alarmList;
		
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
