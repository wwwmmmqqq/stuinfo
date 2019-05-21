package com.stuinfo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stuinfo.dao.ArmyStudentDao;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;

public class ArmyStudentDaoImpl implements ArmyStudentDao {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<StudentDTO> listArmyStudentAll() {
		List<StudentDTO> listStudent = new ArrayList<>();

		Session session = getSession();

		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," //
				+ "stuinfo_stu_grade stuinfoStuGrade ," //
				+ " stuinfo_stu_class stuinfoStuClass "//
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id and stuinfoStuBaseinfo.stu_status='3' ";

		Query query = session.createQuery(hql);
		listStudent = query.list();
		session.clear();
		return listStudent;
	}

	@Override
	public List<StudentDTO> getArmyStudentByPage(int pageIndex, int pageSize) {
		List<StudentDTO> listStudent = new ArrayList<>();

		Session session = getSession();

		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," + "stuinfo_stu_grade stuinfoStuGrade ,"
				+ " stuinfo_stu_class stuinfoStuClass "
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id and stuinfoStuBaseinfo.stu_status='3' ";

		/* String hql = "select count(*) from stuinfo_stubaseinfo"; */
		Query query = session.createQuery(hql);
		// 两个set方法约束每页的查询条件
		// 设置从第几条开始查询
		query.setFirstResult((pageIndex - 1) * pageSize);
		// 设置最大的查询结果为每页显示的记录数
		query.setMaxResults(pageSize);
		// 查询结果为一个list
		listStudent = query.list();
		return listStudent;
	}

	@Override
	public List<StudentDTO> getArmyStudentById(String stu_id) {
		List<StudentDTO> listStudentById = new ArrayList<>();
		Session session = getSession();
		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," //
				+ "stuinfo_stu_grade stuinfoStuGrade ," //
				+ " stuinfo_stu_class stuinfoStuClass "//
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id and stu_id='" + stu_id + "'";
		Query query = session.createQuery(hql);
		listStudentById = query.list();
		session.clear();
		return listStudentById;

	}

	@Override
	public boolean UpdateArmyStudentById(stuinfo_stubaseinfo stuinfoStuBaseinfo) {
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
	public boolean DeleteArmyStudent(String stu_id) {

		Session session = getSession();
		String hql = "delete from stuinfo_stubaseinfo where stu_id='" + stu_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		return true;

	}

}
