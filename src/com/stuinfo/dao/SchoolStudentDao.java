package com.stuinfo.dao;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.StudentInfoVO;

public interface SchoolStudentDao {

	/* public List<StudentDTO> listSchoolStudentByPageAndSearch(); */

	public List<StudentDTO> listSchoolStudentAll();

	public List<StudentDTO> getSchoolStdentById(String stu_id);

	public List<StudentDTO> getSchoolStdentByPage(int pageIdex, int pageSize);

	public boolean updateStuInfo(stuinfo_stubaseinfo stuinfoStuBaseinfo);

	boolean deleteSchoolStudentById(String stu_id);

	public List<StudentDTO> getSchoolStdentByPage1(StudentInfoVO studentInfoVO);

	public List<StudentDTO> listSchoolStudentAll1(StudentInfoVO studentInfoVO);

}
