package com.stuinfo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stuinfo.dao.JobStudentDao;
import com.stuinfo.domain.DO.stuinfo_stu_onjob;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.JobStudentDTO;

public class JobStudentDaoImpl implements JobStudentDao {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public List<JobStudentDTO> listJobStudentAll() {
		List<JobStudentDTO> listJobStudent = new ArrayList<>();

		Session session = getSession();

		/*
		 * String hql =
		 * " select new com.stuinfo.domain.DTO.JobStudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass,stuinfoStuOnJob) "
		 * + "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," +
		 * "stuinfo_stu_grade stuinfoStuGrade ," +
		 * " stuinfo_stu_class stuinfoStuClass," +
		 * "stuinfo_stu_onjob stuinfoStuOnJob" +
		 * " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
		 * + " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id " +
		 * " and stuinfoStuOnJob.stu_id=stuinfoStuBaseinfo.stu_id" +
		 * " and stuinfoStuBaseinfo.stu_status='4' order by stuinfoStuOnJob.stu_job_infocreate"
		 * ;
		 */
		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," //
				+ "stuinfo_stu_grade stuinfoStuGrade ," //
				+ " stuinfo_stu_class stuinfoStuClass "//
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id and stuinfoStuBaseinfo.stu_status='4' order by stuinfoStuBaseinfo.stu_infocreate";

		/* String hql = " from stuinfo_stu_onjob"; */
		Query query = session.createQuery(hql);
		listJobStudent = query.list();
		session.clear();
		return listJobStudent;
	}

	@Override
	public List<JobStudentDTO> getJobStdentByPage(int pageIdex, int pageSize) {
		List<JobStudentDTO> listJobStudent = new ArrayList<>();

		Session session = getSession();

		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," //
				+ "stuinfo_stu_grade stuinfoStuGrade ," //
				+ " stuinfo_stu_class stuinfoStuClass "//
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id and stuinfoStuBaseinfo.stu_status='4' order by stuinfoStuBaseinfo.stu_infocreate";

		/* String hql = " from stuinfo_stu_onjob"; */
		Query query = session.createQuery(hql);
		// 两个set方法约束每页的查询条件
		// 设置从第几条开始查询
		query.setFirstResult((pageIdex - 1) * pageSize);
		// 设置最大的查询结果为每页显示的记录数
		query.setMaxResults(pageSize);
		// 查询结果为一个list
		listJobStudent = query.list();
		return listJobStudent;
	}

	@Override
	public List<JobStudentDTO> getSchoolStdentById(String stu_id) {
		List<JobStudentDTO> listJobStudentById = new ArrayList<>();
		Session session = getSession();
		String hql = " select new com.stuinfo.domain.DTO.JobStudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass,stuinfoStuOnJob) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," + "stuinfo_stu_grade stuinfoStuGrade ,"
				+ " stuinfo_stu_class stuinfoStuClass," + "stuinfo_stu_onjob stuinfoStuOnJob "
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id "
				+ "and stuinfoStuOnJob.stu_id=stuinfoStuBaseinfo.stu_id" + " and stuinfoStuBaseinfo.stu_id='" + stu_id
				+ "' ";
		Query query = session.createQuery(hql);
		listJobStudentById = query.list();
		session.clear();
		return listJobStudentById;
	}

	@Override
	public boolean UpdateJobStudentBaseInfo(stuinfo_stubaseinfo stuinfoStuBaseinfo) {
		boolean flag = true;
		try {
			Session session = getSession();
			session.saveOrUpdate(stuinfoStuBaseinfo);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean UpdateJobStudentJobInfo(stuinfo_stu_onjob stuinfoStuOnJob) {
		boolean flag = true;
		try {
			Session session = getSession();
			session.saveOrUpdate(stuinfoStuOnJob);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteJobStudent(String stu_id) {
		Session session = getSession();
		String hql = "delete from stuinfo_stubaseinfo where stu_id='" + stu_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		return true;

	}

}
