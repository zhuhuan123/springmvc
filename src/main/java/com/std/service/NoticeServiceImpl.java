package com.std.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.dao.NoticeMapper;
import com.std.model.Notice;
import com.std.model.NoticeExample;

@Component
public class NoticeServiceImpl implements NoticeService {

	private NoticeMapper noticeMapper;
	
	public NoticeMapper getNoticeMapper() {
		return noticeMapper;
	}
	
	@Autowired
	public void setNoticeMapper(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	@Override
	public List<Notice> selectByExample(NoticeExample example) {
		return noticeMapper.selectByExample(example);
	}

	@Override
	public Notice selectByPrimaryKey(Integer id) {
		return noticeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Notice record) {
		return noticeMapper.insert(record);
	}

	@Override
	public long countByExample(NoticeExample example) {
		return noticeMapper.countByExample(example);
	}

	@Override
	public int updateByPrimaryKeySelective(Notice record) {
		return noticeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deletNotice(Long id) {

		return noticeMapper.deleteByPrimaryKey(id);
	}
	
	

}
