package com.stuinfo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stuinfo.dao.StudentDao;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.StudentFiled;

public class StudentDaoImpl implements StudentDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	/*
	 * @Override public void saveObj(stuinfo_stu_onjob stuinfoStuOnjob) {
	 * Session session = getSession(); session.saveOrUpdate(stuinfoStuOnjob);
	 * session.flush(); }
	 */

	@Override
	public boolean saveObj(Object obj) {
		boolean flag = true;
		try {
			Session session = getSession();
			session.saveOrUpdate(obj);
			session.flush();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<StudentFiled> getListString(List<StudentFiled> studentFiled) {
		Session session = getSession();
		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," //
				+ "stuinfo_stu_grade stuinfoStuGrade ," //
				+ " stuinfo_stu_class stuinfoStuClass "//
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id   order by stuinfoStuBaseinfo.stu_infocreate ";

		Query query = session.createQuery(hql);
		studentFiled = query.list();
		session.clear();
		return studentFiled;
	}

	@Override
	public List<stuinfo_stubaseinfo> GetJobRecodeById(String stu_id) {
		List<stuinfo_stubaseinfo> listJobRecodeById = new ArrayList<>();
		Session session = getSession();
		String hql = "from stuinfo_stu_onjob where stu_id='" + stu_id + "' order by stu_job_infocreate ";
		Query query = session.createQuery(hql);
		listJobRecodeById = query.list();
		session.clear();
		return listJobRecodeById;
	}

	@Override
	public boolean UpdatePassword(String stu_id, String newPassword, String time) {
		boolean flag = true;
		try {
			Session session = getSession();
			String hql = "update stuinfo_stubaseinfo set stu_password = '" + newPassword + "',stu_infomodified='" + time
					+ "' where stu_id='" + stu_id + "'";
			Query query = session.createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			flag = false;
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int findCount(String stu_status) {
		Session session = getSession();
		String hql = "select count(*) from stuinfo_stubaseinfo where stu_status=" + stu_status
				+ "  order by stu_infocreate ";
		Query query = session.createQuery(hql);

		List<Long> list = query.list();

		if (list.size() > 0) {
			return list.get(0).intValue();

		} else {
			return 0;
		}

	}

	@Override
	public List<StudentDTO> findNoPage(StudentDTO stdo) {
		Session session = getSession();
		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," //
				+ "stuinfo_stu_grade stuinfoStuGrade ," //
				+ " stuinfo_stu_class stuinfoStuClass "//
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id ";

		if (stdo == null) {
			// 不改动HQL语句
		} else {
			hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
					+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," //
					+ "stuinfo_stu_grade stuinfoStuGrade ," //
					+ " stuinfo_stu_class stuinfoStuClass "//
					+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
					+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id where ";

			if (stdo.getStuinfo_stubaseinfo().getStu_account() != null) {
				hql = hql + " stu_account '" + stdo.getStuinfo_stubaseinfo().getStu_account() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_name() != null) {
				hql = hql + " stu_name='" + stdo.getStuinfo_stubaseinfo().getStu_name() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_sex() != null) {
				hql = hql + " stu_sex='" + stdo.getStuinfo_stubaseinfo().getStu_sex() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_adress() != null) {
				hql = hql + " stu_adress='" + stdo.getStuinfo_stubaseinfo().getStu_adress() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_bir() != null) {
				hql = hql + " stu_bir='" + stdo.getStuinfo_stubaseinfo().getStu_bir() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_familytype() != null) {
				hql = hql + " stu_familytype' " + stdo.getStuinfo_stubaseinfo().getStu_familytype() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_nation() != null) {
				hql = hql + " stu_nation='" + stdo.getStuinfo_stubaseinfo().getStu_nation() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_policits() != null) {
				hql = hql + " stu_policits='" + stdo.getStuinfo_stubaseinfo().getStu_policits() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_idcard() != null) {
				hql = hql + " stu_idcard='" + stdo.getStuinfo_stubaseinfo().getStu_idcard() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_phenumber() != null) {
				hql = hql + " stu_phenumber='" + stdo.getStuinfo_stubaseinfo().getStu_phenumber() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_fathername() != null) {
				hql = hql + " stu_fathername='" + stdo.getStuinfo_stubaseinfo().getStu_fathername() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_fathernum() != null) {
				hql = hql + " stu_fathernum='" + stdo.getStuinfo_stubaseinfo().getStu_fathernum() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_mothername() != null) {
				hql = hql + " stu_mothername='" + stdo.getStuinfo_stubaseinfo().getStu_mothername() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_mothernum() != null) {
				hql = hql + " stu_mothernum='" + stdo.getStuinfo_stubaseinfo().getStu_mothernum() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_lev() != null) {
				hql = hql + " stu_lev='" + stdo.getStuinfo_stubaseinfo().getStu_lev() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_college() != null) {
				hql = hql + " stu_college='" + stdo.getStuinfo_stubaseinfo().getStu_college() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_const() != null) {
				hql = hql + " stu_const='" + stdo.getStuinfo_stubaseinfo().getStu_const() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_major() != null) {
				hql = hql + " stu_major='" + stdo.getStuinfo_stubaseinfo().getStu_major() + "'and";
			}
			/*
			 * if (stdo.getStuinfoStuClass().getStu_class_id() != null) { hql =
			 * hql + " stu_class_id='" +
			 * stdo.getStuinfoStuClass().getStu_class_id() + "'and"; }
			 */
			/*
			 * if (stdo.getStuinfoStuClass().getStu_class_name() != null) { hql
			 * = hql + " stu_class_name='" +
			 * stdo.getStuinfoStuClass().getStu_class_name() + "'and"; } if
			 * (stdo.getStuinfoStuGrade().getStu_grade_name() != null) { hql =
			 * hql + " stu_grade_name='" +
			 * stdo.getStuinfoStuGrade().getStu_grade_name() + "'and"; }
			 */
			if (stdo.getStuinfo_stubaseinfo().getStu_year() != null) {
				hql = hql + " stu_year='" + stdo.getStuinfo_stubaseinfo().getStu_year() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_change() != null) {
				hql = hql + " stu_change='" + stdo.getStuinfo_stubaseinfo().getStu_change() + "'and";
			}
			if (stdo.getStuinfo_stubaseinfo().getStu_status() != null) {
				hql = hql + " stu_status='" + stdo.getStuinfo_stubaseinfo().getStu_status() + "'and";
			}

			hql = hql.substring(0, hql.length() - 3);

		} // if
		System.out.println("————————————————————hql:" + hql);
		List<StudentDTO> student_list = new ArrayList<>();
		Query query = session.createQuery(hql);
		student_list = query.list();
		return student_list;
	}

	@Override
	public int insertInfoToDB(List<Object> list) {
		int nums = 0;
		try {
			Session session = this.getSession();
			// Transaction tx= session.beginTransaction();
			for (int i = 0; i < list.size(); i++) {
				session.save(list.get(i));
				nums++;
				if (i % 1000 == 0) { // 每一千条刷新并写入数据库
					session.flush();
					session.clear();
				}
			}
			// session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nums;
	}

}
