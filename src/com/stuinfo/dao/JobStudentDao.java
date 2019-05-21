package com.stuinfo.dao;

import java.util.List;

import com.stuinfo.domain.DO.stuinfo_stu_onjob;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.JobStudentDTO;

public interface JobStudentDao {
	public List<JobStudentDTO> listJobStudentAll();

	public List<JobStudentDTO> getJobStdentByPage(int pageIdex, int pageSize);

	public List<JobStudentDTO> getSchoolStdentById(String stu_id);

	public boolean UpdateJobStudentBaseInfo(stuinfo_stubaseinfo stuinfoStuBaseinfo);

	public boolean UpdateJobStudentJobInfo(stuinfo_stu_onjob stuinfoStuOnJob);

	public boolean deleteJobStudent(String stu_id);
}
