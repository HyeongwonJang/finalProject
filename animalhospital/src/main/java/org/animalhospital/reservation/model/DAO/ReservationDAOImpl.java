package org.animalhospital.reservation.model.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.animalhospital.reservation.model.VO.ReservationVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDAOImpl implements ReservationDAO {
	@Resource
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<ReservationVO> findPetOwnerReservation(String petOwnerId) {
		return sqlSessionTemplate.selectList("reservation.findPetOwnerReservation", petOwnerId);
	}
}
