package com.stuinfo.service.impl;

import java.util.List;

import com.stuinfo.dao.ClassDao;
import com.stuinfo.domain.DO.stuinfo_stu_class;
import com.stuinfo.domain.DTO.ClassAndGradeDTO;
import com.stuinfo.service.ClassService;

import util.TeamUtil;

public class ClassServiceImpl implements ClassService {
	private ClassDao classDao;

	public ClassDao getClassDao() {
		return classDao;
	}

	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}

	@Override
	public List<ClassAndGradeDTO> listClassAll() {
		return classDao.listClassAll();
	}

	@Override
	public boolean save_NewClass(stuinfo_stu_class newClass) {
		/*
		 * 如果获取到getStu_grade_name和getStu_grade_name不等于空则已经存在不能添加年级，若为空则进行添加操作
		 */
		if (classDao.getClassByName(newClass.stu_class_name, newClass.stu_grade_id).size() != 0) {
			return false;
		} else {
			newClass.setStu_class_id(TeamUtil.getUuid());
			newClass.setStu_class_infocreate(TeamUtil.getStringSecond());
			newClass.setStu_class__infomodified(TeamUtil.getStringSecond());
			classDao.saveObj(newClass);
			return true;
		}
	}

}