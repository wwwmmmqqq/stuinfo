package com.stuinfo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stuinfo.dao.SchoolStudentDao;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.StudentInfoVO;

public class SchoolStudentDaoImpl implements SchoolStudentDao {
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
	public List<StudentDTO> listSchoolStudentAll() {
		List<StudentDTO> listStudent = new ArrayList<>();

		Session session = getSession();

		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," //
				+ "stuinfo_stu_grade stuinfoStuGrade ," //
				+ " stuinfo_stu_class stuinfoStuClass "//
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id and stuinfoStuBaseinfo.stu_status='1'";

		Query query = session.createQuery(hql);
		listStudent = query.list();
		session.clear();
		return listStudent;
	}

	@Override
	public List<StudentDTO> listSchoolStudentAll1(StudentInfoVO studentInfoVO) {
		List<StudentDTO> listStudent = new ArrayList<>();

		Session session = getSession();

		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," //
				+ "stuinfo_stu_grade stuinfoStuGrade ," //
				+ " stuinfo_stu_class stuinfoStuClass "//
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id and stuinfoStuBaseinfo.stu_status='1'";
		if (studentInfoVO.getStu_account() != "") {
			hql = hql + " and stu_account like '" + studentInfoVO.getStu_account() + "'";
		}
		if (studentInfoVO.getStu_name() != "") {
			hql = hql + " and stu_name like '" + studentInfoVO.getStu_name() + "'";
		}
		if (studentInfoVO.getStu_major() != "") {
			hql = hql + " and stu_major like '" + studentInfoVO.getStu_major() + "'";
		}
		Query query = session.createQuery(hql);
		listStudent = query.list();
		session.clear();
		return listStudent;
	}

	/*
	 * (non-Javadoc)通过记录id详细查看记录信息
	 * 
	 * @see
	 * com.stuinfo.dao.SchoolStudentDao#getSchoolStdentById(java.lang.String)
	 */
	@Override
	public List<StudentDTO> getSchoolStdentById(String stu_id) {
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

	/*
	 * (non-Javadoc)分页查询记录
	 * 
	 * @see com.stuinfo.dao.SchoolStudentDao#getSchoolStdentByPage(int, int)
	 */
	/*
	 * @Override public List<StudentDTO> getSchoolStdentByPage(int pageIdex, int
	 * pageSize) { List<StudentDTO> listStudent = new ArrayList<>();
	 * 
	 * Session session = getSession();
	 * 
	 * String hql =
	 * " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
	 * + "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," +
	 * "stuinfo_stu_grade stuinfoStuGrade ," +
	 * " stuinfo_stu_class stuinfoStuClass " +
	 * " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id" +
	 * " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id and stuinfoStuBaseinfo.stu_status='1'"
	 * ;
	 * 
	 * Query query = session.createQuery(hql); query.setFirstResult((pageIdex -
	 * 1) * pageSize); query.setMaxResults(pageSize); listStudent =
	 * query.list(); return listStudent; }
	 */
	@Override
	public List<StudentDTO> getSchoolStdentByPage(int pageIdex, int pageSize) {
		List<StudentDTO> listStudent = new ArrayList<>();

		Session session = getSession();

		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," + "stuinfo_stu_grade stuinfoStuGrade ,"
				+ " stuinfo_stu_class stuinfoStuClass "
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id and stuinfoStuBaseinfo.stu_status='1'";

		Query query = session.createQuery(hql);
		query.setFirstResult((pageIdex - 1) * pageSize);
		query.setMaxResults(pageSize);
		listStudent = query.list();
		return listStudent;
	}

	@Override
	public List<StudentDTO> getSchoolStdentByPage1(StudentInfoVO studentInfoVO) {
		List<StudentDTO> listStudent = new ArrayList<>();

		Session session = getSession();

		String hql = " select new com.stuinfo.domain.DTO.StudentDTO(stuinfoStuBaseinfo,stuinfoStuGrade,stuinfoStuClass) "
				+ "from  stuinfo_stubaseinfo stuinfoStuBaseinfo," + "stuinfo_stu_grade stuinfoStuGrade ,"
				+ " stuinfo_stu_class stuinfoStuClass "
				+ " where stuinfoStuBaseinfo.stu_class_id=stuinfoStuClass.stu_class_id"
				+ " and stuinfoStuClass.stu_grade_id=stuinfoStuGrade.stu_grade_id and stuinfoStuBaseinfo.stu_status='1'";
		if (studentInfoVO.getStu_account() != "") {
			hql = hql + " and stu_account like '" + studentInfoVO.getStu_account() + "'";
		}
		if (studentInfoVO.getStu_name() != "") {
			hql = hql + " and stu_name like '" + studentInfoVO.getStu_name() + "'";
		}
		if (studentInfoVO.getStu_major() != "") {
			hql = hql + " and stu_major like '" + studentInfoVO.getStu_major() + "'";
		}
		Query query = session.createQuery(hql);
		query.setFirstResult((studentInfoVO.getPageIndex() - 1) * studentInfoVO.getPageSize());
		/* query.setFirstResult((pageIdex - 1) * pageSize); */
		query.setMaxResults(studentInfoVO.getPageSize());
		listStudent = query.list();
		return listStudent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.stuinfo.dao.SchoolStudentDao#updateStuInfoById(java.lang.String)
	 * 通过id修改学生信息
	 */
	@Override
	public boolean updateStuInfo(stuinfo_stubaseinfo stuinfoStuBaseinfo) {
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

	/*
	 * (non-Javadoc)通过id删除学生信息
	 * 
	 * @see com.stuinfo.dao.SchoolStudentDao#deleteSchoolStudentById(java.lang.
	 * String)
	 */
	@Override
	public boolean deleteSchoolStudentById(String stu_id) {

		Session session = getSession();
		String hql = "delete from stuinfo_stubaseinfo where stu_id='" + stu_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		return true;

	}

}
