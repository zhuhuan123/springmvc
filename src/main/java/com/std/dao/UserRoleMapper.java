package com.std.dao;

import com.std.model.UserRole;
import com.std.model.UserRoleExample;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface UserRoleMapper {
    long countByExample(UserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleExample example);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    
//    public UserRole selectByUserId(Long userid);
    public List<UserRole> selectByUserId( Long userId);
    public List<Long> selectRoleIdListByUserId( Long userId);
}