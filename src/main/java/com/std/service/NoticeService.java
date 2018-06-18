package com.std.service;

import java.util.List;

import com.std.model.Notice;
import com.std.model.NoticeExample;

public interface NoticeService {
	List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(Integer id);

    int insertSelective(Notice record);
    long countByExample(NoticeExample example);
    int updateByPrimaryKeySelective(Notice record);
    Integer deletNotice(Long id);
}
