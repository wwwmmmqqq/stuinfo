package com.stuinfo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.opensymphony.xwork2.ActionSupport;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.StudentFiled;
import com.stuinfo.service.StudentService;

import util.md5;

@SuppressWarnings("serial")
public class StudentAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private StudentService studentService;
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;
	private StudentDTO stdo;
	/* private StudentInfoVO studentInfoVO; */
	private List<StudentFiled> studentFiled;
	private InputStream inputStream; // 输出流变量
	private String excelFileName; // 下载文件名

	private File file;
	private String fileFileName;
	private String fileContentType;

	public void importToDB() {
		try {
			FileInputStream is = new FileInputStream(file);
			Class clazz = stuinfo_stubaseinfo.class;
			List<Object> list = EasyExcelFactory.read(is, new Sheet(1, 1, clazz));
			for (Object object : list) {
				stuinfo_stubaseinfo stubaseinfo = (stuinfo_stubaseinfo) object;
				stubaseinfo.setStu_id(UUID.randomUUID().toString());
				stubaseinfo.setStu_password(md5.GetMD5Code("000000"));
			}
			studentService.insertInfoToDB(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void exportToExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletOutputStream out = response.getOutputStream();
		response.setContentType("multipart/form-data");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-disposition", "attachment;filename=export.xlsx");
		ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
		try {
			String fileName = new String(
					("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Sheet sheet1 = new Sheet(1, 0);
		sheet1.setSheetName("第一个sheet");
		writer.write0(studentService.getListString(studentFiled), sheet1);
		writer.finish();

		out.flush();
	}

	public void StuinfoExportToExcel() {

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

	public List<StudentFiled> getStudentFiled() {
		return studentFiled;
	}

	public void setStudentFiled(List<StudentFiled> studentFiled) {
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
