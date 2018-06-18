package com.std.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.std.VO.DepartmentVO;
import com.std.model.Departments;
import com.std.model.DepartmentsExample;
import com.std.service.DepartmentsService;

/**
 * @author Administrator
 *
 */
@Controller
public class DepartmentsContoller {
	
	private DepartmentsService departmentsService;

	public DepartmentsService getDepartmentsService() {
		return departmentsService;
	}

	@Autowired
	public void setDepartmentsService(DepartmentsService departmentsService) {
		this.departmentsService = departmentsService;
	}
	@ResponseBody
	@RequestMapping(value="selectDepartmentsByExample")
	public HashMap<String,Object> selectByExample(Integer page,Integer pagesize, DepartmentsExample example){
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		Long total = departmentsService.countByExample(example);
		PageHelper.startPage(page, pagesize);
		List<Departments> depa = departmentsService.selectByExample(example);
		hashMap.put("Rows", depa);
		hashMap.put("Total", total);
		return  hashMap;
	 }
	
	@ResponseBody
	@RequestMapping(value="selectDepartments")
	public List<DepartmentVO> selectDepartments(DepartmentsExample example){
		List<DepartmentVO> departmentVOs = new ArrayList<>();
		List<Departments> depa = departmentsService.selectByExample(example);
		for(Departments departments:depa) {
			DepartmentVO departmentVO = new DepartmentVO();
			departmentVO.setId(departments.getId());
			departmentVO.setText(departments.getName());
			departmentVOs.add(departmentVO);
		}
		return departmentVOs;
	}
	
	/**选择单个的Departments 对象值
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="selectDepartmentsByPrimaryKey")
	public Departments selectByPrimaryKey(Long id) {
		if(id==null) {
			return null;
		}
	    return departmentsService.selectByPrimaryKey(id);
	}
	
	@ResponseBody
	@RequestMapping(value="deleteDepartmentByPrimaryKey")
	public HashMap<String,Object> deleteByPrimaryKey(Long id) {
		HashMap<String,Object> has = new HashMap<String,Object>();
		if(id==null) {
			has.put("code", "400");
			has.put("msg", "id值不能为空");
			return has;
		}
		has.put("code", "200");
		Integer i = departmentsService.deleteByPrimaryKey(id);
		if(i>0) {
			has.put("msg", "删除部门成功");
		}else {
			has.put("msg", "删除部门失败");
			
		}
		return has;
	}

	@RequestMapping(value="insertDepartments")
	public int insert(Departments record) {
	    return departmentsService.insert(record);
	}
	
	@ResponseBody
	@RequestMapping(value="insertDepartmentsSelective")
	public HashMap<String,Object> insertSelective(Departments record) {
		HashMap<String,Object> has = new HashMap<String,Object>();
		has.put("code", "200");
		if(departmentsService.insertSelective(record)>0) {
			has.put("msg", "新增部门成功");
		}else {
			has.put("msg", "新增部门失败");
		}
	    return has;
	 }
	@RequestMapping(value="toAddDepartment")
	public String toAddDepartment() {
		return "adddepartment";
	}
	
	@RequestMapping(value="departmentUI")
	public String departmentUI() {
		return "departmentUI";
	}
	@RequestMapping(value="departmentUIAjax")
	public String departmentUIAjax() {
		return "departmentUIAjax";
	}
	
	@ResponseBody
	@RequestMapping(value="updateByPrimaryKeySelective")
	public HashMap<String,Object> updateByPrimaryKeySelective(Departments departments) {
		HashMap<String,Object> has = new HashMap<String,Object>();
		if(departments==null) {
			has.put("code", 400);
			has.put("msg", "部门信息为空");
			return has;
		}
		departments.setUpdateTime(new Date());
		int v = departmentsService.updateByPrimaryKeySelective(departments);
		has.put("code", 200);
		if(v>0) {
			has.put("msg", "更新部门成功");
		}else {
			has.put("msg", "更新部门失败");
		}
		return has;
	}
	
	@ResponseBody
	@RequestMapping(value="toUpdateByPrimaryKeySelective")
	public Departments toUpdateByPrimaryKeySelective(Long id,HttpServletRequest request) {
		if(id==null) {
			return null;
		}
		Departments departments = departmentsService.selectByPrimaryKey(id);
//		request.setAttribute("departments", departments);
		return departments;
	}
	
	
}
