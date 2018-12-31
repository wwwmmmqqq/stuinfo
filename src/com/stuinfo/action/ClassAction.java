package com.stuinfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.stuinfo.domain.DO.stuinfo_stu_class;
import com.stuinfo.domain.DTO.ClassAndGradeDTO;
import com.stuinfo.service.ClassService;

@SuppressWarnings("serial")
public class ClassAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private ClassService classService;
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;
	private stuinfo_stu_class newClass;

	/**
	 * 
	 * @throws Exception
	 * @说明 获取学生班级
	 */
	public void listClassAll() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		List<ClassAndGradeDTO> list_Student_Class = classService.listClassAll();
		http_response.getWriter().write(gson.toJson(list_Student_Class));
	}

	/**
	 * 
	 * @throws Exception
	 * @说明 手动添加班级
	 */
	public void CreateClass() throws IOException {
		if (classService.save_NewClass(newClass)) {
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("success");
		} else {
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("failture");
		}

	}

	@Override
	public void setServletRequest(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

	@Override
	public void setServletResponse(HttpServletResponse http_response) {
		this.http_response = http_response;

	}

	public ClassService getClassService() {
		return classService;
	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
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

	public stuinfo_stu_class getNewClass() {
		return newClass;
	}

	public void setNewClass(stuinfo_stu_class newClass) {
		this.newClass = newClass;
	}

}
