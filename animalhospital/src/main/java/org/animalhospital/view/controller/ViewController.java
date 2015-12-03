package org.animalhospital.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	/**
	 * 가장 첫 페이지를 출력하는 메서드
	 * 세션이 있으면 타일즈로 구성된 인덱스 페이지를 출력한다
	 * 세션이 없으면 로그인과 회원가입만 가능한 인덱스 페이지를 출력한다
	 * @return
	 */
	@RequestMapping("home.do")
	public String homeView(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loginVO")==null) {
			return "index";
		} else {
			System.out.println("타일즈 정상수행");
			return "home";
		}
	}
	
	/**
	 * 로그인 뷰 페이지를 나타나게 하는 컨트롤러
	 * @return
	 */
	@RequestMapping("login_view.do")
	public String loginView(){
		return "/account/login";
	}
	
	/**
	 * 수의사 등록페이지가 나오게 하는 컨트롤러
	 * @return
	 */
	@RequestMapping("registerVetView.do")
	public String registerVetView(){
		return "/account/register_vet";
	}
	
	/**
	 * 보호자 등록페이지가 나오게 하는 컨트롤러
	 * @return
	 */
	@RequestMapping("registerPetownerView.do")
	public String registerPetOwnerView(){
		return "/account/register_petowner";
	}
	
	/**
	 * 진료기록등록페이지
	 * @return
	 */
	@RequestMapping("treatment_record_register.do")
	public String treatmentRecordRegisterView(){
		return "treatment_record_register";
	}
	
	/**
	 * 진료조회페이지
	 * @return
	 */
	@RequestMapping("treatment_record_find.do")
	public String treatmentRecordFind(){
		return "treatment_record_find";
	}
	
	@RequestMapping("treatment_record_test.do")
	public String treatmentRecordTest(){
		return "treatment_record_test";
	}
	
	@RequestMapping("vet_update.do")
	public String vetUpdate(){
		return "vet_update";
	}
	
}
