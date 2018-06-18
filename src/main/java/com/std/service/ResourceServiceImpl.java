package com.std.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.dao.ResourceMapper;
import com.std.dao.RoleMapper;
import com.std.dao.UserRoleMapper;
import com.std.model.Resource;
import com.std.model.ResourceExample;
import com.std.model.Role;
import com.std.model.RoleResource;
import com.std.model.RoleResourceExample;

@Component
public class ResourceServiceImpl implements ResourceService {

	private UserRoleMapper userRoleMapper;
	
	public UserRoleMapper getUserRoleMapper() {
		return userRoleMapper;
	}

	@Autowired
	public void setUserRoleMapper(UserRoleMapper userRoleMapper) {
		this.userRoleMapper = userRoleMapper;
	}

	private RoleMapper roleMapper;
	
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	
	@Autowired
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	private ResourceMapper resourceMapper;
	
	public ResourceMapper getResourceMapper() {
		return resourceMapper;
	}

	@Autowired
	public void setResourceMapper(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}

	@Override
	public List<Resource> getResoueces(Long userId) {
		List<Long> list = userRoleMapper.selectRoleIdListByUserId(userId);
		if(list==null) {
			return null;
		}
		if(list.size()==0) {
			return null;
		}
		List<Resource> resources = roleMapper.selectResourceListByRoleIdList(list);
		return resources;
	}

	@Override
	public List<Resource> selectByExample(ResourceExample example) {
		
		return resourceMapper.selectByExample(example);
	}

	@Override
	public Long countByExample(ResourceExample example) {
		return resourceMapper.countByExample(example);
	}

	@Override
	public Integer insertSelective(Resource record) {
		return resourceMapper.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKey(Resource record) {
		return resourceMapper.updateByPrimaryKey(record);
	}

	@Override
	public Resource selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub  
		return resourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer deleteByPrimaryKey(Long id) {
		return resourceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateByPrimaryKeySelective(Resource record) {
		// TODO Auto-generated method stub
		return resourceMapper.updateByPrimaryKeySelective(record);
	}

}
