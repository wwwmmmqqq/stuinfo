package com.stuinfo.domain.DO;

public class stuinfo_notice {
	public String notice_id;
	public String notice_content;
	public String notice_stu_grade;
	public String notice_stu_major;
	public String notice_stu_class;
	public String notice_stu_account;
	public String notice_stu_name;
	public String notice_status;
	public String notice_infocreate;
	public String notice_infomodified;

	@Override
	public String toString() {
		return "stuinfo_notice [notice_id=" + notice_id + ", notice_content=" + notice_content + ", notice_stu_grade="
				+ notice_stu_grade + ", notice_stu_major=" + notice_stu_major + ", notice_stu_class=" + notice_stu_class
				+ ", notice_stu_account=" + notice_stu_account + ", notice_stu_name=" + notice_stu_name
				+ ", notice_status=" + notice_status + ", notice_infocreate=" + notice_infocreate
				+ ", notice_infomodified=" + notice_infomodified + "]";
	}

	public String getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public String getNotice_infocreate() {
		return notice_infocreate;
	}

	public void setNotice_infocreate(String notice_infocreate) {
		this.notice_infocreate = notice_infocreate;
	}

	public String getNotice_infomodified() {
		return notice_infomodified;
	}

	public void setNotice_infomodified(String notice_infomodified) {
		this.notice_infomodified = notice_infomodified;
	}

	public String getNotice_status() {
		return notice_status;
	}

	public void setNotice_status(String notice_status) {
		this.notice_status = notice_status;
	}

	public String getNotice_stu_grade() {
		return notice_stu_grade;
	}

	public void setNotice_stu_grade(String notice_stu_grade) {
		this.notice_stu_grade = notice_stu_grade;
	}

	public String getNotice_stu_major() {
		return notice_stu_major;
	}

	public void setNotice_stu_major(String notice_stu_major) {
		this.notice_stu_major = notice_stu_major;
	}

	public String getNotice_stu_class() {
		return notice_stu_class;
	}

	public void setNotice_stu_class(String notice_stu_class) {
		this.notice_stu_class = notice_stu_class;
	}

	public String getNotice_stu_account() {
		return notice_stu_account;
	}

	public void setNotice_stu_account(String notice_stu_account) {
		this.notice_stu_account = notice_stu_account;
	}

	public String getNotice_stu_name() {
		return notice_stu_name;
	}

	public void setNotice_stu_name(String notice_stu_name) {
		this.notice_stu_name = notice_stu_name;
	}

}
