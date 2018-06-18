package com.std.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.std.service.UserRoleService;

@Controller
public class UserRoleController {
	private UserRoleService userRoleService;

	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	@Autowired
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	@ResponseBody
	@RequestMapping(value="insertSelectiveUserRoleIds")
	public HashMap<String,Object> insertSelective(Long userId,Long [] roleId){
		return userRoleService.insertSelective(userId, roleId);
	}
	
	@ResponseBody
	@RequestMapping(value="saveuserrole")
	public HashMap<String,Object> save(Long userid,Long [] rol) {
		HashMap<String,Object> ha = null;
		if(userid==null) {
			ha.put("code", "400");
			ha.put("msg", "用户id为空");
			return ha;
		}
		if(rol==null) {
			ha.put("code", "400");
			ha.put("msg", "角色id为空");
			return ha;
		}
		System.out.println("userid "+userid);
		for(Long r:rol) {
			System.out.println("rol "+r+" ");
		}
		ha = userRoleService.insertSelective(userid, rol);
		return ha;
	}
	
	@RequestMapping(value="userUIRole")
	public String userUIRole() {
		return "userUIRole";
	}
	
}
