package com.std.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/ab")
public class MyController {
	String pa = "admin/ab/"+"test";
	String json = "test";
	@RequestMapping(value="/test")
	public String test(ModelMap model,HttpServletRequest request) {
		pa = request.getServletPath()+json;
		System.out.println(pa);
		System.out.println("请求的servlet 路径值为  "+request.getServletPath()+json); 
		System.out.println("请求的servlet url为  "+request.getRequestURL()); 
		model.addAttribute("nam", "namvalue1test");
		return pa;
	}
	
	@RequestMapping(value="hh")
	public String hh() {
		return "hh";
	}
	
	@RequestMapping()
	public void test() {
//		JSONObject
	}
	
}
