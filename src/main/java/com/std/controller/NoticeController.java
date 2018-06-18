package com.std.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.std.model.Notice;
import com.std.model.NoticeExample;
import com.std.service.NoticeService;

/**
 * @author Administrator
 *
 */
@Controller
public class NoticeController {
	private NoticeService noticeService;

	public NoticeService getNoticeService() {
		return noticeService;
	}

	@Autowired
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@ResponseBody
	@RequestMapping(value="insertNoticeSelective")
	public HashMap<String,Object> insertNoticeSelective(Notice notice,HttpServletRequest request) {
		HashMap<String,Object> has = new HashMap<>();
		notice.setCreateDate(new Date());
		Integer i = noticeService.insertSelective(notice);
		request.setAttribute("notice", notice);
		if(i>0) {
			has.put("code", 200);
			has.put("msg", "新增公告成功");
			request.setAttribute("con", notice.getContent());
		}else {
			has.put("code", 400);
			has.put("msg", "新增公告失败");
		}
		return has;
	}
	
	@ResponseBody
	@RequestMapping(value="selectNoticeByExample")
	public HashMap<String,Object> selectNoticeByExample(Integer page,Integer pagesize,NoticeExample example) {
		HashMap<String,Object> has = new HashMap<>();
		Long total =noticeService.countByExample(example);
		PageHelper.startPage(page, pagesize); 
		List<Notice> notices = noticeService.selectByExample(example);
		has.put("Total", total);
		has.put("Rows", notices);
		return has;
	}
	
	@RequestMapping(value="NoticeUI")
	public String noticeUI() {
		return "NoticeUI";
	}
	
	
	@RequestMapping(value="getContentByNoticeId")
	public String noticeShow(Integer id,HttpServletRequest request){
		Notice notice = noticeService.selectByPrimaryKey(id);
		request.setAttribute("notice", notice);
		return "noticeShow";
	}
	
	
	@RequestMapping(value="updateNoticeSelective")
	public String updateNoticeSelective(Notice notice) {
		Integer i= noticeService.updateByPrimaryKeySelective(notice);
		return "noticeResult";

		
	}
	
	@RequestMapping(value="notice")
	public String notice() {
		return "notice";
	}
	
	@RequestMapping(value="deletNotice")
	public HashMap<String,Object> deletNotice(Long id) {
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("code", 200);
		Integer i = noticeService.deletNotice(id);
		if(i>0) {
			hashMap.put("msg", "删除公告成功");
		}else {
			hashMap.put("msg", "删除公告失败");
		}
		return hashMap;
	}
}
