package com.stuinfo.dao;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;

public interface PostGraduateStudentDao {

	public List<StudentDTO> listPostGraduateStudentAll();

	public List<StudentDTO> getPostGraduateStdentByPage(int pageIndex, int pageSize);

	public List<StudentDTO> getPostGraduateStudentById(String stu_id);

	public boolean updatePostGraduateStudentInfo(stuinfo_stubaseinfo stuinfoStuBaseinfo);

	public boolean DeletePostGraduateStudent(String stu_id);

}
