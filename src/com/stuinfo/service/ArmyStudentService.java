package com.stuinfo.service;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.ArmyStudentVO;

public interface ArmyStudentService {

	public List<StudentDTO> listArmyStudentAll();

	public ArmyStudentVO VO_Student_By_PageAndSearch(ArmyStudentVO armyStudentVO);

	public List<StudentDTO> getArmyStudentById(String stu_id);

	public boolean UpdateArmyStudentById(stuinfo_stubaseinfo stuinfoStuBaseinfo);

	public boolean DeleteArmyStudent(String stu_id);

}
