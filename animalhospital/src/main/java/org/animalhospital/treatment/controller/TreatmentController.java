package org.animalhospital.treatment.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.animalhospital.paging.model.VO.ListVO;
import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.service.PetOwnerService;
import org.animalhospital.treatment.model.VO.TreatmentRecordVO;
import org.animalhospital.treatment.service.TreatmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TreatmentController {
	@Resource
	private TreatmentService treatmentService;
	@Resource
	private PetOwnerService petOwnerService;

	/**
	 * 진료기록번호로 상세진료목록을 가져오는 메서드
	 * ajax와 연동되는 메서드
	 * @param treatmentRecordNo
	 * @return
	 */
	@RequestMapping("findDetailTreatmentRecordByTreatmentNo.do")
	@ResponseBody
	public TreatmentRecordVO findDetailTreatmentRecordByTreatmentNo(int treatmentRecordNo){
		return treatmentService.findDetailTreatmentRecordByTreatmentNo(treatmentRecordNo);
	}
	
	/**
	 * 검색조건으로 진료기록목록을 가져오는 메서드
	 * 검색조건: 시작 날짜, 끝 날짜, 보호자 전화번호, 반려동물 이름, 페이지
	 * 매개변수를 Map에 담아 mybatis를 실행하고 
	 * ModelAndView에 url, 유지시킬 검색조건, 검색결과를 담아 View에 보낸다
	 * @param povo
	 * @param lvo
	 * @return
	 */
	@RequestMapping("findTreatmentRecordByPetOwnerTelAndPetName.do")
	public ModelAndView findTreatmentRecordByPetOwnerTelAndPetName(PetOwnerVO povo,
			ListVO lvo, HttpServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("povo", povo);
		paramMap.put("listVO", lvo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("recordList", treatmentService.findTreatmentRecordByByPetOwnerTelAndPetName(paramMap));
		mav.addObject("continueParam", paramMap);
		System.out.println("param : " + paramMap);
		if(request.getSession(false).getAttribute("userLevel").equals("vet")){
			mav.setViewName("find_vet_treatmentRecord");
		} else if(request.getSession(false).getAttribute("userLevel").equals("petOwner")){
			mav.setViewName("find_petOwner_treatmentRecord");
		}
		return mav;
	}
	
	
	/**
	 * 보호자 전화번호에 따른 반려동물 리스트 가져오기
	 * userLevel로 수의사와 보호자를 구분(수의사 : vet, 보호자 : petOwner)하여
	 * 보호자일 때는 session loginVO의 tel를 이용하고
	 * 수의사일 때는 find_vet_treatmentRecord.jsp,register_treatmentRecord.jsp에서 입력받은 tel값을 이용함
	 * @param request
	 * @param petOwnerVO
	 * @return
	 */
	/*@RequestMapping("findPetListByTel.do")
	@ResponseBody
	public PetOwnerVO findPetListByTel(HttpServletRequest request, PetOwnerVO petOwnerVO){
		if(petOwnerVO.getPetOwnerTel() == null){
			petOwnerVO = (PetOwnerVO) request.getSession(false).getAttribute("loginVO");
			return petOwnerService.findPetListByTel(petOwnerVO);
		} else {
			return petOwnerService.findPetListByTel(petOwnerVO);
		}
	}	*/
	/**
	 * 수의사가 회원의 진료를 기록할때 사용하는 메서드 
	 * register_treatmentRecord.jsp에서
	 *  TreatmentRecordVO의 파라미터 타입으로 자료값을 받으며,
	 *  registerTreatmentRecord서비스를 실행한 후 
	 *  중복 등록을 방지하기 위하여 redirect 방식으로
	 *  registerTreatmentRecord_result.do컨트롤러로 보내준다. 
	 * @param request
	 * @param treatmentRecordVO
	 * @author 두현
	 * @return
	 */
	@RequestMapping("registerTreatmentRecord.do")
	public String registerTreatmentRecord(HttpServletRequest request,
			TreatmentRecordVO treatmentRecordVO) {
		treatmentService.registerTreatmentRecord(treatmentRecordVO);
		return "redirect:registerTreatmentRecord_result.do";
	}
	/**
	 * 뒤로가기(백스페이스)를 통하여 자료가 중복 입력되는 상황을
	 * 방지하기 위하여 사용되는 메서드
	 * @param request
	 * @param treatmentRecordVO
	 * @author 두현
	 * @return
	 */
	@RequestMapping("registerTreatmentRecord_result.do")
	public String registerTreatmentRecordResult(HttpServletRequest request,
			TreatmentRecordVO treatmentRecordVO) {
		return "treatmentRecord/register_treatmentRecord_result";
	}
	/**
	 * 병원에 처음 방문한 사람들의 진료기록을 기록하기 위한 컨트롤러
	 * 넘겨 받은 treatmentRecordVO 에서 getPetOwnerVO를 이용하여
	 * 방문자의 정보(name, Tel)를 넘겨 받은 후 
	 * registerNonMember서비스를 이용하여 회원 테이블에 입력한다.
	 * 그 후 select key를 이용하여  petOwnerNo를 부여 받은 PetOwnerVO를 반환 받는다.
	 * 반환 받은 정보를 통하여 비회원의 펫의 정보(petOwnerNo,petName)를 펫테이블에 입력한다.
	 * 기존의 진료기록 정보와 위의 과정으로 생성된 정보를 통하여 
	 * registerTreatmentRecord서비스를 통하여 진료를 기록한다.
	 * 마찬가지로 중복 입력을 방지하기 위하여 redirect 방식으로 
	 * registerTreatmentRecord_result.do컨트롤러로 보내준다.
	 * @param request
	 * @param treatmentRecordVO
	 * @author 두현
	 * @return
	 */
	@RequestMapping("registerNonMemberTreatmentRecord.do")
	public String registerNonMemberTreatmentRecord(HttpServletRequest request,
			TreatmentRecordVO treatmentRecordVO) {
		treatmentService.registerNonMember(treatmentRecordVO.getPetOwnerVO());
		treatmentService.registerNonMemberPet(treatmentRecordVO.getPetOwnerVO());
		treatmentService.registerTreatmentRecord(treatmentRecordVO);
		return "redirect:registerTreatmentRecord_result.do";
	}
	
	
	

}
