package com.std.service;

import java.util.List;

import com.std.model.Departments;
import com.std.model.DepartmentsExample;

public interface DepartmentsService {
    long countByExample(DepartmentsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Departments record);

    int insertSelective(Departments record);

    List<Departments> selectByExample(DepartmentsExample example);

    Departments selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Departments record);

    int updateByPrimaryKey(Departments record);
}
