package com.stuinfo.dao;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;

public interface NoJobStudentDao {

	public List<StudentDTO> listNoJobStudentAll();

	public List<StudentDTO> getNoJObStdentByPage(int pageIndex, int pageSize);

	public List<StudentDTO> getNoJobstudentById(String stu_id);

	public boolean UpdateNoJobStudentById(stuinfo_stubaseinfo stuinfoStuBaseinfo);

	public boolean DeleteNoJobStudent(String stu_id);

}
