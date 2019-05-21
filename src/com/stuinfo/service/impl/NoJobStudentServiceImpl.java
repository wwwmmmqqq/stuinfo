package com.stuinfo.service.impl;

import java.util.List;

import com.stuinfo.dao.NoJobStudentDao;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.NoJobStudentVO;
import com.stuinfo.service.NoJobStudentService;

import util.TeamUtil;

public class NoJobStudentServiceImpl implements NoJobStudentService {
	private NoJobStudentDao noJobStudentDao;

	public NoJobStudentDao getNoJobStudentDao() {
		return noJobStudentDao;
	}

	public void setNoJobStudentDao(NoJobStudentDao noJobStudentDao) {
		this.noJobStudentDao = noJobStudentDao;
	}

	@Override
	public List<StudentDTO> listNoJobStudentAll() {
		return noJobStudentDao.listNoJobStudentAll();
	}

	@Override
	public NoJobStudentVO VO_Student_By_PageAndSearch(NoJobStudentVO noJobStudentVO) {

		/* studentInfoVO = new StudentInfoVO(); */
		/*
		 * listSchoolStudentAll()是没有setFirstResult()和setMaxResults()约束的
		 * 这样可以获取到所有满足条件的记录
		 */
		List<StudentDTO> studentSize = noJobStudentDao.listNoJobStudentAll();
		// 获取总记录数
		int i = studentSize.size();
		noJobStudentVO.setTotalRecords(i);
		noJobStudentVO.setTotalPages(((i - 1) / noJobStudentVO.getPageSize()) + 1);
		// 判断是否有上一页和下一页
		if (noJobStudentVO.getPageIndex() <= 1) {
			noJobStudentVO.setHavePrePage(false);
		} else {
			noJobStudentVO.setHavePrePage(true);
		}
		if (noJobStudentVO.getPageIndex() >= noJobStudentVO.getPageSize()) {
			noJobStudentVO.setHaveNextPage(false);
		} else {
			noJobStudentVO.setHaveNextPage(true);
		}
		/*
		 * getSchoolStdentByPage()是有约束的
		 */
		// studentDTO获得全部学生的信息，将studentDTO放入到studentInfoVO中的studentDTO，这样studentDTO才会有数据
		List<StudentDTO> studentDTO = noJobStudentDao.getNoJObStdentByPage(noJobStudentVO.getPageIndex(),
				noJobStudentVO.getPageSize());
		noJobStudentVO.setStudentDTO(studentDTO);
		return noJobStudentVO;

	}

	@Override
	public List<StudentDTO> getNoJobstudentById(String stu_id) {
		return noJobStudentDao.getNoJobstudentById(stu_id);
	}

	@Override
	public boolean UpdateNoJobStudentById(stuinfo_stubaseinfo stuinfoStuBaseinfo) {

		stuinfoStuBaseinfo.setStu_infomodified(TeamUtil.getStringSecond());
		stuinfoStuBaseinfo.setStu_status("5");
		return noJobStudentDao.UpdateNoJobStudentById(stuinfoStuBaseinfo);

	}

	@Override
	public boolean DeleteNoJobStudent(String stu_id) {
		return noJobStudentDao.DeleteNoJobStudent(stu_id);

	}

}
