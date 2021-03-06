package org.animalhospital.view.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.animalhospital.community.model.service.CommunityBoardService;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.service.PetOwnerService;
import org.animalhospital.treatment.service.TreatmentService;
import org.animalhospital.vaccination.service.VaccinationService;
import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.view.service.ViewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	@Resource
	private PetOwnerService petOwnerService;
	@Resource
	private TreatmentService treatmentService;
	@Resource
	private VaccinationService vaccinationService;
	@Resource
	private ViewService viewService;
	@Resource
	private CommunityBoardService communityBoardService;
	
	/**
	 * 세션에 있는 보호자 전화번호를 기준으로 알람데이터를 받아온다
	 * ajax로 처리하도록 구성
	 * 차후 테이블을 새로 생성하여 쿼리의 부담을 덜어주게 할 예정
	 * @param petOwnerTel
	 * @return
	 * @author 민호
	 */
/*	@RequestMapping("findAllAlarmDataByPetOwnerTel.do")
	@ResponseBody
	public List<Object> findAllAlarmDataByPetOwnerTel(String petOwnerTel){
		List<Object> list = null;
		list = viewService.findAlarmListByPetOwnerTel(petOwnerTel);
		return list;
	}*/
	@RequestMapping("findAllAlarmDataByPetOwnerTel.do")
	@ResponseBody
	public Map<String, Object> findAllAlarmDataByPetOwnerTel(HttpServletRequest request){
		Map<String, Object> list = null;
		if(request.getSession(false) != null && request.getSession(false).getAttribute("userLevel") != null){
			if(request.getSession(false).getAttribute("userLevel").equals("petOwner")){
				list = viewService.findAlarmListByPetOwnerTel(((PetOwnerVO)request.getSession(false).getAttribute("loginVO")));
			}
		} 
		return list;
	}
	@RequestMapping("findAllAlarmDataByVet.do")
	@ResponseBody
	public Map<String, Object> findAllAlarmDataByVet(HttpServletRequest request){
		Map<String, Object> list = null;
		if(request.getSession(false) != null && request.getSession(false).getAttribute("userLevel") != null){
			if(request.getSession(false).getAttribute("userLevel").equals("vet")){
				list = viewService.findAlarmListByVet(((HospitalVO)request.getSession(false).getAttribute("loginVO")));
			}
		} 
		return list;
	}
	
	/**
	 * 가장 첫 페이지를 출력하는 메서드 세션이 있으면 타일즈로 구성된 인덱스 페이지를 출력한다
	 * 세션이 없으면 로그인과 회원가입만 가능한
	 * 인덱스 페이지를 출력한다
	 * 12.17일부터 마이페이지 추가함 근데 미친듯이 줄 수가 늘어나는 걸 보니
	 * 나눠야 하나
	 * 나눈다, 서비스 계층에서 map을 보내 합치는 걸로 합시다
	 * 
	 * @return
	 */
	@RequestMapping("home.do")
	public ModelAndView homeView(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		String url = "";
		if (session == null || session.getAttribute("loginVO") == null) {
			url = "index"; 
		} else if(session.getAttribute("userLevel").equals("vet")){
			url = "home_vet";
			HospitalVO hvo = (HospitalVO) request.getSession().getAttribute("loginVO");
			mav.addAllObjects(viewService.findVetMainPageData(hvo));
		} else if(session.getAttribute("userLevel").equals("petOwner")){
			PetOwnerVO povo = (PetOwnerVO) request.getSession(false).getAttribute("loginVO");
			url = "home_petOwner";
			mav.addAllObjects(viewService.findPetOwnerMainPageData(povo));
		}
		mav.setViewName(url);
		return mav;
	}
	
	
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
	@RequestMapping("authority_findHospitalView.do")
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
		request.setAttribute("petList", petOwnerService.findPetListByPetOwnerTel(povo));
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
	/**
	 * 1:1 문의 게시판 글 수정 폼(update_community.jsp)으로 넘어가는 메소드
	 * questionBoardNo를 참조하여 해당 글의 정보를 넘긴다.
	 * @param int
	 * @author 강신후 , 곽진혁
	 */
   @RequestMapping("updateCommunityView.do")
	public ModelAndView updateCommunityView(int questionBoardNo){
		return new ModelAndView("update_community","qbvo",communityBoardService.showCommunityBoardContentNoHit(questionBoardNo));
	}
	/**
	 * 답변 폼을 보여 준다
	 * client가 showContent_community.jsp에서 글을 보고 답글버튼을 클릭하면 답글할 폼을 보여준다. 
	 * 1. Client로 부터 답변할 글 번호(questionBoardNo)를 받는다. 
	 * 2. BoardService의 showContentNoHit(questionBoardNo) 를 호출하여 
	 *     답변 원본 글의 데이터를 가진 QuestionBoardVO 객체를 받아온다. 
	 * 3. QuestionBoardVO객체(qbvo)를 request scope에 넣고 reply_community.jsp로 수행을 넘긴다.
	 */
	@RequestMapping("replyCommunityView.do")
	public ModelAndView replyCommunityView(int questionBoardNo) {		
		System.out.println(questionBoardNo);
		return new ModelAndView("reply_community","qbvo",
				communityBoardService.showCommunityBoardContentNoHit(questionBoardNo));
	}
}
