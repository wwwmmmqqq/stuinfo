package com.stuinfo.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.StudentFiled;
import com.stuinfo.domain.VO.StudentInfoVO;
import com.stuinfo.service.StudentService;

@SuppressWarnings("serial")
public class StudentAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private StudentService studentService;
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;
	private StudentDTO stdo;
	/* private StudentInfoVO studentInfoVO; */
	private StudentFiled studentFiled;
	private InputStream inputStream; // 输出流变量
	private String excelFileName; // 下载文件名

	public String StuinfoExportToExcel() {
		StudentInfoVO<StudentDTO> studentPage;
		/**
		 * 得到字段
		 */
		if (studentFiled == null) {
			System.out.println("studentFiled==null");
		} else {
			// 得到字段
			System.out.println("studentFiled.name:" + studentFiled.getStu_name_field());
		}

		/**
		 * 得到记录
		 */

		if (studentFiled != null) {
			// 查询记录，封装到页面封装类中
			studentPage = studentService.findNoPage(stdo);

			// 将封装的页面记录存到值栈中
			ActionContext.getContext().getValueStack().push(stdo);
		} else {
			System.out.println("----------member==null----------");

			// 得到记录
			studentPage = studentService.findNoPage(stdo);
		}

		/**
		 * 写入文件
		 */

		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			/**
			 * 写
			 */
			studentService.writeStudentInformation(studentPage, studentFiled, wb);
			/**
			 * 写完毕
			 */
			// 第七步，将文件存到流中
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			wb.write(os);
			byte[] fileContent = os.toByteArray();
			ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
			inputStream = is; // 文件流
			excelFileName = "学生信息表.xls"; // 设置下载的文件名
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "stuinfoExportToExcel";
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

	public StudentDTO getStdo() {
		return stdo;
	}

	public void setStdo(StudentDTO stdo) {
		this.stdo = stdo;
	}

	public StudentFiled getStudentFiled() {
		return studentFiled;
	}

	public void setStudentFiled(StudentFiled studentFiled) {
		this.studentFiled = studentFiled;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
