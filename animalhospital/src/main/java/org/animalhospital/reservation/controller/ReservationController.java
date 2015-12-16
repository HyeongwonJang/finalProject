package org.animalhospital.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {
	@RequestMapping("findPetOwnerReservation.do")
	public String findPetOwnerReservation() {
		return "find_petOwner_reservation";
	}
	@RequestMapping("findVetReservation.do")
	public String findVetOwnerReservation() {
		return "find_vet_reservation";
	}
}
