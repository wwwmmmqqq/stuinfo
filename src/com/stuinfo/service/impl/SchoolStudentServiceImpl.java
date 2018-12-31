package com.stuinfo.service.impl;

import java.util.List;

import com.stuinfo.dao.SchoolStudentDao;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.service.SchoolStudentService;

public class SchoolStudentServiceImpl implements SchoolStudentService {
	private SchoolStudentDao schoolStudentDao;

	public SchoolStudentDao getSchoolStudentDao() {
		return schoolStudentDao;
	}

	public void setSchoolStudentDao(SchoolStudentDao schoolStudentDao) {
		this.schoolStudentDao = schoolStudentDao;
	}

	@Override
	public List<StudentDTO> listSchoolStudentAll() {
		return schoolStudentDao.listSchoolStudentAll();
	}

}
