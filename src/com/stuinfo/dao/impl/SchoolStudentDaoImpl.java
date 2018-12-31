package com.stuinfo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stuinfo.dao.SchoolStudentDao;
import com.stuinfo.domain.DTO.StudentDTO;

public class SchoolStudentDaoImpl implements SchoolStudentDao {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<StudentDTO> listSchoolStudentAll() {
		List<StudentDTO> listStudent = new ArrayList<>();

		Session session = getSession();
		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "//
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," //
				+ "stuinfo_stu_grade stuinfoStuGrade ," //
				+ " stuinfo_stu_class stuinfoStuClass "//
				+ "where stuinfoStuBaseinfo.stu_grade_id=stuinfoStuGrade.stu_grade_id "
				+ "and  stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id ";

		Query query = session.createQuery(hql);
		listStudent = query.list();
		session.clear();
		return listStudent;
	}
}
