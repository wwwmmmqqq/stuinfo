package com.stuinfo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.stuinfo.domain.DO.stuinfo_notice;
import com.stuinfo.domain.VO.NoticeVO;
import com.stuinfo.service.NoticeManageService;

public class NoticeManageAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;
	private NoticeManageService noticeManageService;
	private stuinfo_notice stuinfoNotice;
	private String NoticeId;
	private NoticeVO noticeVO;

	// 获取到所有的未读通知
	public void listNoticesAll() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		List<stuinfo_notice> list_notices = noticeManageService.listNoticesAll();
		http_response.getWriter().write(gson.toJson(list_notices));
	}

	// 获取到所有未读消息并进行分页
	public void listNoticeByPageAndSearch() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		noticeVO = noticeManageService.VO_Notice_By_PageAndSearch(noticeVO);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(noticeVO));

	}

	// 获取到所有已读的消息
	public void listReadNoticesAll() throws Exception {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		List<stuinfo_notice> list_read_notices = noticeManageService.listReadNoticesAll();
		http_response.getWriter().write(gson.toJson(list_read_notices));

	}

	// 获取到所有已读的消息并进行分页
	public void listReadNoticeByPageAndSearch() throws Exception {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		noticeVO = noticeManageService.VO_Read_Notice_By_PageAndSearch(noticeVO);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(noticeVO));

	}

	// 点击知道了 改变通知状态
	public void NoticeOk() throws Exception {
		noticeManageService.NoticeOk(NoticeId);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");
	}

	public HttpServletResponse getHttp_response() {
		return http_response;
	}

	public void setHttp_response(HttpServletResponse http_response) {
		this.http_response = http_response;
	}

	public HttpServletRequest getHttp_request() {
		return http_request;
	}

	public void setHttp_request(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

	@Override
	public void setServletRequest(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

	@Override
	public void setServletResponse(HttpServletResponse http_response) {
		this.http_response = http_response;

	}

	public NoticeManageService getNoticeManageService() {
		return noticeManageService;
	}

	public void setNoticeManageService(NoticeManageService noticeManageService) {
		this.noticeManageService = noticeManageService;
	}

	public stuinfo_notice getStuinfoNotice() {
		return stuinfoNotice;
	}

	public void setStuinfoNotice(stuinfo_notice stuinfoNotice) {
		this.stuinfoNotice = stuinfoNotice;
	}

	public String getNoticeId() {
		return NoticeId;
	}

	public void setNoticeId(String noticeId) {
		NoticeId = noticeId;
	}

	public NoticeVO getNoticeVO() {
		return noticeVO;
	}

	public void setNoticeVO(NoticeVO noticeVO) {
		this.noticeVO = noticeVO;
	}

}
