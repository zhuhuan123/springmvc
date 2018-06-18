package com.std.dao;

import com.std.model.RoleResource;
import com.std.model.RoleResourceExample;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component
public interface RoleResourceMapper {
    long countByExample(RoleResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    List<RoleResource> selectByExample(RoleResourceExample example);

    RoleResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);
    
}