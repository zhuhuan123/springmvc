package com.std.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.std.VO.UserVO;

public class LoginIntercptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		HttpSession session = request.getSession();
//		System.out.println("������������ķ��� prehandler    ");
//		if(session.getAttribute("username")==null) {
//			System.out.println("ִ����������"+request.getRequestURL());
//			request.setAttribute("error", "��δ��¼");
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
////			response.sendRedirect("error.jsp");
//			return  false;
//		}
//		UserVO userVO = (UserVO)session.getAttribute("username");
//		System.out.println("logi interceptor   ������    "+userVO);
//		if(userVO==null) {
//			request.setAttribute("error", "�û�δ��¼");
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
//			return false;
//		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����false  �����ִ����");
	}
	
}
