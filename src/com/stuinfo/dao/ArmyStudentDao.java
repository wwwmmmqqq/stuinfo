package com.stuinfo.dao;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;

public interface ArmyStudentDao {

	public List<StudentDTO> listArmyStudentAll();

	public List<StudentDTO> getArmyStudentByPage(int pageIndex, int pageSize);

	public List<StudentDTO> getArmyStudentById(String stu_id);

	public boolean UpdateArmyStudentById(stuinfo_stubaseinfo stuinfoStuBaseinfo);

	public boolean DeleteArmyStudent(String stu_id);

}
