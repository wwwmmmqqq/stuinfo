package com.stuinfo.domain.DO;

public class stuinfo_systemmanager {
	private String systemmanager_id;
	private String systemmanager_account;
	private String systemmanager_name;
	public String getSystemmanager_account() {
		return systemmanager_account;
	}
	public void setSystemmanager_account(String systemmanager_account) {
		this.systemmanager_account = systemmanager_account;
	}
	private String systemmanager_phonumber;
	private String systemmanager_infocreate;
	private String systemmanager__infomodified;
	
	
	@Override
	public String toString() {
		return "stuinfo_systemmanager [systemmanager_id=" + systemmanager_id + ", systemmanager_name="
				+ systemmanager_name + ", systemmanager_phonumber=" + systemmanager_phonumber
				+ ", systemmanager_infocreate=" + systemmanager_infocreate + ", systemmanager__infomodified="
				+ systemmanager__infomodified + "]";
	}
	public String getSystemmanager_id() {
		return systemmanager_id;
	}
	public void setSystemmanager_id(String systemmanager_id) {
		this.systemmanager_id = systemmanager_id;
	}
	public String getSystemmanager_name() {
		return systemmanager_name;
	}
	public void setSystemmanager_name(String systemmanager_name) {
		this.systemmanager_name = systemmanager_name;
	}
	public String getSystemmanager_phonumber() {
		return systemmanager_phonumber;
	}
	public void setSystemmanager_phonumber(String systemmanager_phonumber) {
		this.systemmanager_phonumber = systemmanager_phonumber;
	}
	public String getSystemmanager_infocreate() {
		return systemmanager_infocreate;
	}
	public void setSystemmanager_infocreate(String systemmanager_infocreate) {
		this.systemmanager_infocreate = systemmanager_infocreate;
	}
	public String getSystemmanager__infomodified() {
		return systemmanager__infomodified;
	}
	public void setSystemmanager__infomodified(String systemmanager__infomodified) {
		this.systemmanager__infomodified = systemmanager__infomodified;
	}
	

}
