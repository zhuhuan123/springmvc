package com.std.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.std.model.Resource;
import com.std.model.ResourceExample;
import com.std.service.ResourceService;

/**
 * @author Administrator
 *
 */
@Controller
public class ResourceController {
	
	private ResourceService resourceService;

	public ResourceService getResourceService() {
		return resourceService;
	}

	@Autowired
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	@RequestMapping(value="selectByResourceExample")
	@ResponseBody
	public HashMap<String,Object> selectByExample(ResourceExample example,Integer page,Integer pagesize){
		HashMap<String,Object> hashMap = new HashMap<>();
		Long total = resourceService.countByExample(example);
		PageHelper.startPage(page,pagesize);
		List<Resource> list = resourceService.selectByExample(example);
		hashMap.put("Rows", list);
		hashMap.put("Total",total);
		return hashMap;
	}
	
	@ResponseBody
	@RequestMapping(value="insertResourceSelective")
	public HashMap<String,Object> insertSelective(Resource resource){
		System.out.println(resource.getName()+" : "+resource.getDescription());
		HashMap<String,Object> hashMap = new HashMap<>();
		resource.setCreateTime(new Date());
		resource.setUpdateTime(new Date());
		Integer i = resourceService.insertSelective(resource);
		hashMap.put("code", 200);
		if(i>0) {
			hashMap.put("msg", "新增资源信息成功");
		}else {
			hashMap.put("msg", "新增资源信息失败");
		}
		return hashMap;
	}
	
	@RequestMapping(value="ResourceUIAjax")
	public String resourceUIAjax(){
		return "ResourceUIAjax";
	}
	
	@ResponseBody
	@RequestMapping(value="updateResourceByPrimaryKey")
	public HashMap<String,Object> updateResourceByPrimaryKey(Resource resource){
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		resource.setUpdateTime(new Date());
		Integer i = resourceService.updateByPrimaryKeySelective(resource);
		hashMap.put("code", 200);
		if(i>0) {
			hashMap.put("msg", "更新资源信息成功");
		}else {
			hashMap.put("msg", "更新资源信息失败");
		}
		return hashMap;
	}
	@ResponseBody
	@RequestMapping(value="toUpdateResourceByPrimaryKeySelective")
	public Resource toUpdateResourceByPrimaryKeySelective(Long id){
		Resource r = resourceService.selectByPrimaryKey(id);
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteResourceByPrimaryKey")
	public HashMap<String,Object> deleteByPrimaryKey(Long id){
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		Integer i = resourceService.deleteByPrimaryKey(id);
		hashMap.put("code", 200);
		if(i>0) {
			hashMap.put("msg", "删除资源成功");
		}else {
			hashMap.put("msg", "删除资源失败");
		}
		return hashMap;
	}
	
	@RequestMapping(value="addResource")
	public String addResource() {
		return "addResource";
	}
}
