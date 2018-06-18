package com.std.service;

import java.util.HashMap;
import java.util.List;

import com.std.VO.UserVO;
import com.std.model.User;

public interface UserService {
	public List<User> getUsers();
	public User findByUserId(Integer id);
	public void insertUser(User user);
	public List<User> finduser();
	public void updateuser(User user);
	public void insertlist(List<User> users);
	public void deleteUser(Integer id);
	public boolean deleteById(Integer id);
	public List<User> selectByCondition(User user);
	public List<User> selectByConditionPage(HashMap<String,Object> hashMap);
	public Integer selectCountByConditionPage(User user);
	public String findByLoginName(String username);
	public UserVO findUserVOByLoginName(String loginName);
}
