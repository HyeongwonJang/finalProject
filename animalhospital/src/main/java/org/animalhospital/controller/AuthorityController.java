package org.animalhospital.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorityController extends HandlerInterceptorAdapter{
	/*
	 * 컨트롤러 로직 수행 전 동작된다.
	 * 이 오버라이딩 메서드가 리턴값이 true이면
	 * 컨트롤러 메서드가 수행되고
	 * false이면 동작되지 않는다.
	 * 비인증 상태이면 index.jsp로 redirect시키고 false를 리턴해
	 * 컨틀롤러 메서드 수행시키지 않는다.
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("interceptor 실행~~~");
		HttpSession session = request.getSession(false);
		if(session==null || session.getAttribute("loginVO")==null) {
			response.sendRedirect("home.do");
			return false; // 컨트롤러 메서드 수행하지 않게 한다.
		}
		return true;
	}
}
