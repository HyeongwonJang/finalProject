package org.animalhospital.reservation.model.DAO;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.reservation.model.VO.ReservationTimeVO;
import org.animalhospital.reservation.model.VO.ReservationVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDAOImpl implements ReservationDAO {
	@Resource
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<ReservationVO> findTodayPetOwnerReservation(String petOwnerId) {
		return sqlSessionTemplate.selectList("reservation.findTodayPetOwnerReservation", petOwnerId);
	}
	
	public List<ReservationVO> findTodayVetReservation(int hospitalId) {
		return sqlSessionTemplate.selectList("reservation.findTodayVetReservation", hospitalId);
	}
	
	@Override
	public List<ReservationVO> findPetOwnerReservation(String petOwnerId) {
		return sqlSessionTemplate.selectList("reservation.findPetOwnerReservation", petOwnerId);
	}

	@Override
	public List<ReservationVO> findVetReservation(int hospitalId) {
		return sqlSessionTemplate.selectList("reservation.findVetReservation", hospitalId);
	}
	
	/**
	 * 진료가능 시간을 출력해주는 메서드
	 * @author 두현
	 */
	@Override	
	public List<ReservationTimeVO> findPossableReservationTime(HashMap map){
		return sqlSessionTemplate.selectList("reservation.findPossableReservationTime",map);
	}
	/**
	 * petOwner가 진료를 예약할 수 있게 해주는 메서드 
	 * @author 두현
	 */
	@Override
	public int registerReservation(ReservationVO reservationVO){
		return sqlSessionTemplate.insert("reservation.registerReservation",reservationVO);
	}
}
