package com.std.service;

import com.std.model.RoleResource;
import com.std.model.RoleResourceExample;

import java.util.List;

public interface RoleResourceService {
	 public Integer insert(RoleResource record);
	 public Integer insertSelective(RoleResource record);
	 public List<RoleResource> getRoleResource(RoleResourceExample example);
}
