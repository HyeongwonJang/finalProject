package org.animalhospital.reservation.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.reservation.model.VO.ReservationTimeVO;
import org.animalhospital.reservation.model.VO.ReservationVO;
import org.animalhospital.reservation.service.ReservationService;
import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.animalhospital.vet.model.VO.VetVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {
	@Resource
	private ReservationService reservationService;
	
	@RequestMapping("findPetOwnerReservation.do")
	public ModelAndView findPetOwnerReservation(HttpServletRequest request) {
		PetOwnerVO povo = (PetOwnerVO)request.getSession().getAttribute("loginVO");
		return new ModelAndView("find_petOwner_reservation", "reservationList", reservationService.findPetOwnerReservation(povo.getPetOwnerId()));
	}
	
	@RequestMapping("findVetReservation.do")
	public ModelAndView findVetOwnerReservation(HttpServletRequest request) {
		HospitalVO hvo = (HospitalVO)request.getSession().getAttribute("loginVO");
		return new ModelAndView("find2_vet_reservation", "reservationList", reservationService.findVetReservation(hvo.getHospitalId()));
	}
	/**
	 * 예약 가능 시간을 출력해주는 컨트롤러
	 * 뷰 계층에서 vet_license_no와 reservation_date 값을 받아
	 * findPossableReservationTime서비스에 map형식으로 값을 입력해주면 
	 * 해당 날짜, 해당 의사에게 예약가능한 시간을 출력해 준다. 
	 * @param request
	 * @param vetLicenseVO
	 * @param reservationVO
	 * @author 두현
	 * @return
	 */
	@RequestMapping("findPossableReservationTime.do")
	@ResponseBody
	public List<ReservationTimeVO> findPossableReservationTime(HttpServletRequest request,
			VetLicenseVO vetLicenseVO,ReservationVO reservationVO){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("reservation_date", reservationVO.getReservationDate());
		map.put("vet_license_no", vetLicenseVO.getVetLicenseNo());
		return reservationService.findPossableReservationTime(map);
	}
	/**
	 * PetOwner와 vet양측의 진료예약을 등록하는 컨트롤러
	 * ReservationVO타입으로 값들을 값들을 입력받아 
	 * registerPetOwnerReservation서비스를 실행하도록 한다.
	 * 중복 입력을 방지하기 위하여 redirect방식으로 데이터를 전송한다.
	 * @param reservationVO
	 * @author 두현
	 * @return
	 */
	@RequestMapping("registerReservation.do")
	public String registerReservation(ReservationVO reservationVO){
		reservationService.registerReservation(reservationVO);
		return "redirect:ReservationResult.do";
	}
	/**
	 * register_*_Reservation에서
	 * 중복된 자료입력이 되는 상황을 방지하기 위하여 
	 * 생성된 컨트롤러 
	 * 등록 완료후 home.do를 실행 한다. 
	 * @author 두현
	 * @return
	 */
	@RequestMapping("ReservationResult.do")
	public String ReservationResult(){
		return "redirect:home.do";
	}
	
}
