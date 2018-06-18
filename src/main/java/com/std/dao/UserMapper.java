package com.std.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.std.VO.UserVO;
import com.std.model.*;

@Component
public interface UserMapper {
//	@Select(value="select id,username,birthday,sex,address from user")
	public List<User> findByUser();
	public User findByUserId(Integer id);
	public void insertUser(User user);
	public List<User> finduser();
	public List<User> selectByCondition(User user);
//	public List<User> selectByConditionPage(Integer page,Integer pagesize,User user);
	public List<User> selectByConditionPage(HashMap<String,Object> hashMap);
	
	public void updateuser(User user);
	public void insertlist(List<User> users);
	public void deleteUser(Integer id);
	public Integer deleteById(Integer id);
	public Integer selectCountByConditionPage(User user);
	public String findByLoginName(String username);
	public UserVO findUserVOByLoginName(String loginName);
}
