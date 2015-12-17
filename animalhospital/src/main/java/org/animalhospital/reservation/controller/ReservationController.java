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

	@RequestMapping("findPossableReservationTime.do")
	@ResponseBody
	public List<ReservationTimeVO> findPossableReservationTime(HttpServletRequest request,
			VetLicenseVO vetLicenseVO,ReservationVO reservationVO){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("reservation_date", reservationVO.getReservationDate());
		map.put("vet_license_no", vetLicenseVO.getVetLicenseNo());
		return reservationService.findPossableReservationTime(map);
	}
	@RequestMapping("registerPetOwnerReservation.do")
	public String registerPetOwnerReservation(ReservationVO reservationVO){
		reservationService.registerPetOwnerReservation(reservationVO);
		return "redirect:PetOwnerReservationResult.do";
	}
	@RequestMapping("PetOwnerReservationResult.do")
	public String PetOwnerReservationResult(){
		return "redirect:home.do";
	}
	
}
