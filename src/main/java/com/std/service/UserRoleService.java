package com.std.service;

import java.util.HashMap;
import java.util.List;

import com.std.model.UserRole;

public interface UserRoleService {
	public UserRole selectByPrimaryKey(Long id);
	public List<UserRole> selectByUserId( Long userId);
	public Integer insertSelective(UserRole record);
	public HashMap<String,Object> insertSelective(Long userId,Long [] roleId);
	public Integer insert(UserRole record);
}
