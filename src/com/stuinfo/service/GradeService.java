package com.stuinfo.service;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stu_grade;

public interface GradeService {

	public List<stuinfo_stu_grade> listGradeAll();

	public boolean save_NewGrade(stuinfo_stu_grade newGrade);
}
