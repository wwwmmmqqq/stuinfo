package com.stuinfo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.service.SchoolStudentService;

public class SchoolStudentAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private SchoolStudentService SchoolStudentService;
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;

	/**
	 * 
	 * @throws Exception
	 * @说明获取所有在校学生
	 */
	public void listSchoolStudentAll() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

		http_response.setContentType("text/html;charset=utf-8");
		List<StudentDTO> list_Student = SchoolStudentService.listSchoolStudentAll();
		http_response.getWriter().write(gson.toJson(list_Student));
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

	public SchoolStudentService getSchoolStudentService() {
		return SchoolStudentService;
	}

	public void setSchoolStudentService(SchoolStudentService schoolStudentService) {
		SchoolStudentService = schoolStudentService;
	}

	@Override
	public void setServletRequest(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

	@Override
	public void setServletResponse(HttpServletResponse http_response) {
		this.http_response = http_response;

	}

}
