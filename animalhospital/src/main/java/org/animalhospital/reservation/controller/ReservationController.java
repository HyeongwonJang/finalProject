package org.animalhospital.reservation.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.reservation.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {
	@Resource
	private ReservationService reservationService;
	
	@RequestMapping("findPetOwnerReservation.do")
	public ModelAndView findPetOwnerReservation(HttpServletRequest request) {
		PetOwnerVO povo = (PetOwnerVO)request.getSession().getAttribute("loginVO");
		return new ModelAndView("find_petOwner_reservation", "reservationList", reservationService.findPetOwnerReservation(povo.getPetOwnerId()));
//		return new ModelAndView("find_petOwner_reservation");
	}
	@RequestMapping("findVetReservation.do")
	public String findVetOwnerReservation() {
		return "find_vet_reservation";
	}
}
