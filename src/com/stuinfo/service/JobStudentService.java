package com.stuinfo.service;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stu_onjob;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.JobStudentDTO;
import com.stuinfo.domain.VO.JobStudentVO;

public interface JobStudentService {
	public List<JobStudentDTO> listJobStudentAll();

	public JobStudentVO VO_Job_Student_By_PageAndSearch(JobStudentVO jobStudentVO);

	public void a();

	public List<JobStudentDTO> getJobStdentById(String stu_id);

	public boolean UpdateJobStudentBaseInfo(stuinfo_stubaseinfo stuinfoStuBaseinfo);

	public boolean UpdateJobStudentJobInfo(stuinfo_stu_onjob stuinfoStuOnJob);

	public boolean deleteJobStudent(String stu_id);

}
