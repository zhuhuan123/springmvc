package com.std.service;
import java.util.*;
import com.std.model.*;
public interface ResourceService {
	public List<Resource> getResoueces(Long userid);
	public List<Resource> selectByExample(ResourceExample example);
	public Long countByExample(ResourceExample example);
	public Integer insertSelective(Resource record);
	public Integer updateByPrimaryKey(Resource record);
	public Integer updateByPrimaryKeySelective(Resource record);

	public Resource selectByPrimaryKey(Long id);
	public Integer deleteByPrimaryKey(Long id);
}
