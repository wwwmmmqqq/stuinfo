package com.stuinfo.service.impl;

import java.util.List;

import com.stuinfo.dao.ArmyStudentDao;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.ArmyStudentVO;
import com.stuinfo.service.ArmyStudentService;

import util.TeamUtil;

public class ArmyStudentServiceImpl implements ArmyStudentService {
	private ArmyStudentDao armyStudentDao;

	public ArmyStudentDao getArmyStudentDao() {
		return armyStudentDao;
	}

	public void setArmyStudentDao(ArmyStudentDao armyStudentDao) {
		this.armyStudentDao = armyStudentDao;
	}

	@Override
	public List<StudentDTO> listArmyStudentAll() {
		return armyStudentDao.listArmyStudentAll();
	}

	@Override
	public ArmyStudentVO VO_Student_By_PageAndSearch(ArmyStudentVO armyStudentVO) {

		/* studentInfoVO = new StudentInfoVO(); */
		/*
		 * listSchoolStudentAll()是没有setFirstResult()和setMaxResults()约束的
		 * 这样可以获取到所有满足条件的记录
		 */
		List<StudentDTO> studentSize = armyStudentDao.listArmyStudentAll();
		// 获取总记录数
		int i = studentSize.size();
		armyStudentVO.setTotalRecords(i);
		armyStudentVO.setTotalPages(((i - 1) / armyStudentVO.getPageSize()) + 1);
		// 判断是否有上一页和下一页
		if (armyStudentVO.getPageIndex() <= 1) {
			armyStudentVO.setHavePrePage(false);
		} else {
			armyStudentVO.setHavePrePage(true);
		}
		if (armyStudentVO.getPageIndex() >= armyStudentVO.getPageSize()) {
			armyStudentVO.setHaveNextPage(false);
		} else {
			armyStudentVO.setHaveNextPage(true);
		}
		/*
		 * getSchoolStdentByPage()是有约束的
		 */
		// studentDTO获得全部学生的信息，将studentDTO放入到studentInfoVO中的studentDTO，这样studentDTO才会有数据
		List<StudentDTO> studentDTO = armyStudentDao.getArmyStudentByPage(armyStudentVO.getPageIndex(),
				armyStudentVO.getPageSize());
		armyStudentVO.setStudentDTO(studentDTO);
		return armyStudentVO;

	}

	@Override
	public List<StudentDTO> getArmyStudentById(String stu_id) {
		return armyStudentDao.getArmyStudentById(stu_id);
	}

	@Override
	public boolean UpdateArmyStudentById(stuinfo_stubaseinfo stuinfoStuBaseinfo) {

		stuinfoStuBaseinfo.setStu_infomodified(TeamUtil.getStringSecond());
		stuinfoStuBaseinfo.setStu_status("3");
		return armyStudentDao.UpdateArmyStudentById(stuinfoStuBaseinfo);
	}

	@Override
	public boolean DeleteArmyStudent(String stu_id) {
		return armyStudentDao.DeleteArmyStudent(stu_id);
	}

}
