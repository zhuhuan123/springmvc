package com.std.dao;

import com.std.model.Resource;
import com.std.model.Role;
import com.std.model.RoleExample;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    List<Resource> selectResourceListByRoleIdList(List<Long> list);
}