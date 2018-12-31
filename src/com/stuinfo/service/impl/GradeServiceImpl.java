package com.stuinfo.service.impl;

import java.util.List;

import com.stuinfo.dao.GradeDao;
import com.stuinfo.domain.DO.stuinfo_stu_grade;
import com.stuinfo.service.GradeService;

import util.TeamUtil;

public class GradeServiceImpl implements GradeService {
	private GradeDao gradeDao;

	@Override
	public List<stuinfo_stu_grade> listGradeAll() {

		return gradeDao.listGradeAll();
	}

	public GradeDao getGradeDao() {
		return gradeDao;
	}

	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	@Override
	public boolean save_NewGrade(stuinfo_stu_grade newGrade) {
		/*
		 * 如果获取到getStu_grade_name不等于空则已经存在不能添加年级，若为空则进行添加操作
		 */
		if (gradeDao.getGradeByName(newGrade.getStu_grade_name()) != null) {
			return false;
		} else {
			newGrade.setStu_grade_id(TeamUtil.getUuid());
			newGrade.setStu_grade_infocreate(TeamUtil.getStringSecond());
			newGrade.setStu_grade__infomodified(TeamUtil.getStringSecond());
			gradeDao.saveObj(newGrade);
			return true;

		}

	}

}
