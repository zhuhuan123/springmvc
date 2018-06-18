package com.std.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.std.model.Role;
import com.std.service.RoleService;
import java.util.*;
/**
 * @author Administrator
 *
 */
@Controller
public class RoleController {
	private RoleService roleService;

	public RoleService getRoleService() {
		return roleService;
	}

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@ResponseBody
	@RequestMapping(value="getRoles")
	public HashMap<String,Object> getRoles(Integer page,Integer pagesize){
		HashMap<String,Object> hashMap = new HashMap<>();
		Long total = roleService.countByExample(null);
		PageHelper.startPage(page, pagesize);
		List<Role> roles = roleService.selectByExample(null);
		hashMap.put("Rows",roles );
		hashMap.put("Total",total);
		return hashMap;
	}
	@ResponseBody
	@RequestMapping(value="getRolesAll")
	public List<Role> getRolesAll(){
		List<Role> roles = roleService.selectByExample(null);
		return roles;
	}
	
	@RequestMapping(value="RoleUI")
	public String roleUI() {
		return "RoleUI";
	}
	
	@ResponseBody
	@RequestMapping(value="addRole")
	public HashMap<String,Object> addRole(Role role) {
		HashMap<String,Object> has = new HashMap<String,Object>();
		if(role==null) {
			has.put("msg", "角色值不能为空");
			return has;
		}
		if(role.getName()==null) {
			has.put("code", 400);
			has.put("msg", "角色名称不能为空");
			return has;
		}
		if(role.getStatus()==null) {
			has.put("code", 400);
			has.put("msg", "角色状态不能为空");
			return has;
		}
		has.put("code", "200");
		
		Integer i = roleService.insert(role);
		if(i>0) {
			has.put("msg", "新增角色成功");
		}else {
			has.put("msg", "新增角色失败");
		}
		return has;
	}
	@ResponseBody
	@RequestMapping(value="DeletRole")
	public HashMap<String,Object> deletRole(Long id) {
		HashMap<String,Object> has = new HashMap<String,Object>();
		if(id==null) {
			has.put("code", "400");
			has.put("msg","删除的id不能为空");
			return has;
		}
		has.put("code", "200");
		Integer i = roleService.deleteByPrimaryKey(id);
		if(i>0) {
			has.put("msg", "删除角色成功");
		}else {
			has.put("msg", "删除角色失败");
		}
		return has;
	}
	
	@ResponseBody
	@RequestMapping(value="UpdateRole")
	public Role getRol(Long id) {
		if(id==null) {
			return null;
		}
		Role r = roleService.selectByPrimaryKey(id);
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="updateRolById")
	public HashMap<String,Object> updateRol(Role record) {
		HashMap<String,Object> hashMap = new HashMap<>();
//		record.s
		Integer i = roleService.updateByPrimaryKeySelective(record);
		hashMap.put("code", 200);
		if(i>0) {
			hashMap.put("msg", "更新成功");
		}else {
			hashMap.put("msg", "更新失败");
		}
		return hashMap;
	}
	
	@RequestMapping(value="toAddRole")
	public String toAddRole() {
		return "addRole";
	}
}
