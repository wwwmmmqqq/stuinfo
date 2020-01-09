package com.stuinfo.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stuinfo.dao.LoginAndLogoutDao;
import com.stuinfo.domain.DO.stuinfo_ordinarymanager;
import com.stuinfo.domain.DO.stuinfo_teacherinfo;
import com.stuinfo.domain.DTO.StudentDTO;

public class LoginAndLogoutDaoImpl implements LoginAndLogoutDao {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 根据学号得到学生信息
	@Override
	public StudentDTO getStudentUserByNum(String username) {
		StudentDTO studentDTO = new StudentDTO();
		Session session = getSession();
		/*
		 * String hql = "from stuinfo_stubaseinfo where stu_account='" +
		 * username + "'";
		 */

		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," //
				+ "stuinfo_stu_grade stuinfoStuGrade ," //
				+ " stuinfo_stu_class stuinfoStuClass "//
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id and stuinfoStuBaseinfo.stu_status='1' and stuinfoStuBaseinfo.stu_account='"
				+ username + "'";

		Query query = session.createQuery(hql);
		studentDTO = (StudentDTO) query.uniqueResult();
		session.clear();
		return studentDTO;
	}

	// 根据教师账号得到教师信息
	@Override
	public stuinfo_teacherinfo getTeacherUserByNum(String username) {
		Session session = getSession();
		String hql = "from stuinfo_teacherinfo where teacher_account='" + username + "'";
		stuinfo_teacherinfo stuinfo_teacherinfo = new stuinfo_teacherinfo();
		Query query = session.createQuery(hql);
		stuinfo_teacherinfo = (stuinfo_teacherinfo) query.uniqueResult();
		session.clear();
		return stuinfo_teacherinfo;
	}

	// 根据管理员账号得到管理员信息
	@Override
	public stuinfo_ordinarymanager getAdminByAccount(String username) {
		Session session = getSession();
		String hql = "from stuinfo_ordinarymanager where ordinarymanager_account='" + username + "'";
		stuinfo_ordinarymanager stuinfo_ordinarymanager = new stuinfo_ordinarymanager();
		Query query = session.createQuery(hql);
		stuinfo_ordinarymanager = (stuinfo_ordinarymanager) query.uniqueResult();
		session.clear();
		return stuinfo_ordinarymanager;
	}

	@Override
	public void saveObj(stuinfo_ordinarymanager newStudent) {
		Session session = getSession();
		session.saveOrUpdate(newStudent);
		session.flush();
	}
}
