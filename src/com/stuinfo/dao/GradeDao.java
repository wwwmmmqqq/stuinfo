package com.stuinfo.dao;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stu_grade;

public interface GradeDao {

	/**
	 * 查询所有的班级
	 * 
	 * @return
	 */
	public List<stuinfo_stu_grade> listGradeAll();

	/**
	 * 根据年级Id删除年级
	 * 
	 * @param stu_grade_id
	 * @return
	 */
	public boolean deleteGradeById(String stu_grade_id);

	public stuinfo_stu_grade getGradeByName(String name);

	/*
	 * 增加年级
	 */
	public void saveObj(Object obj);

}
