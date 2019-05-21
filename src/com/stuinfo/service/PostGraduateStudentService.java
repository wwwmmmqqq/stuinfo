package com.stuinfo.service;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.PostGraduateStudentVO;

public interface PostGraduateStudentService {

	public List<StudentDTO> listPostGraduateStudentAll();

	public PostGraduateStudentVO VO_Student_By_PageAndSearch(PostGraduateStudentVO postGraduateStudentVO);

	public List<StudentDTO> getPostGraduateStudentById(String stu_id);

	public boolean updatePostGraduateStudentInfo(stuinfo_stubaseinfo stuinfoStuBaseinfo);

	public boolean DeletePostGraduateStudent(String stu_id);

}
