package com.stuinfo.service.impl;

import java.util.List;

import com.stuinfo.dao.PostGraduateStudentDao;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.PostGraduateStudentVO;
import com.stuinfo.service.PostGraduateStudentService;

import util.TeamUtil;

public class PostGraduateStudentServiceImpl implements PostGraduateStudentService {
	private PostGraduateStudentDao postGraduateStudentDao;

	public PostGraduateStudentDao getPostGraduateStudentDao() {
		return postGraduateStudentDao;
	}

	public void setPostGraduateStudentDao(PostGraduateStudentDao postGraduateStudentDao) {
		this.postGraduateStudentDao = postGraduateStudentDao;
	}

	@Override
	public List<StudentDTO> listPostGraduateStudentAll() {
		return postGraduateStudentDao.listPostGraduateStudentAll();
	}

	@Override
	public PostGraduateStudentVO VO_Student_By_PageAndSearch(PostGraduateStudentVO postGraduateStudentVO) {

		/* studentInfoVO = new StudentInfoVO(); */
		/*
		 * listSchoolStudentAll()是没有setFirstResult()和setMaxResults()约束的
		 * 这样可以获取到所有满足条件的记录
		 */
		List<StudentDTO> studentSize = postGraduateStudentDao.listPostGraduateStudentAll();
		// 获取总记录数
		int i = studentSize.size();
		postGraduateStudentVO.setTotalRecords(i);
		postGraduateStudentVO.setTotalPages(((i - 1) / postGraduateStudentVO.getPageSize()) + 1);
		// 判断是否有上一页和下一页
		if (postGraduateStudentVO.getPageIndex() <= 1) {
			postGraduateStudentVO.setHavePrePage(false);
		} else {
			postGraduateStudentVO.setHavePrePage(true);
		}
		if (postGraduateStudentVO.getPageIndex() >= postGraduateStudentVO.getPageSize()) {
			postGraduateStudentVO.setHaveNextPage(false);
		} else {
			postGraduateStudentVO.setHaveNextPage(true);
		}
		/*
		 * getSchoolStdentByPage()是有约束的
		 */
		// studentDTO获得全部学生的信息，将studentDTO放入到studentInfoVO中的studentDTO，这样studentDTO才会有数据
		List<StudentDTO> studentDTO = postGraduateStudentDao
				.getPostGraduateStdentByPage(postGraduateStudentVO.getPageIndex(), postGraduateStudentVO.getPageSize());
		postGraduateStudentVO.setStudentDTO(studentDTO);
		return postGraduateStudentVO;

	}

	@Override
	public List<StudentDTO> getPostGraduateStudentById(String stu_id) {
		return postGraduateStudentDao.getPostGraduateStudentById(stu_id);
	}

	@Override
	public boolean updatePostGraduateStudentInfo(stuinfo_stubaseinfo stuinfoStuBaseinfo) {

		stuinfoStuBaseinfo.setStu_infomodified(TeamUtil.getStringSecond());
		stuinfoStuBaseinfo.setStu_status("2");
		return postGraduateStudentDao.updatePostGraduateStudentInfo(stuinfoStuBaseinfo);

	}

	@Override
	public boolean DeletePostGraduateStudent(String stu_id) {
		return postGraduateStudentDao.DeletePostGraduateStudent(stu_id);

	}

}
