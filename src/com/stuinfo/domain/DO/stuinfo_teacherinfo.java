package com.stuinfo.domain.DO;

public class stuinfo_teacherinfo {
	private String teacher_id;
	private String teacher_account;
	private String teacher_password;
	private String teacher_name;
	private String teacher_phonumber;
	private String teacher_infomodified;
	private String teacher_infocreate;

	@Override
	public String toString() {
		return "stuinfo_teacherinfo [teacher_id=" + teacher_id + ", teacher_account=" + teacher_account
				+ ", teacher_password=" + teacher_password + ", teacher_name=" + teacher_name + ", teacher_phonumber="
				+ teacher_phonumber + ", teacher_infomodified=" + teacher_infomodified + ", teacher_infocreate="
				+ teacher_infocreate + "]";
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_account() {
		return teacher_account;
	}

	public void setTeacher_account(String teacher_account) {
		this.teacher_account = teacher_account;
	}

	public String getTeacher_password() {
		return teacher_password;
	}

	public void setTeacher_password(String teacher_password) {
		this.teacher_password = teacher_password;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_phonumber() {
		return teacher_phonumber;
	}

	public void setTeacher_phonumber(String teacher_phonumber) {
		this.teacher_phonumber = teacher_phonumber;
	}

	public String getTeacher_infomodified() {
		return teacher_infomodified;
	}

	public void setTeacher_infomodified(String teacher_infomodified) {
		this.teacher_infomodified = teacher_infomodified;
	}

	public String getTeacher_infocreate() {
		return teacher_infocreate;
	}

	public void setTeacher_infocreate(String teacher_infocreate) {
		this.teacher_infocreate = teacher_infocreate;
	}

}