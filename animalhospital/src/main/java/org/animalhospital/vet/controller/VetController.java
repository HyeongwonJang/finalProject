package org.animalhospital.vet.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.animalhospital.vet.model.VO.HospitalVO;
import org.animalhospital.vet.model.VO.VetLicenseVO;
import org.animalhospital.vet.model.VO.VetVO;
import org.animalhospital.vet.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class VetController {
	@Resource
	private VetService vetService;
	
	/**
	 * 수의사 로그인 
	 * session userLevel로 수의사와 보호자를 구분
	 * 수의사 userLevel = "vet"
	 */
	@RequestMapping("loginVet.do")
	public String vetLogin(HttpServletRequest request, VetVO vvo) {
		HospitalVO loginResult = vetService.loginVet(vvo);
		if (loginResult != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", loginResult);
			session.setAttribute("userLevel", "vet");
			return "redirect:home.do";
		} else {
			return "account/login_fail";
		}
	}
	
	/**
	 * logout
	 * org.animalhospital.petowner.controller.PetOwnerController의 logout method 공통사용
	 */
	
	/**
	 * 수의사 회원가입
	 */
	@RequestMapping("registerVet.do")
	public String registerVet(HospitalVO hvo, MultipartFile file) {
		vetService.registerVet(hvo);
		System.out.println(file.getOriginalFilename());
		return "redirect:home.do";
	}
	
	/**
	 * 수의사 정보 수정
	 * @param request
	 * @param hospitalVO
	 * @return
	 */
	@RequestMapping("updateVet.do")
	public String updateVet(HttpServletRequest request, HospitalVO hospitalVO) {
		vetService.updateVet(hospitalVO);
		request.getSession().setAttribute("loginVO", hospitalVO);
		return "home_vet";
	}
	
	/**
	 * 수의사 전화번호 중복체크
	 * 수의사 회원가입, 전화번호 수정 시
	 * VET table에 해당 번호를 이용하는 수의사가 있는지 체크
	 * @param vetVO
	 * @return
	 */
	@RequestMapping("checkVetByTel.do")
	@ResponseBody
	public int checkVetByTel(VetVO vetVO){
		return vetService.checkVetByTel( vetVO);
	}
	
	/**
	 * 라이센스 체크 
	 * 수의사 회원가입시 
	 * 입력한 이름과 번호에 해당하는 라이센스가 존재하는지,
	 * 이미 가입되어 있는 라이센스 정보는 아닌지 체크한다
	 * 사용 가능하면 ok
	 * 그렇지 않으면 fail return
	 */
	@RequestMapping("checkVetLicense.do")
	@ResponseBody
	public String checkVetLicense(VetLicenseVO lvo) {
		return vetService.checkVetLicense(lvo);
	}

	/**
	 * 병원 검색
	 */
	@RequestMapping("findHospital.do")
	@ResponseBody
	public List<HospitalVO> findHospital(HttpServletRequest request, HospitalVO hvo) {
		List<HospitalVO> hospitalList = vetService.findHospital(hvo);
		return hospitalList;
	}

	/**
	 * 수의사 아이디 중복 체크 수의사의 아이디가 존재하는지 존재하지 않는지 count(*) return 입력한 아이디가 이미 존재하면 1
	 * 존재하지 않으면 0
	 */
	@RequestMapping("findVetById.do")
	@ResponseBody
	public int findVetById(HttpServletResponse response, String vetId) {
		return vetService.findVetById(vetId);
	}

	@RequestMapping("findAllHospitalAjax.do")
	@ResponseBody
	public List<HospitalVO> findAllHospitalAjax() {
		List<HospitalVO> hospitalList = vetService.findAllHospital();
		return hospitalList;
	}


	
	@RequestMapping("findVetLicenseByHospitalId.do")
	@ResponseBody
	public List<VetLicenseVO> findVetLicenseByHospitalId(String hospitalId) {
		return vetService.findVetLicenseByHospitalId(hospitalId);
	}
}
