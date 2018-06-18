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
//		System.out.println("拦截器的里面的方法 prehandler    ");
//		if(session.getAttribute("username")==null) {
//			System.out.println("执行这里了吗"+request.getRequestURL());
//			request.setAttribute("error", "你未登录");
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
////			response.sendRedirect("error.jsp");
//			return  false;
//		}
//		UserVO userVO = (UserVO)session.getAttribute("username");
//		System.out.println("logi interceptor   拦截期    "+userVO);
//		if(userVO==null) {
//			request.setAttribute("error", "用户未登录");
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
		System.out.println("返回false  这里会执行吗");
	}
	
}
