package com.std.controller;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.std.VO.UserVO;
import com.std.model.Departments;
import com.std.model.Resource;
import com.std.model.RoleResource;
import com.std.model.RoleResourceExample;
import com.std.model.Tree;
import com.std.model.RoleResourceExample.Criteria;
import com.std.service.DepartmentsService;
import com.std.service.ResourceService;
import com.std.service.RoleResourceService;
import com.std.service.UserService;

/**
 * @author Administrator
 *
 */
@Controller
public class LoginController {
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="login")
	public String login(String loginName,String password,boolean remember
			,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
		if(loginName==null || password==null) {
			modelMap.addAttribute("error", "用户名或密码为空");
			return "login";
		}
		Subject su = SecurityUtils.getSubject();
		UsernamePasswordToken user = new UsernamePasswordToken(loginName,password);
		try {
			su.login(user);
		}catch (Exception e) {
			e.printStackTrace();
			modelMap.addAttribute("error", e.getMessage());
			return "login";
		}
		if(su.isAuthenticated()) {
			System.out.println("通过spring  shiro   登录成功");
			if(remember) {
				Cookie loginNamecookie = new Cookie("loginName", loginName);
				Cookie passwordcookie = new Cookie("password", password);
				loginNamecookie.setMaxAge(24*60*60);
				passwordcookie.setMaxAge(24*60*60);
				response.addCookie(loginNamecookie);
				response.addCookie(passwordcookie);
			}
			UserVO userVO = userService.findUserVOByLoginName(loginName);
//			userVO.setLoginName(loginName);
//			userVO.setPassword(password);
			request.getSession().setAttribute("username", userVO);
			return "indextab";
		}else {
			modelMap.addAttribute("error", "密码不正确");
			return "login";
		}
		
//		 UserVO userVO = userService.findUserVOByLoginName(loginName);
//		 if(userVO==null) {
//				modelMap.addAttribute("error", "用户不存在");
//				return "login";
//			}
//		String dBPassword =userVO.getPassword();
		
//
//		if(dBPassword.equals(password)) {
//			if(remember) {
//				Cookie loginNamecookie = new Cookie("loginName", loginName);
//				Cookie passwordcookie = new Cookie("password", password);
//				loginNamecookie.setMaxAge(24*60*60);
//				passwordcookie.setMaxAge(24*60*60);
//				response.addCookie(loginNamecookie);
//				response.addCookie(passwordcookie);
//			}
//			request.getSession().setAttribute("username", userVO);
//			return "indextab";
//		}else {
//			modelMap.addAttribute("error", "密码不正确");
//			return "login";
//		}
		
	}
	@RequestMapping(value="logOut")
	public String logOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		return "login";
	}
	private DepartmentsService departmentsService;
	
	public DepartmentsService getDepartmentsService() {
		return departmentsService;
	}
	@Autowired
	public void setDepartmentsService(DepartmentsService departmentsService) {
		this.departmentsService = departmentsService;
	}
	
	@RequestMapping(value="register") 
	public String register(HttpServletRequest request,String loginName,String password) {
		System.out.println(loginName+": "+password+" : ");  
		List<Departments> list = departmentsService.selectByExample(null);
		request.setAttribute("list", list);
		return "add";
	}

	private ResourceService resourceService;
	
	
	public ResourceService getResourceService() {
		return resourceService;
	}

	@Autowired
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	@ResponseBody
	@RequestMapping(value="trees")
	public List<Tree> trees (HttpServletRequest request) {
		UserVO userVO = (UserVO)request.getSession().getAttribute("username");
		List<Resource> res = resourceService.getResoueces(userVO.getId());
		List<Tree> trees = new ArrayList<>();
		if(res!=null) {
			for(Resource r:res) {
				Tree t = new Tree();
				System.out.println(r.getDescription()+" "+r.getUrl());
				t.setId(r.getId());
				t.setPid(r.getPid());
				t.setText(r.getName());
				t.setUrl(r.getUrl());
				t.setResourceType(r.getResourceType());
				trees.add(t);
			}
		}
		return trees;
	}
	private RoleResourceService roleResourceService;
	
	public RoleResourceService getRoleResourceService() {
		return roleResourceService;
	}
	@Autowired
	public void setRoleResourceService(RoleResourceService roleResourceService) {
		this.roleResourceService = roleResourceService;
	}
	
	@ResponseBody
	@RequestMapping(value="treesRole")
	public List<Tree> treesRole(HttpServletRequest request,Long id) {
		List<Resource> allResources = resourceService.selectByExample(null);
		RoleResourceExample record = new RoleResourceExample();
		Criteria cr = record.createCriteria();
		cr.andRoleIdEqualTo(id);
		Set<Resource> res = new HashSet<>();
		List<RoleResource> roleResources = roleResourceService.getRoleResource(record);
		for(RoleResource ron:roleResources) {
			res.add(resourceService.selectByPrimaryKey(ron.getResourceId()));
		}
		List<Tree> trees = new ArrayList<>();
		if(res!=null) {
			for(Resource r:allResources) {
				Tree t = new Tree();
				System.out.println(r.getDescription()+" "+r.getUrl());
				t.setId(r.getId());
				t.setPid(r.getPid());
				t.setText(r.getName());
				t.setUrl(r.getUrl());
				if(res.contains(r)) {
					t.setIschecked(true);
				}
				trees.add(t);
			}
		}
		return trees;
	}
}
