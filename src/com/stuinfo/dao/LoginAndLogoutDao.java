package com.stuinfo.dao;

import com.stuinfo.domain.DO.stuinfo_ordinarymanager;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DO.stuinfo_teacherinfo;
import com.stuinfo.domain.DTO.StudentDTO;

public interface LoginAndLogoutDao {

	public StudentDTO getStudentUserByNum(String username);

	public stuinfo_teacherinfo getTeacherUserByNum(String username);

	public stuinfo_ordinarymanager getAdminByAccount(String username);

	public void saveObj(stuinfo_stubaseinfo newStudent);

}
