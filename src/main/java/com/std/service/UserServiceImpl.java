package com.std.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.VO.UserVO;
import com.std.dao.UserMapper;
import com.std.model.User;

@Component
public class UserServiceImpl implements UserService{
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public List<User> getUsers(){
		return userMapper.findByUser();
	}
	
	public void test() {
		System.out.println("≤‚ ‘≥Ã–Ú");
	}

	@Override
	public User findByUserId(Integer id) {
		
		return userMapper.findByUserId(id);
	}

	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public List<User> finduser() {
		return userMapper.finduser();
	}

	@Override
	public void updateuser(User user) {
		userMapper.updateuser(user);
	}
	public void insertlist(List<User> users) {
		userMapper.insertlist(users);
	}

	@Override
	public void deleteUser(Integer id) {
		userMapper.deleteUser(id);
	}

	@Override
	public boolean deleteById(Integer id) {
		Integer i = userMapper.deleteById(id);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> selectByCondition(User user) {
		return userMapper.selectByCondition(user);
	}

	@Override
	public List<User> selectByConditionPage(HashMap<String,Object> hashMap) {
		// TODO Auto-generated method stub
		return userMapper.selectByConditionPage(hashMap);
	}

	@Override
	public Integer selectCountByConditionPage(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectCountByConditionPage(user);
	}

	@Override
	public String findByLoginName(String username) {
		return userMapper.findByLoginName(username);
	}

	@Override
	public UserVO findUserVOByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.findUserVOByLoginName(loginName);
	}
	
	
	
}
