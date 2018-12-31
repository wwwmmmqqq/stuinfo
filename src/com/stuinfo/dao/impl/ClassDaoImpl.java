package com.stuinfo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stuinfo.dao.ClassDao;
import com.stuinfo.domain.DO.stuinfo_stu_class;
import com.stuinfo.domain.DTO.ClassAndGradeDTO;

public class ClassDaoImpl implements ClassDao {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 查找两张表，将班级和年级放在一个DTO内，new一个DTO将两张表新建的对象注入到DTO内
	@Override
	public List<ClassAndGradeDTO> listClassAll() {
		List<ClassAndGradeDTO> listClass = new ArrayList<>();
		Session session = getSession();
		String hql = " select new com.stuinfo.domain.DTO.ClassAndGradeDTO(stuinfoStuGrade,stuinfoStuClass) "//
				+ "from  stuinfo_stu_class stuinfoStuClass," //
				+ "stuinfo_stu_grade stuinfoStuGrade "//
				+ "where stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id ";
		Query query = session.createQuery(hql);
		listClass = query.list();
		session.clear();
		return listClass;
	}

	@Override
	public boolean deleteClassById(String stu_class_id) {
		return false;
	}

	@Override
	public void saveObj(Object obj) {
		Session session = getSession();
		session.saveOrUpdate(obj);
		session.flush();
	}

	@Override
	public List<stuinfo_stu_class> getClassByName(String stu_class_name, String stu_grade_id) {
		Session session = getSession();
		List<stuinfo_stu_class> listClassAndGrade = new ArrayList<>();
		String hql = "from stuinfo_stu_class where stu_class_name='" + stu_class_name + "' and stu_grade_id='"
				+ stu_grade_id + "'";
		System.out.println(hql);
		Query query = session.createQuery(hql);
		listClassAndGrade = query.list();
		session.clear();
		return listClassAndGrade;
	}

}
