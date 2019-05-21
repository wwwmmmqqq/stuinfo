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
import com.stuinfo.domain.DO.stuinfo_stu_grade;
import com.stuinfo.service.GradeService;

@SuppressWarnings("serial")
public class GradeAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private GradeService gradeService;
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;

	private stuinfo_stu_grade newGrade;

	/**
	 * 
	 * @throws Exception
	 * @说明 获取学生年级
	 */
	public void listGradeAll() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		List<stuinfo_stu_grade> list_Student_Grade = gradeService.listGradeAll();

		http_response.getWriter().write(gson.toJson(list_Student_Grade));
	}

	public void test2() throws Exception {
		System.out.println("bbb");
	}

	/**
	 * @throws IOException
	 * @说明 手动添加年级
	 */
	public void CreateGrade() throws IOException {
		if (gradeService.save_NewGrade(newGrade)) {
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("success");
		} else {
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("failture");
		}

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

	public GradeService getGradeService() {
		return gradeService;
	}

	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	@Override
	public void setServletRequest(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

	@Override
	public void setServletResponse(HttpServletResponse http_response) {
		this.http_response = http_response;

	}

	public stuinfo_stu_grade getNewGrade() {
		return newGrade;
	}

	public void setNewGrade(stuinfo_stu_grade newGrade) {
		this.newGrade = newGrade;
	}

}
