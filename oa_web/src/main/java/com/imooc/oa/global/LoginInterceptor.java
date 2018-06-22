package com.imooc.oa.global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object handler) throws Exception {

		// 登录相关页面不拦截
		String url = httpServletRequest.getRequestURI();
		if (url.toLowerCase().indexOf("login") >= 0) {
			return true;
		}

		HttpSession session = httpServletRequest.getSession();
		if (session.getAttribute("employee") != null) {
			return true;
		}

		httpServletResponse.sendRedirect("/to_login");
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
