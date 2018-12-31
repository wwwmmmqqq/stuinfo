package com.stuinfo.domain.DO;

public class stuinfo_stu_major {
	private String major_id;
	private String major_name;
	private String major__infocreate;
	private String major___infomodified;

	@Override
	public String toString() {
		return "stuinfo_stu_major [major_id=" + major_id + ", major_name=" + major_name + ", major__infocreate="
				+ major__infocreate + ", major___infomodified=" + major___infomodified + "]";
	}

	public String getMajor_id() {
		return major_id;
	}

	public void setMajor_id(String major_id) {
		this.major_id = major_id;
	}

	public String getMajor_name() {
		return major_name;
	}

	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}

	public String getMajor__infocreate() {
		return major__infocreate;
	}

	public void setMajor__infocreate(String major__infocreate) {
		this.major__infocreate = major__infocreate;
	}

	public String getMajor___infomodified() {
		return major___infomodified;
	}

	public void setMajor___infomodified(String major___infomodified) {
		this.major___infomodified = major___infomodified;
	}

}
