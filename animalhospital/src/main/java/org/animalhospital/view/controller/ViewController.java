package org.animalhospital.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	/**
	 * 가장 첫 페이지를 출력하는 메서드 세션이 있으면 타일즈로 구성된 인덱스 페이지를 출력한다
	 * 세션이 없으면 로그인과 회원가입만 가능한
	 * 인덱스 페이지를 출력한다
	 * @return
	 */
	@RequestMapping("home.do")
	public String homeView(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loginVO") == null) {
			return "index";
		} else {
			System.out.println("타일즈 정상수행");
			return "home";
		}
	}

	/**
	 * 로그인 페이지
	 * @return
	 */
	@RequestMapping("loginView.do")
	public String loginView() {
		return "/account/login";
	}

	/**
	 * 수의사 회원가입 페이지
	 * @return
	 */
	@RequestMapping("registerVetView.do")
	public String registerVetView() {
		return "/account/register_vet";
	}
	
	/**
	 * 보호자 회원가입 페이지
	 * @return
	 */
	@RequestMapping("registerPetOwnerView.do")
	public String registerPetOwnerView() {
		return "/account/register_petowner";
	}

	/**
	 * 보호자 회원가입 완료 페이지
	 * 
	 * @return
	 */
	@RequestMapping("registerPetOwnerResultView.do")
	public String registerPetOwnerResultView() {
		return "/account/register_petowner_result";
	}

	/**
	 * 진료기록 페이지
	 * @return
	 */
	@RequestMapping("registerTreatmentRecordView.do")
	public String treatmentRecordRegisterView() {
		return "register_treatmentRecord";
	}

	/**
	 * 진료조회 페이지
	 * @return
	 */
	@RequestMapping("testTreatmentView.do")
	public String treatmentRecordTest() {
		return "test_treatmentRecord";
	}

	/**
	 * 수의사 회원정보수정 페이지
	 * @return
	 */
	@RequestMapping("vetUpdateView.do")
	public String vetUpdateView() {
		return "vet_update";
	}
	/**
	 * 병원 조회 페이지
	 */
	@RequestMapping("findHospitalView.do")
	public String findHospitalView() {
		return "find_hospital";
	}
	/**
	 * 보호자 예방접종 등록 페이지
	 */
	@RequestMapping("registerVaccinationRecordView.do")
	public String registerVaccinationRecordView() {
		return "register_vaccinationRecord";
	}
}
