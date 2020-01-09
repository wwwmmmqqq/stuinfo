package com.stuinfo.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.stuinfo.domain.DO.stuinfo_notice;
import com.stuinfo.domain.DO.stuinfo_stu_onjob;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.StudentFiled;
import com.stuinfo.domain.VO.StudentInfoVO;

public interface StudentService {

	public boolean StudentAddJobInfo(String stu_id, stuinfo_stu_onjob stuinfoStuOnjob);

	public List<stuinfo_stubaseinfo> GetJobRecodeById(String stu_id);

	public StudentInfoVO<StudentDTO> findNoPage(StudentDTO stdo);

	public void writeStudentInformation(StudentInfoVO<StudentDTO> studentPage, StudentFiled studentFiled,
			HSSFWorkbook wb);

	public boolean addNotice(StudentDTO studentDTO, stuinfo_notice stuinfoNotice);

	public boolean UpdatePassword(String stu_id, String newPassword);

	public int insertInfoToDB(List<Object> list);

	public List<List<String>> getListString(List<StudentFiled> studentFiled);

}
