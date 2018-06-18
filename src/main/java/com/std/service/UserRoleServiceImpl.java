package com.std.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.dao.UserRoleMapper;
import com.std.model.UserRole;

@Component
public class UserRoleServiceImpl implements UserRoleService {

	private UserRoleMapper userRoleMapper;
	
	public UserRoleMapper getUserRoleMapper() {
		return userRoleMapper;
	}
	
	@Autowired
	public void setUserRoleMapper(UserRoleMapper userRoleMapper) {
		this.userRoleMapper = userRoleMapper;
	}

	@Override
	public UserRole selectByPrimaryKey(Long id) {
		userRoleMapper.selectByPrimaryKey(id);
		return null;
	}

	@Override
	public List<UserRole> selectByUserId(Long userId) {
		List<UserRole> userRoles = userRoleMapper.selectByUserId(userId);
		return userRoles;
	}

	@Override
	public Integer insertSelective(UserRole record) {
		return userRoleMapper.insertSelective(record);
	}

	@Override
	public HashMap<String, Object> insertSelective(Long userId, Long[] roleId) {
		HashMap<String,Object> hash = new HashMap<>();
		if(userId==null) {
			hash.put("code", 400);
			hash.put("msg", "userId  不能为空");
			return hash;
		}
		if(roleId==null) {
			hash.put("code", 400);
			hash.put("msg", "roleId  不能为空");
			return hash;
		}
		
		for(int i=0;i<roleId.length;i++) {
			UserRole record = new UserRole();
			record.setUserId(userId);
			record.setRoleId(roleId[i]);
			userRoleMapper.insertSelective(record);
		}
		
		hash.put("code", 200);
		hash.put("msg", "关联用户和角色成功");
		return hash;
	}

	@Override
	public Integer insert(UserRole record) {
		return userRoleMapper.insert(record);
	}
	
	

}
