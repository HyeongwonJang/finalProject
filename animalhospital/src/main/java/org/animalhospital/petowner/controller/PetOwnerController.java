package org.animalhospital.petowner.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.animalhospital.petowner.model.VO.PetOwnerVO;
import org.animalhospital.petowner.service.PetOwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetOwnerController {
	@Resource
	private PetOwnerService petOwnerService;
	
	/**
	 * 보호자 로그인
	 * userLevel로 수의사와 보호자를 구분한다
	 * 수의사 userLevel = "vet"
	 * @param request
	 * @param povo
	 * @return
	 */
	@RequestMapping(value = "loginPetOwner.do", method = RequestMethod.POST)
	public String loginPetOwner(HttpServletRequest request, PetOwnerVO povo){
		PetOwnerVO petOwnerVO = petOwnerService.loginPetOwner(povo);
		if (petOwnerVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", petOwnerVO);
			session.setAttribute("userLevel", "petOwner");
			return "redirect:home.do";
		} else {
			return "account/login_fail";
		}
	}
	
	/**
	 * 로그아웃
	 * petOwner, vet 공통사항
	 * @param request
	 * @return
	 */
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		return "index";
	}
	
	/**
	 * 신규 보호자 회원가입
	 * @param povo
	 * @return
	 */
	@RequestMapping(value = "registerPetOwner.do", method = RequestMethod.POST)
	public String registerPetOwner(PetOwnerVO povo) {
		try {
			petOwnerService.registerPetOwner(povo);
		} catch (Exception e) {
			return "redirect:home.do";
		}		
		return "redirect:registerPetOwnerResult.do";
	}											
	@RequestMapping("registerPetOwnerResult.do")
	public String registerPetOwnerResult(){
		return "account/register_petowner_result";
	}
	
	/**
	 * PET_OWNER table에 전화번호가 등록되어 있는 보호자 회원가입
	 * @param povo
	 * @return
	 */
	@RequestMapping(value = "registerPetOwnerByTel.do", method = RequestMethod.POST)
	public String registerPetOwnerByTel(PetOwnerVO povo) {
		try {
			petOwnerService.registerPetOwnerByTel(povo);
		} catch (Exception e) {
			return "redirect:home.do";
		}		
		return "redirect:registerPetOwnerResult.do";
	}
	
	/**
	 * 펫 등록
	 * @param povo
	 * @return
	 */
	@RequestMapping(value = "registerPet.do")
	public String registerPet(PetOwnerVO povo){
		try {
			petOwnerService.registerPet(povo);
		} catch (Exception e) {
			return "redirect:home.do";
		}
		return "redirect:registerPetResult.do?" + povo.getPetOwnerNo();
	}
	@RequestMapping("registerPetResult.do")
	public String registerPetResult(){
		return "account/register_pet_result";
	}
	
	/**
	 * 보호자 회원 정보 수정
	 * @param request
	 * @param povo
	 * @return
	 */
	@RequestMapping("updatePetOwner.do")
	public String updatePetOwner(HttpServletRequest request,PetOwnerVO povo){
		petOwnerService.updatePetOwner(povo);
		request.getSession().setAttribute("loginVO", povo);
		return "home_petOwner";
	}
	
	/**
	 * 펫 정보 수정
	 * @param povo
	 * @return
	 */
	@RequestMapping("updatePet.do")
	public String updatePet(PetOwnerVO povo){
		petOwnerService.updatePet(povo);
		return "account/update_pet_result";
	}
	
	/**
	 * 보호자 회원가입시 전화번호 중복 체크
	 * 전화번호가 존재하고 id가 null이라면 ok_update(비가입, 진료내역이 있음)
	 * 전화번호가 존재하지 않는다면 ok(진료내역이 없는 신규)
	 * 전화번호와 id가 모두 존재한다면 fail(가입한 회원의 전화번호)
	 * @param povo
	 * @return
	 */
	@RequestMapping("checkPetOwnerTelAjax.do")
	@ResponseBody
	public String checkPetOwnerTelAjax(PetOwnerVO povo) {		
		return petOwnerService.checkPetOwnerTel(povo);
	}
	
	/**
	 * 보호자 회원가입시 petOwnerId 중복 체크
	 * 같은 아이디가 존재하지 않으면 ok
	 * 중복이면 fail
	 * @param povo
	 * @return
	 */
	@RequestMapping("findPetOwnerById.do")
	@ResponseBody
	public String findPetOwnerById(PetOwnerVO povo) {
		return petOwnerService.findPetOwnerById(povo);
	}
	
	@RequestMapping(value="findPetListById.do", method = RequestMethod.POST)
	@ResponseBody
	public PetOwnerVO findPetListById(HttpServletRequest request, PetOwnerVO povo){
		if(povo.getPetOwnerId() == null){
			povo = (PetOwnerVO) request.getSession(false).getAttribute("loginVO");
			return petOwnerService.findPetListById(povo);
		} else {
			return petOwnerService.findPetListById(povo);
		}
	}	
	
	/**
	 * 펫 정보 수정시 펫 리스트에서 선택된 petName과 session의 petOwnerNo를 이용하여
	 * 펫 정보를 반환
	 * @param povo
	 * @return
	 */
	@RequestMapping(value="findPetByPetName.do", method = RequestMethod.POST)
	public ModelAndView findPetByPetName(PetOwnerVO povo){
		return new ModelAndView("pet_update","povo",petOwnerService.findPetByPetName(povo));
	}
}
