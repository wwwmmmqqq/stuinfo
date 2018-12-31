package com.stuinfo.service;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stu_class;
import com.stuinfo.domain.DTO.ClassAndGradeDTO;

public interface ClassService {

	public List<ClassAndGradeDTO> listClassAll();

	public boolean save_NewClass(stuinfo_stu_class newClass);

}
