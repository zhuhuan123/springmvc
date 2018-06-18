package com.std.controller;

//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.std.VO.UserVO;
import com.std.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:spring.xml","classpath:spring-mybatis.xml","classpath:ehcache-shiro.xml","classpath:spring-shiro.xml","classpath:springmvc-servlet.xml"})
public class TesMo {
	 private MockMvc mockmvc;
	    @Autowired
	    private WebApplicationContext context;
	    @Before
	    public void setUp() throws Exception {
//	        mvc = MockMvcBuilders.standaloneSetup(new DepartmentsContoller(),new RoleController()).build();
//	    	this.context =
//	    mvc = MockMvcBuilders.webAppContextSetup(context);
	    	mockmvc = webAppContextSetup(context).build();
	    
//	    	webAppContextSetup(context).
	    }
	    
	    @Autowired
	private MockHttpServletRequest request;
	    
	    @Test
	    public void t() {
	    	System.out.println(mockmvc);
	    }
	    
	    @Autowired
	    private UserService userService;
	    
	    @Test
	    public void tes() throws Exception{
	    	System.out.println(mockmvc);
//	    	UserVO userVO = userService.findUserVOByLoginName("admin");
//	    	request.getSession().setAttribute("username", userVO);
//	    	mockmvc.perform(post("/login").param("loginName", "admin").param("password", "admin"));
	    	mockmvc.perform(get("/selectDepartmentsByPrimaryKey").param("id", "1")).andDo(MockMvcResultHandlers.print());
	    	
	    }
	    @Test
	    public void tesgetRoles() throws Exception{
	    	System.out.println(mockmvc);
	    	mockmvc.perform(get("/getRoles").param("page", "1").param("pagesize", "10")).andDo(MockMvcResultHandlers.print());
	    }
}
