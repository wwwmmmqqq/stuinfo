package com.stuinfo.domain.DO;

public class stuinfo_stu_class {
	public String stu_class_id;
	public String stu_class_name;
	public String stu_grade_id;
	public String stu_class_infocreate;
	public String stu_class__infomodified;

	@Override
	public String toString() {
		return "stuinfo_stu_class [stu_class_id=" + stu_class_id + ", stu_class_name=" + stu_class_name
				+ ", stu_grade_id=" + stu_grade_id + ", stu_class_infocreate=" + stu_class_infocreate
				+ ", stu_class__infomodified=" + stu_class__infomodified + "]";
	}

	public String getStu_class_id() {
		return stu_class_id;
	}

	public void setStu_class_id(String stu_class_id) {
		this.stu_class_id = stu_class_id;
	}

	public String getStu_class_infocreate() {
		return stu_class_infocreate;
	}

	public void setStu_class_infocreate(String stu_class_infocreate) {
		this.stu_class_infocreate = stu_class_infocreate;
	}

	public String getStu_class__infomodified() {
		return stu_class__infomodified;
	}

	public void setStu_class__infomodified(String stu_class__infomodified) {
		this.stu_class__infomodified = stu_class__infomodified;
	}

	public String getStu_grade_id() {
		return stu_grade_id;
	}

	public void setStu_grade_id(String stu_grade_id) {
		this.stu_grade_id = stu_grade_id;
	}

	public String getStu_class_name() {
		return stu_class_name;
	}

	public void setStu_class_name(String stu_class_name) {
		this.stu_class_name = stu_class_name;
	}

}
