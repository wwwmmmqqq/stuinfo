package com.stuinfo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.stuinfo.domain.DO.stuinfo_stu_onjob;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.JobStudentDTO;
import com.stuinfo.domain.VO.JobStudentVO;
import com.stuinfo.service.JobStudentService;

@SuppressWarnings("serial")
public class JobStudentAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private JobStudentService jobStudentService;
	private stuinfo_stubaseinfo stuinfoStuBaseinfo;
	private stuinfo_stu_onjob stuinfoStuOnJob;
	private JobStudentVO jobStudentVO;
	private List<JobStudentDTO> jobStudentDTO;
	private List<JobStudentDTO> detailJobStudentDTO;
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;

	public void listJobStudentByPageAndSearch() throws Exception {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		JobStudentDTO jobStudentDTO = (JobStudentDTO) ActionContext.getContext().getSession().get("jobStudentDTO");
		jobStudentVO = jobStudentService.VO_Job_Student_By_PageAndSearch(jobStudentVO);
		http_response.getWriter().write(gson.toJson(jobStudentVO));
	}

	public String jumpTodetail() throws Exception {
		return "detailJobStudent";
	}

	public String jumpToUpdate() throws Exception {
		return "updateJobStudent";
	}

	public String jumpToJobStudent() throws Exception {
		return "listJobStudent";
	}

	public String JumpToGradeAndClass() throws Exception {
		return "gradeAndClass";
	}

	public void getJobStuById() throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		detailJobStudentDTO = jobStudentService.getJobStdentById(stuinfoStuBaseinfo.getStu_id());
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(detailJobStudentDTO));
	}

	/**
	 * 
	 * @throws Exception
	 * @通过id修改学生信息
	 */

	public void UpdateJobStudentBaseInfo() throws Exception {
		jobStudentService.UpdateJobStudentBaseInfo(stuinfoStuBaseinfo);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");
	}

	public void UpdateJobStudentJobInfo() throws Exception {
		jobStudentService.UpdateJobStudentJobInfo(stuinfoStuOnJob);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");
	}

	/**
	 * 
	 * @throws Exception
	 * @通过id删除学生信息
	 */
	public void DeleteJobStudent() throws Exception {

		jobStudentService.deleteJobStudent(stuinfoStuBaseinfo.getStu_id());
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");

	}

	public void test() throws Exception {
		jobStudentService.a();
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

	public JobStudentService getJobStudentService() {
		return jobStudentService;
	}

	public void setJobStudentService(JobStudentService jobStudentService) {
		this.jobStudentService = jobStudentService;
	}

	public stuinfo_stubaseinfo getStuinfoStuBaseinfo() {
		return stuinfoStuBaseinfo;
	}

	public void setStuinfoStuBaseinfo(stuinfo_stubaseinfo stuinfoStuBaseinfo) {

		this.stuinfoStuBaseinfo = stuinfoStuBaseinfo;
	}

	public List<JobStudentDTO> getJobStudentDTO() {
		return jobStudentDTO;
	}

	public void setJobStudentDTO(List<JobStudentDTO> jobStudentDTO) {
		this.jobStudentDTO = jobStudentDTO;
	}

	public JobStudentVO getJobStudentVO() {
		return jobStudentVO;
	}

	public void setJobStudentVO(JobStudentVO jobStudentVO) {
		this.jobStudentVO = jobStudentVO;
	}

	public List<JobStudentDTO> getDetailJobStudentDTO() {
		return detailJobStudentDTO;
	}

	public void setDetailJobStudentDTO(List<JobStudentDTO> detailJobStudentDTO) {
		this.detailJobStudentDTO = detailJobStudentDTO;
	}

	public stuinfo_stu_onjob getStuinfoStuOnJob() {
		return stuinfoStuOnJob;
	}

	public void setStuinfoStuOnJob(stuinfo_stu_onjob stuinfoStuOnJob) {
		this.stuinfoStuOnJob = stuinfoStuOnJob;
	}

}
