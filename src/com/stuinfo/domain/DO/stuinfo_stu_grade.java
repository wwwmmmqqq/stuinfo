package com.stuinfo.domain.DO;

public class stuinfo_stu_grade {
	private String stu_grade_id;
	private String stu_grade_name;
	private String stu_grade_infocreate;
	private String stu_grade__infomodified;

	@Override
	public String toString() {
		return "stuinfo_stu_grade [stu_grade_id=" + stu_grade_id + ", stu_grade_name=" + stu_grade_name
				+ ", stu_grade_infocreate=" + stu_grade_infocreate + ", stu_grade__infomodified="
				+ stu_grade__infomodified + "]";
	}

	public String getStu_grade_id() {
		return stu_grade_id;
	}

	public void setStu_grade_id(String stu_grade_id) {
		this.stu_grade_id = stu_grade_id;
	}

	public String getStu_grade_name() {
		return stu_grade_name;
	}

	public void setStu_grade_name(String stu_grade_name) {
		this.stu_grade_name = stu_grade_name;
	}

	public String getStu_grade_infocreate() {
		return stu_grade_infocreate;
	}

	public void setStu_grade_infocreate(String stu_grade_infocreate) {
		this.stu_grade_infocreate = stu_grade_infocreate;
	}

	public String getStu_grade__infomodified() {
		return stu_grade__infomodified;
	}

	public void setStu_grade__infomodified(String stu_grade__infomodified) {
		this.stu_grade__infomodified = stu_grade__infomodified;
	}

}
