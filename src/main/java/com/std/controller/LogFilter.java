package com.std.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *  filter  能实现过滤的功能 ，请求前过滤
 * Servlet Filter implementation class LogFilter
 */
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//这里编写代码  能够实现对请求的拦截。
		System.out.println("LogFilter 拦截之前  "+request.getRemoteAddr()+"  : "+request.getRemoteHost()+" : "+request.getRemotePort());
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("LogFilter 拦截之后  "+request.getRemoteAddr()+"  : "+request.getRemoteHost()+" : "+request.getRemotePort());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init初始化");
	}

}
