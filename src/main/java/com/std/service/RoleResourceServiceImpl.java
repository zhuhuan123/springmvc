package com.std.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.dao.RoleResourceMapper;
import com.std.model.RoleResource;
import com.std.model.RoleResourceExample;

/**
 * @author Administrator
 *
 */
@Component
public class RoleResourceServiceImpl implements RoleResourceService{

	private RoleResourceMapper roleResourceMapper;
	
	public RoleResourceMapper getRoleResourceMapper() {
		return roleResourceMapper;
	}

	@Autowired
	public void setRoleResourceMapper(RoleResourceMapper roleResourceMapper) {
		this.roleResourceMapper = roleResourceMapper;
	}

	@Override
	public Integer insert(RoleResource record) {
		return roleResourceMapper.insert(record);
	}

	@Override
	public Integer insertSelective(RoleResource record) {
		return roleResourceMapper.insertSelective(record);
	}

	@Override
	public List<RoleResource> getRoleResource(RoleResourceExample example) {
		return roleResourceMapper.selectByExample(example);
	}

}
