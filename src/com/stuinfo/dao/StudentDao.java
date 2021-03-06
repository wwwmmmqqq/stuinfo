package com.stuinfo.dao;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.StudentFiled;

public interface StudentDao {

	public boolean saveObj(Object obj);

	public List<stuinfo_stubaseinfo> GetJobRecodeById(String stu_id);

	public int findCount(String stu_status);

	public List<StudentDTO> findNoPage(StudentDTO stdo);

	public boolean UpdatePassword(String stu_id, String newPassword, String time);

	public int insertInfoToDB(List<Object> list);

	public List<StudentFiled> getListString(List<StudentFiled> studentFiled);

}
