package com.stuinfo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.stuinfo.domain.DO.stuinfo_notice;
import com.stuinfo.domain.DO.stuinfo_ordinarymanager;
import com.stuinfo.domain.DO.stuinfo_stu_onjob;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DO.stuinfo_teacherinfo;
import com.stuinfo.domain.DTO.JobStudentDTO;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.service.LoginAndLogoutService;
import com.stuinfo.service.ManagerService;
import com.stuinfo.service.StudentService;

@SuppressWarnings("serial")
public class LoginAndLogoutAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private LoginAndLogoutService loginAndLogoutService;
	private StudentService studentService;
	private ManagerService managerService;
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;
	private stuinfo_ordinarymanager newStudent;
	private stuinfo_stu_onjob stuinfoStuOnjob;
	private stuinfo_stubaseinfo stuinfoStuBaseinfo;
	private StudentDTO studentDTO;
	private stuinfo_notice stuinfoNotice;
	public List<stuinfo_stubaseinfo> stuinfo_stubaseinfo;
	private JobStudentDTO jobStudentDTO;
	private String username;
	private String password;

	private String newPassword;
	private String oldPassword;
	private String titles[] = null;

	/*
	 * 登录
	 */
	public void login() throws IOException {
		http_response.setContentType("text/html;charset=utf-8");
		switch (loginAndLogoutService.login(username, password)) {
		case -1: {
			http_response.getWriter().write("账号不存在");
			break;
		}
		case -2: {
			http_response.getWriter().write("密码不正确");
			break;
		}
		// 教师登录
		case 1: {
			stuinfo_teacherinfo stuinfoTeacherinfo = (stuinfo_teacherinfo) loginAndLogoutService.loginInformation(1,
					username);
			ActionContext.getContext().getSession().put("stuinfoTeacherinfo", stuinfoTeacherinfo);
			http_response.getWriter().write("教师登录成功");
			break;
		}
		// 学生登录
		case 2: {
			studentDTO = (StudentDTO) loginAndLogoutService.loginInformation(2, username);
			ActionContext.getContext().getSession().put("studentDTO", studentDTO);
			http_response.getWriter().write("学生登录成功");
			break;

		}
		// 管理员登录
		case 3: {

			stuinfo_ordinarymanager stuinfoOrdinaryManager = (stuinfo_ordinarymanager) loginAndLogoutService
					.loginInformation(3, username);
			ActionContext.getContext().getSession().put("admin", stuinfoOrdinaryManager);
			http_response.getWriter().write("管理员登录成功");
			break;

		}
		default:
			break;

		}

	}

	// 退出登录
	public String logout() {
		if (ActionContext.getContext().getSession().get("studentDTO") != null) {
			ActionContext.getContext().getSession().remove("studentDTO");
		} else if (ActionContext.getContext().getSession().get("admin") != null) {
			ActionContext.getContext().getSession().remove("admin");
		}
		return "logout";
	}

	public void getUserSessionForAjax() throws IOException {
		http_response.setContentType("text/html;charset=utf-8");
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		if (ActionContext.getContext().getSession().get("stuinfoTeacherinfo") != null) {
			http_response.getWriter()
					.write(gson.toJson(ActionContext.getContext().getSession().get("stuinfoTeacherinfo")));
		} else if (ActionContext.getContext().getSession().get("studentDTO") != null) {
			http_response.getWriter().write(gson.toJson(ActionContext.getContext().getSession().get("studentDTO")));
		} else if (ActionContext.getContext().getSession().get("admin") != null) {
			http_response.getWriter().write(gson.toJson(ActionContext.getContext().getSession().get("admin")));
		}
	}

	// 修改密码
	public void UpdatePassword() throws IOException {
		http_response.setContentType("text/html;charset=utf-8");
		if (ActionContext.getContext().getSession().get("studentDTO") != null) {
			studentService.UpdatePassword(((StudentDTO) ActionContext.getContext().getSession().get("studentDTO"))
					.getStuinfoStuBaseinfo().getStu_id(), newPassword);
			http_response.getWriter().write("success");
		} else if (ActionContext.getContext().getSession().get("admin") != null) {
			managerService
					.UpdatePassword(((stuinfo_ordinarymanager) ActionContext.getContext().getSession().get("admin"))
							.getOrdinarymanager_id(), newPassword);
			http_response.getWriter().write("success");
		}
	}

	public void TestSession() throws IOException {
		http_response.setContentType("text/html;charset=utf-8");
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		System.out.println(ActionContext.getContext().getSession().get("stuinfoStuBaseinfo"));
	}

	// 学生添加就业信息
	public void StudentAddJobInfo() throws IOException {
		http_response.setContentType("text/html;charset=utf-8");
		if (ActionContext.getContext().getSession().get("studentDTO") != null) {
			studentService.StudentAddJobInfo(((StudentDTO) ActionContext.getContext().getSession().get("studentDTO"))
					.getStuinfo_stubaseinfo().getStu_id(), stuinfoStuOnjob);
			studentService.addNotice((StudentDTO) ActionContext.getContext().getSession().get("studentDTO"),
					stuinfoNotice);
			http_response.getWriter().write("success");
		}

	}

	// 通过stu_id获取该stu_id下的所有工作记录
	public void GetJobRecodeById() throws IOException {
		http_response.setContentType("text/html;charset=utf-8");
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		if (ActionContext.getContext().getSession().get("studentDTO") != null) {
			stuinfo_stubaseinfo = studentService
					.GetJobRecodeById(((StudentDTO) ActionContext.getContext().getSession().get("studentDTO"))
							.getStuinfoStuBaseinfo().getStu_id());
		}
		http_response.getWriter().write(gson.toJson(stuinfo_stubaseinfo));
	}

	// 密码生成测试登录用
	public void testPassword() throws IOException {

		if (loginAndLogoutService.save_NewStudent(newStudent)) {
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("success");
		} else {
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("failture");
		}

	}

	public void test() throws IOException {
		for (int i = 0; i < titles.length; i++) {
			System.out.println(titles[i]);
		}

	}

	public String JumpToStudent() throws IOException {
		return "student";
	}

	public stuinfo_ordinarymanager getNewStudent() {
		return newStudent;
	}

	public void setNewStudent(stuinfo_ordinarymanager newStudent) {
		this.newStudent = newStudent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginAndLogoutService getLoginAndLogoutService() {
		return loginAndLogoutService;
	}

	public void setLoginAndLogoutService(LoginAndLogoutService loginAndLogoutService) {
		this.loginAndLogoutService = loginAndLogoutService;
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

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public stuinfo_stu_onjob getStuinfoStuOnjob() {
		return stuinfoStuOnjob;
	}

	public void setStuinfoStuOnjob(stuinfo_stu_onjob stuinfoStuOnjob) {
		this.stuinfoStuOnjob = stuinfoStuOnjob;
	}

	public stuinfo_stubaseinfo getStuinfoStuBaseinfo() {
		return stuinfoStuBaseinfo;
	}

	public void setStuinfoStuBaseinfo(stuinfo_stubaseinfo stuinfoStuBaseinfo) {
		this.stuinfoStuBaseinfo = stuinfoStuBaseinfo;
	}

	public JobStudentDTO getJobStudentDTO() {
		return jobStudentDTO;
	}

	public void setJobStudentDTO(JobStudentDTO jobStudentDTO) {
		this.jobStudentDTO = jobStudentDTO;
	}

	public List<stuinfo_stubaseinfo> getStuinfo_stubaseinfo() {
		return stuinfo_stubaseinfo;
	}

	public void setStuinfo_stubaseinfo(List<stuinfo_stubaseinfo> stuinfo_stubaseinfo) {
		this.stuinfo_stubaseinfo = stuinfo_stubaseinfo;
	}

	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	public stuinfo_notice getStuinfoNotice() {
		return stuinfoNotice;
	}

	public void setStuinfoNotice(stuinfo_notice stuinfoNotice) {
		this.stuinfoNotice = stuinfoNotice;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

}
