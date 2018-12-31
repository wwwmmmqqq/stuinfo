package com.stuinfo.dao;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stu_class;
import com.stuinfo.domain.DTO.ClassAndGradeDTO;

public interface ClassDao {

	/**
	 * 查询所有的班级
	 * 
	 * @return
	 */
	public List<ClassAndGradeDTO> listClassAll();

	/**
	 * 根据年级Id删除班级
	 * 
	 * @param stu_grade_id
	 * @return
	 */
	public boolean deleteClassById(String stu_class_id);

	public List<stuinfo_stu_class> getClassByName(String stu_class_name, String stu_grade_id);

	/*
	 * 增加年级
	 */
	public void saveObj(Object obj);
}
