package com.stuinfo.domain.DO;

public class stuinfo_ordinarymanager {
private String	ordinarymanager_id;
private String	ordinarymanager_account;
private String	ordinarymanager_password;
private String	ordinarymanager_name;
private String	ordinarymanager_infocreate;
private String	ordinarymanager__infomodified;


@Override
public String toString() {
	return "stuinfo_ordinarymanager [ordinarymanager_id=" + ordinarymanager_id + ", ordinarymanager_account="
			+ ordinarymanager_account + ", ordinarymanager_password=" + ordinarymanager_password
			+ ", ordinarymanager_name=" + ordinarymanager_name + ", ordinarymanager_infocreate="
			+ ordinarymanager_infocreate + ", ordinarymanager__infomodified=" + ordinarymanager__infomodified + "]";
}
public String getOrdinarymanager_id() {
	return ordinarymanager_id;
}
public void setOrdinarymanager_id(String ordinarymanager_id) {
	this.ordinarymanager_id = ordinarymanager_id;
}
public String getOrdinarymanager_account() {
	return ordinarymanager_account;
}
public void setOrdinarymanager_account(String ordinarymanager_account) {
	this.ordinarymanager_account = ordinarymanager_account;
}
public String getOrdinarymanager_password() {
	return ordinarymanager_password;
}
public void setOrdinarymanager_password(String ordinarymanager_password) {
	this.ordinarymanager_password = ordinarymanager_password;
}
public String getOrdinarymanager_name() {
	return ordinarymanager_name;
}
public void setOrdinarymanager_name(String ordinarymanager_name) {
	this.ordinarymanager_name = ordinarymanager_name;
}
public String getOrdinarymanager_infocreate() {
	return ordinarymanager_infocreate;
}
public void setOrdinarymanager_infocreate(String ordinarymanager_infocreate) {
	this.ordinarymanager_infocreate = ordinarymanager_infocreate;
}
public String getOrdinarymanager__infomodified() {
	return ordinarymanager__infomodified;
}
public void setOrdinarymanager__infomodified(String ordinarymanager__infomodified) {
	this.ordinarymanager__infomodified = ordinarymanager__infomodified;
}

}
