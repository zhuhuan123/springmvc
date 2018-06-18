package com.std.controller;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.std.model.Resource;
import com.std.model.Role;
import com.std.model.RoleResource;
import com.std.model.RoleResourceExample;
import com.std.model.RoleResourceExample.Criteria;
import com.std.service.ResourceService;
import com.std.service.RoleResourceService;
import com.std.service.RoleService;

/**
 * @author Administrator
 *
 */
@Controller
public class RoleResourceController {
	private RoleResourceService roleResourceService;
	
	public RoleResourceService getRoleResourceService() {
		return roleResourceService;
	}

	@Autowired
	public void setRoleResourceService(RoleResourceService roleResourceService) {
		this.roleResourceService = roleResourceService;
	}

	private ResourceService resourceService;

	public ResourceService getResourceService() {
		return resourceService;
	}

	@Autowired
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	private RoleService roleService;
	
	public RoleService getRoleService() {
		return roleService;
	}
	
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@RequestMapping(value="RoleResouce")
	public String resources(HttpServletRequest request) {
		List<Role> roles = roleService.selectByExample(null);
//		List<Resource> resources= resourceService.selectByExample(null);
//		request.setAttribute("resources", resources);
		request.setAttribute("roles", roles);
		return "RoleResouce";
	}
	
	@RequestMapping(value="getResourcesByRoleId")
	public String getResourcesByRoleId(Long id) {
		return "getResourcesByRoleId";
	}
	
	@ResponseBody
	@RequestMapping(value="saveRoleResource")
	public HashMap<String,Object> saveRoleResource(Long roleId,Long [] resourceId) {
		HashMap<String,Object> hashMap = new HashMap<String,Object>();//resourceId[]:1
//		System.out.println(roleResource.getId()+" :  "+roleResource.getResourceId()+" : "+roleResource.getRoleId());
		if(resourceId==null) {
			hashMap.put("code", 400);
			hashMap.put("msg", "资源信息为空的失败");
			return hashMap;
		}
		
		RoleResourceExample record = new RoleResourceExample();
		Criteria cr = record.createCriteria();
		cr.andRoleIdEqualTo(roleId);
		Set<Long> res = new HashSet<>();
		List<RoleResource> roleResources = roleResourceService.getRoleResource(record);
		for(RoleResource ron:roleResources) {
			res.add(ron.getResourceId());
		}
		HashSet<Long> l = new HashSet<Long>();
		for(int i=0;i<resourceId.length;i++) {
			if(!res.contains(resourceId[i])) {
				l.add(resourceId[i]);
			}
		}
		if(l.isEmpty()) {
			hashMap.put("code", 400);
			hashMap.put("msg", "没有添加新的资源信息");
			return hashMap;
		}
		Iterator<Long> ite = l.iterator();
		while(ite.hasNext()) {
//		for(int i=0;i<l.size();i++) {
			RoleResource roleResource = new RoleResource();
			roleResource.setResourceId(ite.next());
			roleResource.setRoleId(roleId);
			Integer ii = roleResourceService.insert(roleResource);
			hashMap.put("code", 200);
			if(ii>0) {
				hashMap.put("msg", "关联角色和资源信息成功");
			}else {
				hashMap.put("msg", "关联角色和资源信息失败");
			}
		}
		return hashMap;
	}
	
	/**通过资源id数组    还有角色id进行关联管理
	 * @param roleId
	 * @param resourceId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="saveRoleResourceTree")
	public HashMap<String,Object> saveRoleResourceTree(Long roleId,String resourceId ) {
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
//		System.out.println(roleResource.getId()+" :  "+roleResource.getResourceId()+" : "+roleResource.getRoleId());
		System.out.println(roleId+" :  "+resourceId);
		String [] strresources;
		Long [] resourceIds = null ;
		if(resourceId==null) {
			hashMap.put("code", 400);
			hashMap.put("msg", "资源信息为空的失败");
			return hashMap;
		}
		if(resourceId!=null) {
			strresources = resourceId.split(",");
			resourceIds = new Long[strresources.length];
			for(int o=0;o<strresources.length;o++) {
				resourceIds[o]=Long.parseLong(strresources[o]);
			}
		}
		if(resourceIds==null) {
			hashMap.put("code", 400);
			hashMap.put("msg", "资源信息为空的失败");
			return hashMap;
		}
		
		RoleResourceExample record = new RoleResourceExample();
		Criteria cr = record.createCriteria();
		cr.andRoleIdEqualTo(roleId);
		Set<Long> res = new HashSet<>();
		List<RoleResource> roleResources = roleResourceService.getRoleResource(record);
		HashSet<Long> l = new HashSet<Long>();
		if(roleResources!=null) {
			for(RoleResource ron:roleResources) {
				res.add(ron.getResourceId());
			}
			for(int i=0;i<resourceIds.length;i++) {
				if(!res.contains(resourceIds[i])) {
					l.add(resourceIds[i]);
			}
			}
		}else {
			for(int i=0;i<resourceIds.length;i++) {
				l.add(resourceIds[i]);
			}
		}
		if(l.isEmpty()) {
			hashMap.put("code", 400);
			hashMap.put("msg", "没有添加新的资源信息");
			return hashMap;
		}
		Iterator<Long> ite = l.iterator();
		while(ite.hasNext()) {
			RoleResource roleResource = new RoleResource();
			roleResource.setResourceId(ite.next());
			roleResource.setRoleId(roleId);
			Integer ii = roleResourceService.insert(roleResource);
			hashMap.put("code", 200);
			if(ii>0) {
				hashMap.put("msg", "关联角色和资源信息成功");
			}else {
				hashMap.put("msg", "关联角色和资源信息失败");
			}
		}
		return hashMap;
	}
	
	
	
	
	/**从角色的id  获取资源列表
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getRoleResourceById")
	public Set<Resource> getRoleResource(Long id) {
		RoleResourceExample record = new RoleResourceExample();
		Criteria cr = record.createCriteria();
		cr.andRoleIdEqualTo(id);
		Set<Resource> resources = new HashSet<>();
		List<RoleResource> roleResources = roleResourceService.getRoleResource(record);
		for(RoleResource ron:roleResources) {
			resources.add(resourceService.selectByPrimaryKey(ron.getResourceId()));
		}
		return resources;
	}
}
