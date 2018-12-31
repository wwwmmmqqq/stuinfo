package com.stuinfo.domain.DTO;

import com.stuinfo.domain.DO.stuinfo_stu_class;
import com.stuinfo.domain.DO.stuinfo_stu_grade;

public class ClassAndGradeDTO {
	private stuinfo_stu_grade stuinfoStuGrade;
	private stuinfo_stu_class stuinfoStuClass;

	public ClassAndGradeDTO() {
		super();
	}

	public ClassAndGradeDTO(stuinfo_stu_grade stuinfoStuGrade, stuinfo_stu_class stuinfoStuClass) {
		super();
		this.stuinfoStuGrade = stuinfoStuGrade;
		this.stuinfoStuClass = stuinfoStuClass;
	}

	@Override
	public String toString() {
		return "ClassAndGradeDTO [stuinfoStuGrade=" + stuinfoStuGrade + ", stuinfoStuClass=" + stuinfoStuClass + "]";
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