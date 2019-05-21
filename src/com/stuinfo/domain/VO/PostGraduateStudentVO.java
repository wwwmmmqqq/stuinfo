package com.stuinfo.domain.VO;

import java.util.List;

import com.stuinfo.domain.DTO.JobStudentDTO;
import com.stuinfo.domain.DTO.StudentDTO;

public class PostGraduateStudentVO {

	// 当前页
	private int pageIndex = 1;

	// 总记录数
	private int totalRecords = 0;

	// 每页显示记录数
	private int pageSize = 10;

	// 总页数
	private int totalPages = 1;

	// 是否有上一页
	private boolean HavePrePage = false;

	// 是否有下一页
	private boolean HaveNextPage = false;

	// 所有在校学生信息
	private List<StudentDTO> StudentDTO;// 与当前页和每一页的记录数有关

	// 所有在职学生信息
	private List<JobStudentDTO> jobStudentDTO;

	@Override
	public String toString() {
		return "StudentInfoVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords + ", pageSize=" + pageSize
				+ ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage + ", HaveNextPage=" + HaveNextPage
				+ ", StudentDTO=" + StudentDTO + ", JobStudentDTO=" + jobStudentDTO + "]";
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isHavePrePage() {
		return HavePrePage;
	}

	public void setHavePrePage(boolean havePrePage) {
		HavePrePage = havePrePage;
	}

	public boolean isHaveNextPage() {
		return HaveNextPage;
	}

	public void setHaveNextPage(boolean haveNextPage) {
		HaveNextPage = haveNextPage;
	}

	public List<StudentDTO> getStudentDTO() {
		return StudentDTO;
	}

	public void setStudentDTO(List<StudentDTO> studentDTO) {
		StudentDTO = studentDTO;
	}

	public List<JobStudentDTO> getJobStudentDTO() {
		return jobStudentDTO;
	}

	public void setJobStudentDTO(List<JobStudentDTO> jobStudentDTO) {
		this.jobStudentDTO = jobStudentDTO;
	}

}
