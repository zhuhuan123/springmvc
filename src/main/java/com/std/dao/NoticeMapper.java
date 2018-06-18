package com.std.dao;

import com.std.model.Notice;
import com.std.model.NoticeExample;
import java.util.List;

public interface NoticeMapper {
    long countByExample(NoticeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}