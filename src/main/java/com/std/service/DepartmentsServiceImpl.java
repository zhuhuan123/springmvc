package com.std.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.dao.DepartmentsMapper;
import com.std.model.Departments;
import com.std.model.DepartmentsExample;

@Component
public class DepartmentsServiceImpl implements DepartmentsService{

	private DepartmentsMapper departmentsMapper;
	
	
	public DepartmentsMapper getDepartmentsMapper() {
		return departmentsMapper;
	}

	@Autowired
	public void setDepartmentsMapper(DepartmentsMapper departmentsMapper) {
		this.departmentsMapper = departmentsMapper;
	}

	@Override
	public long countByExample(DepartmentsExample example) {
		// TODO Auto-generated method stub
		return departmentsMapper.countByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return departmentsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Departments record) {
		// TODO Auto-generated method stub
		return departmentsMapper.insert(record);
	}

	@Override
	public int insertSelective(Departments record) {
		// TODO Auto-generated method stub
		return departmentsMapper.insertSelective(record);
	}

	@Override
	public List<Departments> selectByExample(DepartmentsExample example) {
		// TODO Auto-generated method stub
		return departmentsMapper.selectByExample(example);
	}

	@Override
	public Departments selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return departmentsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Departments record) {
		// TODO Auto-generated method stub
		return departmentsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Departments record) {
		// TODO Auto-generated method stub
		return departmentsMapper.updateByPrimaryKey(record);
	}

}
