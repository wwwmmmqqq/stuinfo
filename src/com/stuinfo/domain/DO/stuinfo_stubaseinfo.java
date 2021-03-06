package com.stuinfo.domain.DO;

import com.alibaba.excel.annotation.ExcelProperty;

public class stuinfo_stubaseinfo {

	private String stu_id;
	@ExcelProperty(index = 0)
	private String stu_account;
	private String stu_password;
	@ExcelProperty(index = 1)
	private String stu_name;
	@ExcelProperty(index = 2)
	private String stu_sex;
	@ExcelProperty(index = 3)
	private String stu_adress;
	@ExcelProperty(index = 4)
	private String stu_bir;
	private String stu_photo;
	@ExcelProperty(index = 5)
	private String stu_familytype;
	@ExcelProperty(index = 6)
	private String stu_nation;
	@ExcelProperty(index = 7)
	private String stu_policits;
	@ExcelProperty(index = 8)
	private String stu_idcard;
	@ExcelProperty(index = 9)
	private String stu_phenumber;
	@ExcelProperty(index = 10)
	private String stu_fathername;
	@ExcelProperty(index = 11)
	private String stu_fathernum;
	@ExcelProperty(index = 12)
	private String stu_mothername;
	@ExcelProperty(index = 13)
	private String stu_mothernum;
	@ExcelProperty(index = 14)
	private String stu_lev;
	@ExcelProperty(index = 15)
	private String stu_change;
	@ExcelProperty(index = 16)
	private String stu_college;
	@ExcelProperty(index = 17)
	private String stu_const;
	@ExcelProperty(index = 18)
	private String stu_major;
	private String stu_class_id;
	@ExcelProperty(index = 19)
	private String stu_year;
	@ExcelProperty(index = 20)
	private String stu_status;
	private String stu_infocreate;
	private String stu_infomodified;

	@Override
	public String toString() {
		return "stuinfo_stubaseinfo [stu_id=" + stu_id + ", stu_account=" + stu_account + ", stu_password="
				+ stu_password + ", stu_name=" + stu_name + ", stu_sex=" + stu_sex + ", stu_adress=" + stu_adress
				+ ", stu_bir=" + stu_bir + ", stu_photo=" + stu_photo + ", stu_familytype=" + stu_familytype
				+ ", stu_nation=" + stu_nation + ", stu_policits=" + stu_policits + ", stu_idcard=" + stu_idcard
				+ ", stu_phenumber=" + stu_phenumber + ", stu_fathername=" + stu_fathername + ", stu_fathernum="
				+ stu_fathernum + ", stu_mothername=" + stu_mothername + ", stu_mothernum=" + stu_mothernum
				+ ", stu_lev=" + stu_lev + ", stu_change=" + stu_change + ", stu_college=" + stu_college
				+ ", stu_const=" + stu_const + ", stu_major=" + stu_major + ", stu_class_id=" + stu_class_id
				+ ", stu_year=" + stu_year + ", stu_status=" + stu_status + ", stu_infocreate=" + stu_infocreate
				+ ", stu_infomodified=" + stu_infomodified + "]";
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_account() {
		return stu_account;
	}

	public void setStu_account(String stu_account) {
		this.stu_account = stu_account;
	}

	public String getStu_password() {
		return stu_password;
	}

	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public String getStu_adress() {
		return stu_adress;
	}

	public void setStu_adress(String stu_adress) {
		this.stu_adress = stu_adress;
	}

	public String getStu_bir() {
		return stu_bir;
	}

	public void setStu_bir(String stu_bir) {
		this.stu_bir = stu_bir;
	}

	public String getStu_photo() {
		return stu_photo;
	}

	public void setStu_photo(String stu_photo) {
		this.stu_photo = stu_photo;
	}

	public String getStu_familytype() {
		return stu_familytype;
	}

	public void setStu_familytype(String stu_familytype) {
		this.stu_familytype = stu_familytype;
	}

	public String getStu_nation() {
		return stu_nation;
	}

	public void setStu_nation(String stu_nation) {
		this.stu_nation = stu_nation;
	}

	public String getStu_policits() {
		return stu_policits;
	}

	public void setStu_policits(String stu_policits) {
		this.stu_policits = stu_policits;
	}

	public String getStu_idcard() {
		return stu_idcard;
	}

	public void setStu_idcard(String stu_idcard) {
		this.stu_idcard = stu_idcard;
	}

	public String getStu_phenumber() {
		return stu_phenumber;
	}

	public void setStu_phenumber(String stu_phenumber) {
		this.stu_phenumber = stu_phenumber;
	}

	public String getStu_fathername() {
		return stu_fathername;
	}

	public void setStu_fathername(String stu_fathername) {
		this.stu_fathername = stu_fathername;
	}

	public String getStu_fathernum() {
		return stu_fathernum;
	}

	public void setStu_fathernum(String stu_fathernum) {
		this.stu_fathernum = stu_fathernum;
	}

	public String getStu_mothername() {
		return stu_mothername;
	}

	public void setStu_mothername(String stu_mothername) {
		this.stu_mothername = stu_mothername;
	}

	public String getStu_mothernum() {
		return stu_mothernum;
	}

	public void setStu_mothernum(String stu_mothernum) {
		this.stu_mothernum = stu_mothernum;
	}

	public String getStu_lev() {
		return stu_lev;
	}

	public void setStu_lev(String stu_lev) {
		this.stu_lev = stu_lev;
	}

	public String getStu_change() {
		return stu_change;
	}

	public void setStu_change(String stu_change) {
		this.stu_change = stu_change;
	}

	public String getStu_college() {
		return stu_college;
	}

	public void setStu_college(String stu_college) {
		this.stu_college = stu_college;
	}

	public String getStu_const() {
		return stu_const;
	}

	public void setStu_const(String stu_const) {
		this.stu_const = stu_const;
	}

	public String getStu_major() {
		return stu_major;
	}

	public void setStu_major(String stu_major) {
		this.stu_major = stu_major;
	}

	public String getStu_class_id() {
		return stu_class_id;
	}

	public void setStu_class_id(String stu_class_id) {
		this.stu_class_id = stu_class_id;
	}

	public String getStu_year() {
		return stu_year;
	}

	public void setStu_year(String stu_year) {
		this.stu_year = stu_year;
	}

	public String getStu_status() {
		return stu_status;
	}

	public void setStu_status(String stu_status) {
		this.stu_status = stu_status;
	}

	public String getStu_infocreate() {
		return stu_infocreate;
	}

	public void setStu_infocreate(String stu_infocreate) {
		this.stu_infocreate = stu_infocreate;
	}

	public String getStu_infomodified() {
		return stu_infomodified;
	}

	public void setStu_infomodified(String stu_infomodified) {
		this.stu_infomodified = stu_infomodified;
	}

}