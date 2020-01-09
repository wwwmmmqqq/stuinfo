package com.stuinfo.service.impl;

import java.util.List;

import com.stuinfo.dao.SchoolStudentDao;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.StudentInfoVO;
import com.stuinfo.service.SchoolStudentService;

import util.TeamUtil;

public class SchoolStudentServiceImpl implements SchoolStudentService {
	private SchoolStudentDao schoolStudentDao;

	@Override
	public List<StudentDTO> listSchoolStudentAll() {
		return schoolStudentDao.listSchoolStudentAll();
	}

	@Override
	public List<StudentDTO> getSchoolStdentById(String stu_id) {
		return schoolStudentDao.getSchoolStdentById(stu_id);
	}

	@Override
	public boolean updateStuInfo(stuinfo_stubaseinfo stuinfoStuBaseinfo) {
		stuinfoStuBaseinfo.setStu_infomodified(TeamUtil.getStringSecond());
		stuinfoStuBaseinfo.setStu_status("1");
		return schoolStudentDao.updateStuInfo(stuinfoStuBaseinfo);
	}

	@Override
	public boolean deleteSchoolStudentById(String stu_id) {

		return schoolStudentDao.deleteSchoolStudentById(stu_id);
	}

	public SchoolStudentDao getSchoolStudentDao() {
		return schoolStudentDao;
	}

	public void setSchoolStudentDao(SchoolStudentDao schoolStudentDao) {
		this.schoolStudentDao = schoolStudentDao;
	}

	@Override
	public StudentInfoVO VO_Student_By_PageAndSearch(StudentInfoVO studentInfoVO) {
		List<StudentDTO> studentSize = schoolStudentDao.listSchoolStudentAll1(studentInfoVO);
		// 获取总记录数
		int i = studentSize.size();
		studentInfoVO.setTotalRecords(i);
		studentInfoVO.setTotalPages(((i - 1) / studentInfoVO.getPageSize()) + 1);
		// 判断是否有上一页和下一页
		if (studentInfoVO.getPageIndex() <= 1) {
			studentInfoVO.setHavePrePage(false);
		} else {
			studentInfoVO.setHavePrePage(true);
		}
		if (studentInfoVO.getPageIndex() >= studentInfoVO.getPageSize()) {
			studentInfoVO.setHaveNextPage(false);
		} else {
			studentInfoVO.setHaveNextPage(true);
		}

		List<StudentDTO> studentDTO = schoolStudentDao.getSchoolStdentByPage1(studentInfoVO);
		studentInfoVO.setStudentDTO(studentDTO);
		return studentInfoVO;
	}

	@Override
	public StudentInfoVO VO_Student_By_Page(StudentInfoVO studentInfoVO) {
		/* studentInfoVO = new StudentInfoVO(); */
		/*
		 * listSchoolStudentAll()是没有setFirstResult()和setMaxResults()约束的
		 * 这样可以获取到所有满足条件的记录
		 */
		List<StudentDTO> studentSize = schoolStudentDao.listSchoolStudentAll();
		// 获取总记录数
		int i = studentSize.size();
		studentInfoVO.setTotalRecords(i);
		studentInfoVO.setTotalPages(((i - 1) / studentInfoVO.getPageSize()) + 1);
		// 判断是否有上一页和下一页
		if (studentInfoVO.getPageIndex() <= 1) {
			studentInfoVO.setHavePrePage(false);
		} else {
			studentInfoVO.setHavePrePage(true);
		}
		if (studentInfoVO.getPageIndex() >= studentInfoVO.getPageSize()) {
			studentInfoVO.setHaveNextPage(false);
		} else {
			studentInfoVO.setHaveNextPage(true);
		}
		/*
		 * getSchoolStdentByPage()是有约束的
		 */
		// studentDTO获得全部学生的信息，将studentDTO放入到studentInfoVO中的studentDTO，这样studentDTO才会有数据
		List<StudentDTO> studentDTO = schoolStudentDao.getSchoolStdentByPage(studentInfoVO.getPageIndex(),
				studentInfoVO.getPageSize());
		studentInfoVO.setStudentDTO(studentDTO);
		return studentInfoVO;
	}

}
