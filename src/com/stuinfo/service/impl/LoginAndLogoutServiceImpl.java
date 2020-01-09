package com.stuinfo.service.impl;

import com.stuinfo.dao.LoginAndLogoutDao;
import com.stuinfo.domain.DO.stuinfo_ordinarymanager;
import com.stuinfo.domain.DO.stuinfo_teacherinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.service.LoginAndLogoutService;

import util.TeamUtil;
import util.md5;

public class LoginAndLogoutServiceImpl implements LoginAndLogoutService {
	private LoginAndLogoutDao loginAndLogoutDao;

	@Override
	public int login(String username, String password) {
		if (username == null || username.trim().length() <= 0) {
			return -1;
		}
		if (password == null || password.trim().length() <= 0) {
			return -2;
		}
		int flag = 0;
		StudentDTO studentDTO = new StudentDTO();
		/*
		 * stuinfo_stubaseinfo stuinfoStuBaseinfo = new stuinfo_stubaseinfo();
		 */
		stuinfo_teacherinfo stuinfo_teacherinfo = new stuinfo_teacherinfo();
		stuinfo_ordinarymanager stuinfo_ordinarymanager = new stuinfo_ordinarymanager();
		// 1.在stuinfo_stubaseinfo表中查询
		studentDTO = loginAndLogoutDao.getStudentUserByNum(username);
		// 如果在学生user表中查询得到
		if (studentDTO == null) {
			flag = -1;
		} else {
			if (studentDTO.getStuinfo_stubaseinfo().getStu_password().equals(md5.GetMD5Code(password))) {
				flag = 2;
				return flag;
			} else {
				flag = -2;
				return flag;
			}
		}
		// 2.在teacher_user表中查询
		stuinfo_teacherinfo = loginAndLogoutDao.getTeacherUserByNum(username);
		if (stuinfo_teacherinfo == null) {
			flag = -1;
		} else {
			if (stuinfo_teacherinfo.getTeacher_password().equals(md5.GetMD5Code(password))) {
				flag = 1;
				return flag;
			} else {
				flag = -2;
				return flag;
			}
		}
		// 3.在管理员账号中查询
		stuinfo_ordinarymanager = loginAndLogoutDao.getAdminByAccount(username);
		if (stuinfo_ordinarymanager == null) {
			flag = -1;
		} else {
			if (stuinfo_ordinarymanager.getOrdinarymanager_password().equals(md5.GetMD5Code(password))) {
				flag = 3;
				return flag;
			} else {
				flag = -2;
				return flag;
			}
		}
		return flag;
	}

	@Override
	public Object loginInformation(int role, String username) {
		// 如果等于1，则说明是教师进行登录
		if (role == 1) {

			stuinfo_teacherinfo stuinfoTeacherInfo = new stuinfo_teacherinfo();

			stuinfoTeacherInfo = loginAndLogoutDao.getTeacherUserByNum(username);
			return stuinfoTeacherInfo;
		} else if (role == 2) {
			// 则说明是学生登录
			StudentDTO studentDTO = new StudentDTO();
			studentDTO = loginAndLogoutDao.getStudentUserByNum(username);
			return studentDTO;
		} else if (role == 3) {
			// 则说明是管理员登录
			stuinfo_ordinarymanager stuinfoOrdinaryManager = new stuinfo_ordinarymanager();
			stuinfoOrdinaryManager = loginAndLogoutDao.getAdminByAccount(username);
			return stuinfoOrdinaryManager;
		}
		return null;
	}

	public LoginAndLogoutDao getLoginAndLogoutDao() {
		return loginAndLogoutDao;
	}

	public void setLoginAndLogoutDao(LoginAndLogoutDao loginAndLogoutDao) {
		this.loginAndLogoutDao = loginAndLogoutDao;
	}

	@Override
	public boolean save_NewStudent(stuinfo_ordinarymanager newStudent) {
		newStudent.setOrdinarymanager_id(TeamUtil.getUuid());
		newStudent.setOrdinarymanager_password(md5.GetMD5Code("000000"));
		loginAndLogoutDao.saveObj(newStudent);
		return true;

	}

}
