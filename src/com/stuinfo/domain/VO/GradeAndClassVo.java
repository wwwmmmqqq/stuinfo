package com.stuinfo.domain.VO;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stu_class;
import com.stuinfo.domain.DO.stuinfo_stu_grade;

public class GradeAndClassVo {

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

	// 所有年级
	private List<stuinfo_stu_grade> listSstuinfoStuGrade;
	// 所有班级
	private List<stuinfo_stu_class> listSstuinfoStuClass;

	@Override
	public String toString() {
		return "GradeAndClassVo [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords + ", pageSize=" + pageSize
				+ ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage + ", HaveNextPage=" + HaveNextPage
				+ ", listSstuinfoStuGrade=" + listSstuinfoStuGrade + ", listSstuinfoStuClass=" + listSstuinfoStuClass
				+ "]";
	}

	public List<stuinfo_stu_class> getListSstuinfoStuClass() {
		return listSstuinfoStuClass;
	}

	public void setListSstuinfoStuClass(List<stuinfo_stu_class> listSstuinfoStuClass) {
		this.listSstuinfoStuClass = listSstuinfoStuClass;
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

	public List<stuinfo_stu_grade> getListSstuinfoStuGrade() {
		return listSstuinfoStuGrade;
	}

	public void setListSstuinfoStuGrade(List<stuinfo_stu_grade> listSstuinfoStuGrade) {
		this.listSstuinfoStuGrade = listSstuinfoStuGrade;
	}

}
