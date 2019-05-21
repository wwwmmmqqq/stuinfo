package com.stuinfo.service.impl;

import java.util.List;

import com.stuinfo.dao.JobStudentDao;
import com.stuinfo.domain.DO.stuinfo_stu_onjob;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.JobStudentDTO;
import com.stuinfo.domain.VO.JobStudentVO;
import com.stuinfo.service.JobStudentService;

import util.TeamUtil;

public class JobStudentServiceImpl implements JobStudentService {
	private JobStudentDao jobStudentDao;

	public JobStudentDao getJobStudentDao() {
		return jobStudentDao;
	}

	public void setJobStudentDao(JobStudentDao jobStudentDao) {
		this.jobStudentDao = jobStudentDao;
	}

	@Override
	public List<JobStudentDTO> listJobStudentAll() {
		return jobStudentDao.listJobStudentAll();
	}

	@Override
	public JobStudentVO VO_Job_Student_By_PageAndSearch(JobStudentVO jobStudentVO) {
		/*
		 * listSchoolStudentAll()是没有setFirstResult()和setMaxResults()约束的
		 * 这样可以获取到所有满足条件的记录
		 */
		List<JobStudentDTO> JobStudentSize = jobStudentDao.listJobStudentAll();
		// 获取总记录数
		int i = JobStudentSize.size();
		jobStudentVO.setTotalRecords(i);
		jobStudentVO.setTotalPages(((i - 1) / jobStudentVO.getPageSize()) + 1);
		// 判断是否有上一页和下一页
		if (jobStudentVO.getPageIndex() <= 1) {
			jobStudentVO.setHavePrePage(false);
		} else {
			jobStudentVO.setHavePrePage(true);
		}
		if (jobStudentVO.getPageIndex() >= jobStudentVO.getPageSize()) {
			jobStudentVO.setHaveNextPage(false);
		} else {
			jobStudentVO.setHaveNextPage(true);
		}
		List<JobStudentDTO> jobStudentDTO = jobStudentDao.getJobStdentByPage(jobStudentVO.getPageIndex(),
				jobStudentVO.getPageSize());
		jobStudentVO.setJobStudentDTO(jobStudentDTO);
		return jobStudentVO;
	}

	@Override
	public void a() {
		System.out.println("zzzz");
	}

	@Override
	public List<JobStudentDTO> getJobStdentById(String stu_id) {
		return jobStudentDao.getSchoolStdentById(stu_id);
	}

	@Override
	public boolean UpdateJobStudentBaseInfo(stuinfo_stubaseinfo stuinfoStuBaseinfo) {

		stuinfoStuBaseinfo.setStu_infomodified(TeamUtil.getStringSecond());
		stuinfoStuBaseinfo.setStu_status("4");
		return jobStudentDao.UpdateJobStudentBaseInfo(stuinfoStuBaseinfo);

	}

	@Override
	public boolean UpdateJobStudentJobInfo(stuinfo_stu_onjob stuinfoStuOnJob) {
		System.out.println(stuinfoStuOnJob);
		stuinfoStuOnJob.setStu_job__infomodified(TeamUtil.getStringSecond());

		return jobStudentDao.UpdateJobStudentJobInfo(stuinfoStuOnJob);

	}

	@Override
	public boolean deleteJobStudent(String stu_id) {
		return jobStudentDao.deleteJobStudent(stu_id);
	}

}
