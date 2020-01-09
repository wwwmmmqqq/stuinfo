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
import com.stuinfo.domain.VO.StudentInfoVO;
import com.stuinfo.service.SchoolStudentService;

@SuppressWarnings("serial")
public class SchoolStudentAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private SchoolStudentService SchoolStudentService;
	private stuinfo_stubaseinfo stuinfoStuBaseinfo;
	private List<StudentDTO> stuDto;
	private StudentInfoVO studentInfoVO;

	public List<StudentDTO> getStuDto() {
		return stuDto;
	}

	public void setStuDto(List<StudentDTO> stuDto) {
		this.stuDto = stuDto;
	}

	/*
	 * public StudentInfoVO getStudentInfoVO() { return studentInfoVO; }
	 * 
	 * public void setStudentInfoVO(StudentInfoVO studentInfoVO) {
	 * this.studentInfoVO = studentInfoVO; }
	 */
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;

	/**
	 * 
	 * @throws Exception
	 * @说明获取所有在校学生
	 */
	public void listStudentAll() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		List<StudentDTO> list_Student = SchoolStudentService.listSchoolStudentAll();
		http_response.getWriter().write(gson.toJson(list_Student));
	}

	/*
	 * 将获取到的所有在校学生进行分页
	 *
	 */
	/*
	 * public void listSchoolStudentByPageAndSearch() throws Exception {
	 * GsonBuilder gsonBuilder = new GsonBuilder();
	 * gsonBuilder.setPrettyPrinting();// 格式化json数据 Gson gson =
	 * gsonBuilder.create();
	 * http_response.setContentType("text/html;charset=utf-8"); StudentDTO
	 * studentDTO = (StudentDTO)
	 * ActionContext.getContext().getSession().get("studentDTO"); studentInfoVO
	 * = SchoolStudentService.VO_Student_By_PageAndSearch(studentInfoVO);
	 * http_response.setContentType("text/html;charset=utf-8");
	 * http_response.getWriter().write(gson.toJson(studentInfoVO)); }
	 */

	public void listSchoolStudentByPage() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		StudentDTO studentDTO = (StudentDTO) ActionContext.getContext().getSession().get("studentDTO");
		studentInfoVO = SchoolStudentService.VO_Student_By_Page(studentInfoVO);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(studentInfoVO));
	}

	public void listSchoolStudentByPageAndSearch() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		StudentDTO studentDTO = (StudentDTO) ActionContext.getContext().getSession().get("studentDTO");
		studentInfoVO = SchoolStudentService.VO_Student_By_PageAndSearch(studentInfoVO);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(studentInfoVO));
	}

	public void test() throws Exception {
		SchoolStudentService.VO_Student_By_PageAndSearch(studentInfoVO);
	}

	/**
	 * 
	 * @throws Exception
	 * @通过id获取单条记录的详细信息
	 */
	public void getSchoolStuById() throws Exception {
		List<StudentDTO> listStudent = new ArrayList<>();
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		stuDto = SchoolStudentService.getSchoolStdentById(stuinfoStuBaseinfo.getStu_id());
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(stuDto));
	}

	/**
	 * 
	 * @throws Exception
	 * @通过id修改学生信息
	 */

	public void updateSchoolStuById() throws Exception {
		SchoolStudentService.updateStuInfo(stuinfoStuBaseinfo);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");
	}

	/**
	 * 
	 * @throws Exception
	 * @通过id删除学生信息
	 */
	public void deleteSchoolStuById() throws Exception {
		SchoolStudentService.deleteSchoolStudentById(stuinfoStuBaseinfo.getStu_id());
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");

	}

	public StudentInfoVO getStudentInfoVO() {
		return studentInfoVO;
	}

	public void setStudentInfoVO(StudentInfoVO studentInfoVO) {
		this.studentInfoVO = studentInfoVO;
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

	public stuinfo_stubaseinfo getStuinfoStuBaseinfo() {
		return stuinfoStuBaseinfo;
	}

	public void setStuinfoStuBaseinfo(stuinfo_stubaseinfo stuinfoStuBaseinfo) {
		this.stuinfoStuBaseinfo = stuinfoStuBaseinfo;
	}

}
