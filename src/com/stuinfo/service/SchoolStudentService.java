package com.stuinfo.service;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.StudentInfoVO;

public interface SchoolStudentService {

	public List<StudentDTO> listSchoolStudentAll();

	public List<StudentDTO> getSchoolStdentById(String stu_id);

	public boolean updateStuInfo(stuinfo_stubaseinfo stuinfoStuBaseinfo);

	public boolean deleteSchoolStudentById(String stu_id);

	public StudentInfoVO VO_Student_By_PageAndSearch(StudentInfoVO studentInfoVO);

	public StudentInfoVO VO_Student_By_Page(StudentInfoVO studentInfoVO);

}
