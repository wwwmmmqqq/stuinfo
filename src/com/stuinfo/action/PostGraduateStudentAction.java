package com.stuinfo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.PostGraduateStudentVO;
import com.stuinfo.service.PostGraduateStudentService;

@SuppressWarnings("serial")
public class PostGraduateStudentAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private PostGraduateStudentService postGraduateStudentService;
	private PostGraduateStudentVO postGraduateStudentVO;
	private stuinfo_stubaseinfo stuinfoStuBaseinfo;
	private List<StudentDTO> stuDto;
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;

	/**
	 * 
	 * @throws Exception
	 * @说明获取所有考研学生
	 */
	public void listPostGraduateStudentAll() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		List<StudentDTO> list_Student = postGraduateStudentService.listPostGraduateStudentAll();
		http_response.getWriter().write(gson.toJson(list_Student));
	}

	/*
	 * 将获取到的所有考研学生进行分页
	 *
	 */
	public void listPostGraduateStudentByPageAndSearch() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		StudentDTO studentDTO = (StudentDTO) ActionContext.getContext().getSession().get("studentDTO");
		postGraduateStudentVO = postGraduateStudentService.VO_Student_By_PageAndSearch(postGraduateStudentVO);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(postGraduateStudentVO));

	}

	/**
	 * 
	 * @throws Exception
	 * @通过id获取单条记录的详细信息
	 */
	public void getPostGraduateStudentById() throws Exception {
		List<StudentDTO> listStudent = new ArrayList<>();
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		stuDto = postGraduateStudentService.getPostGraduateStudentById(stuinfoStuBaseinfo.getStu_id());
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(stuDto));
	}

	/**
	 * 
	 * @throws Exception
	 * @通过id修改学生信息
	 */

	public void UpdatePostGraduateStudentById() throws Exception {
		postGraduateStudentService.updatePostGraduateStudentInfo(stuinfoStuBaseinfo);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");
	}

	/**
	 * 
	 * @throws Exception
	 * @通过id删除学生信息
	 */
	public void DeletePostGraduateStudent() throws Exception {
		postGraduateStudentService.DeletePostGraduateStudent(stuinfoStuBaseinfo.getStu_id());
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");

	}

	public PostGraduateStudentService getPostGraduateStudentService() {
		return postGraduateStudentService;
	}

	public void setPostGraduateStudentService(PostGraduateStudentService postGraduateStudentService) {
		this.postGraduateStudentService = postGraduateStudentService;
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

	public PostGraduateStudentVO getPostGraduateStudentVO() {
		return postGraduateStudentVO;
	}

	public void setPostGraduateStudentVO(PostGraduateStudentVO postGraduateStudentVO) {
		this.postGraduateStudentVO = postGraduateStudentVO;
	}

	public stuinfo_stubaseinfo getStuinfoStuBaseinfo() {
		return stuinfoStuBaseinfo;
	}

	public void setStuinfoStuBaseinfo(stuinfo_stubaseinfo stuinfoStuBaseinfo) {
		this.stuinfoStuBaseinfo = stuinfoStuBaseinfo;
	}

	public List<StudentDTO> getStuDto() {
		return stuDto;
	}

	public void setStuDto(List<StudentDTO> stuDto) {
		this.stuDto = stuDto;
	}

}
