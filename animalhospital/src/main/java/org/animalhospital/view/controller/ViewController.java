package org.animalhospital.view.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.service.PetOwnerService;
import org.animalhospital.treatment.service.TreatmentService;
import org.animalhospital.vaccination.service.VaccinationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	@Resource
	private PetOwnerService petOwnerService;
	@Resource
	private TreatmentService treatmentService;
	@Resource
	private VaccinationService vaccinationService;
	
	/**
	 * 보호자 진료조회 페이지
	 * @author 민호
	 * @return
	 */
	@RequestMapping("findTreatmentRecordPagePetOwnerView.do")
	public ModelAndView viewFindPetOwnerTreatmentRecord(HttpServletRequest request){
		PetOwnerVO vo = (PetOwnerVO) request.getSession(false).getAttribute("loginVO");
		return new ModelAndView("find_petOwner_treatmentRecord", "findPetResult",
				petOwnerService.findPetListByTel(vo));
	}
	
	/**
	 * 수의사 진료조회 페이지
	 * @return
	 * @author 윤아
	 */
	@RequestMapping("findTreatmentRecordPageVetView.do")
	public String viewTreatmentRecordVetVerPage() {
		return "find_vet_treatmentRecord";
	}
	
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
	 * 동물 등록 페이지
	 * @return 신후
	 */
	@RequestMapping("registerPetView.do")
	public String registerPet(){
		return "pet_register";
	}
	/**
	 * 동물 리스트 페이지
	 * @return 신후
	 */
	@RequestMapping("listPetView.do")
	public String listPet(){
		return "pet_list";
	}
	/**
	 * 동물 정보수정 페이지
	 * @return 신후
	 */
	@RequestMapping("updatePetView.do")
	public String updatePet(){
		return "pet_update";
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
	public String treatmentRecordRegisterView(HttpServletRequest request) {
		request.setAttribute("DiseaseList",treatmentService.allDiseaseList());
		return "register_treatmentRecord";
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
	 * 보호자 회원정보수정 페이지
	 * @return
	 */
	@RequestMapping("updatePetOwnerView.do")
	public String updatePetOwner(){
		return "petowner_update";
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
	


	/**
	 * 예방접종등록 페이지를 호출하는 컨트롤러
	 * 반려동물 정보를 세션에 담긴 정보를 기반으로 호출한다
	 * 또한 예방접종목록 정보를 호출한다
	 * @return
	 */
	@RequestMapping("registerVaccinationView.do")
	public ModelAndView registerVaccinationView() {
		return new ModelAndView("register_petOwner_vaccination", 
				"VaccinationList", vaccinationService.findAllVaccination());
	}
	
	/**
	 * 	수의사 예방접종 등록 페이지
	 */
	@RequestMapping("viewVaccinationVetVerPage.do")
	public ModelAndView viewVaccinationVetVerPage(){
		return new ModelAndView("register_vet_vaccination", 
				"VaccinationList", vaccinationService.findAllVaccination());
	}
	
	/**
	 * 보호자 예방접종조회 페이지
	 * 
	 */
	@RequestMapping("findVaccinationRecordPagePetOwnerView.do")
	public String findVaccinationRecordPagePetOwnerView(){
		return "find_petOwner_vaccination";
	}
	/**
	 * 수의사 예방접종조회 페이지
	 * 
	 */
	@RequestMapping("findVaccinationRecordPageVetView.do")
	public String findVaccinationRecordPageVetView(){
		return "find_vet_vaccination";
	}
	
	/**
	 * 수의사 스케줄예약 페이지
	 */
	@RequestMapping("registerVetReservationView.do")
	public String registerScheduleView() {
		return "register_vet_reservation";
	}

	/**
	 * 보호자 진료예약 페이지
	 */
	@RequestMapping("registerPetOwnerReservationView.do")
	public String registerReservationView(HttpServletRequest request,PetOwnerVO povo) {
		povo = (PetOwnerVO) request.getSession(false).getAttribute("loginVO");
		request.setAttribute("petList", petOwnerService.findPetListById(povo));
		return "register_petOwner_reservation";
	}
	
	/**
	 * 문의 게시판 목록 페이지
	 * 
	 */
	@RequestMapping("listCommunityBoardQAView.do")
	public String listCommunityBoardQAView(){
		return "list_community";
	}
	/**
	 * 문의 게시판 글쓰기 페이지
	 * 
	 */
	@RequestMapping("writeCommunityView.do")
	public String writeCommunityView(){
		return "write_community";
	}
}
