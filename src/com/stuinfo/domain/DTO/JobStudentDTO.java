package com.stuinfo.domain.DTO;

import com.stuinfo.domain.DO.stuinfo_stu_class;
import com.stuinfo.domain.DO.stuinfo_stu_grade;
import com.stuinfo.domain.DO.stuinfo_stu_onjob;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;

public class JobStudentDTO {
	private stuinfo_stubaseinfo stuinfoStuBaseinfo;
	private stuinfo_stu_grade stuinfoStuGrade;
	private stuinfo_stu_class stuinfoStuClass;
	private stuinfo_stu_onjob stuinfoStuOnJob;

	public JobStudentDTO() {
		super();
	}

	public JobStudentDTO(stuinfo_stubaseinfo stuinfoStuBaseinfo, stuinfo_stu_grade stuinfoStuGrade,
			stuinfo_stu_class stuinfoStuClass, stuinfo_stu_onjob stuinfoStuOnJob) {
		super();
		this.stuinfoStuBaseinfo = stuinfoStuBaseinfo;
		this.stuinfoStuGrade = stuinfoStuGrade;
		this.stuinfoStuClass = stuinfoStuClass;
		this.stuinfoStuOnJob = stuinfoStuOnJob;
	}

	@Override
	public String toString() {
		return "JobStudentDTO [stuinfoStuBaseinfo=" + stuinfoStuBaseinfo + ", stuinfoStuGrade=" + stuinfoStuGrade
				+ ", stuinfoStuClass=" + stuinfoStuClass + ", stuinfoStuOnJob=" + stuinfoStuOnJob + "]";
	}

	public stuinfo_stubaseinfo getStuinfoStuBaseinfo() {
		return stuinfoStuBaseinfo;
	}

	public void setStuinfoStuBaseinfo(stuinfo_stubaseinfo stuinfoStuBaseinfo) {
		this.stuinfoStuBaseinfo = stuinfoStuBaseinfo;
	}

	public stuinfo_stu_onjob getStuinfoStuOnJob() {
		return stuinfoStuOnJob;
	}

	public void setStuinfoStuOnJob(stuinfo_stu_onjob stuinfoStuOnJob) {
		this.stuinfoStuOnJob = stuinfoStuOnJob;
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
