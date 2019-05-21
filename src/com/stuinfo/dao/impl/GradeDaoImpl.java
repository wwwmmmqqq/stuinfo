package com.stuinfo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stuinfo.dao.GradeDao;
import com.stuinfo.domain.DO.stuinfo_stu_grade;

public class GradeDaoImpl implements GradeDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<stuinfo_stu_grade> listGradeAll() {
		List<stuinfo_stu_grade> listGrade = new ArrayList<>();
		Session session = getSession();
		String hql = "from stuinfo_stu_grade order by stu_grade_infocreate";
		Query query = session.createQuery(hql);
		listGrade = query.list();
		session.clear();
		return listGrade;
	}

	@Override
	public boolean deleteGradeById(String stu_grade_id) {
		Session session = getSession();
		String hql = "delete from stuinfo_stu_grade where stu_grade_id='" + stu_grade_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		return true;
	}

	@Override
	public void saveObj(Object obj) {
		Session session = getSession();
		session.saveOrUpdate(obj);
		session.flush();
	}

	@Override
	public stuinfo_stu_grade getGradeByName(String name) {
		Session session = getSession();
		stuinfo_stu_grade GradeInfomation = null;
		String hql = "from stuinfo_stu_grade where stu_grade_name='" + name + "'";
		Query query = session.createQuery(hql);
		GradeInfomation = (stuinfo_stu_grade) query.uniqueResult();
		return GradeInfomation;
	}
}
