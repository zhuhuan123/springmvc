package com.std.dao;

import com.std.model.Departments;
import com.std.model.DepartmentsExample;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface DepartmentsMapper {
    long countByExample(DepartmentsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Departments record);

    int insertSelective(Departments record);

    List<Departments> selectByExample(DepartmentsExample example);

    Departments selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Departments record);

    int updateByPrimaryKey(Departments record);
}