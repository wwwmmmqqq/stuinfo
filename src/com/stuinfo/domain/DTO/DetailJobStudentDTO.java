package com.stuinfo.domain.DTO;

import com.stuinfo.domain.DO.stuinfo_stu_class;
import com.stuinfo.domain.DO.stuinfo_stu_grade;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;

public class DetailJobStudentDTO {
	private stuinfo_stubaseinfo stuinfoStuBaseinfo;
	private stuinfo_stu_grade stuinfoStuGrade;
	private stuinfo_stu_class stuinfoStuClass;

	public DetailJobStudentDTO() {
		super();
	}

	public DetailJobStudentDTO(stuinfo_stubaseinfo stuinfoStuBaseinfo, stuinfo_stu_grade stuinfoStuGrade,
			stuinfo_stu_class stuinfoStuClass) {
		super();
		this.stuinfoStuBaseinfo = stuinfoStuBaseinfo;
		this.stuinfoStuGrade = stuinfoStuGrade;
		this.stuinfoStuClass = stuinfoStuClass;
	}

	@Override
	public String toString() {
		return "DetailJobStudentDTO [stuinfoStuBaseinfo=" + stuinfoStuBaseinfo + ", stuinfoStuGrade=" + stuinfoStuGrade
				+ ", stuinfoStuClass=" + stuinfoStuClass + "]";
	}

	public stuinfo_stubaseinfo getStuinfoStuBaseinfo() {
		return stuinfoStuBaseinfo;
	}

	public void setStuinfoStuBaseinfo(stuinfo_stubaseinfo stuinfoStuBaseinfo) {
		this.stuinfoStuBaseinfo = stuinfoStuBaseinfo;
	}

	public stuinfo_stu_grade getStuinfoStuGrade() {
		return stuinfoStuGrade;
	}

	public void setStuinfoStuGrade(stuinfo_stu_grade stuinfoStuGrade) {
		this.stuinfoStuGrade = stuinfoStuGrade;
	}

	public stuinfo_stu_class getStuinfoStuClass() {
		return stuinfoStuClass;
	}

	public void setStuinfoStuClass(stuinfo_stu_class stuinfoStuClass) {
		this.stuinfoStuClass = stuinfoStuClass;
	}

}
