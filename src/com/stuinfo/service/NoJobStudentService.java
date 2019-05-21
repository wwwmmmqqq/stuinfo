package com.stuinfo.service;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.NoJobStudentVO;

public interface NoJobStudentService {

	public List<StudentDTO> listNoJobStudentAll();

	public NoJobStudentVO VO_Student_By_PageAndSearch(NoJobStudentVO noJobStudentVO);

	public List<StudentDTO> getNoJobstudentById(String stu_id);

	public boolean UpdateNoJobStudentById(stuinfo_stubaseinfo stuinfoStuBaseinfo);

	public boolean DeleteNoJobStudent(String stu_id);

}
