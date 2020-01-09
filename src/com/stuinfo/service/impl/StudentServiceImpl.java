package com.stuinfo.service.impl;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.stuinfo.dao.StudentDao;
import com.stuinfo.domain.DO.stuinfo_notice;
import com.stuinfo.domain.DO.stuinfo_stu_onjob;
import com.stuinfo.domain.DO.stuinfo_stubaseinfo;
import com.stuinfo.domain.DTO.StudentDTO;
import com.stuinfo.domain.VO.StudentFiled;
import com.stuinfo.domain.VO.StudentInfoVO;
import com.stuinfo.service.StudentService;

import util.TeamUtil;
import util.md5;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public boolean StudentAddJobInfo(String stu_id, stuinfo_stu_onjob stuinfoStuOnjob) {
		stuinfoStuOnjob.setStu_id(stu_id);
		stuinfoStuOnjob.setStu_job_id(TeamUtil.getUuid());
		stuinfoStuOnjob.setStu_job_infocreate(TeamUtil.getStringSecond());
		studentDao.saveObj(stuinfoStuOnjob);
		return true;
	}

	@Override
	public List<List<String>> getListString(List<StudentFiled> studentFiled) {
		studentDao.getListString(studentFiled);
		return null;
	}

	@Override
	public boolean addNotice(StudentDTO studentDTO, stuinfo_notice stuinfoNotice) {
		stuinfoNotice.setNotice_id(TeamUtil.getUuid());
		stuinfoNotice.setNotice_stu_grade(studentDTO.getStuinfoStuGrade().getStu_grade_name());
		stuinfoNotice.setNotice_stu_major(studentDTO.getStuinfoStuBaseinfo().getStu_major());
		stuinfoNotice.setNotice_stu_class(studentDTO.getStuinfoStuClass().getStu_class_name());
		stuinfoNotice.setNotice_stu_account(studentDTO.getStuinfoStuBaseinfo().getStu_account());
		stuinfoNotice.setNotice_stu_name(studentDTO.getStuinfoStuBaseinfo().getStu_name());
		stuinfoNotice.setNotice_status("1");
		/* stuinfoNotice.setNotice_content("添加了工作记录"); */
		stuinfoNotice.setNotice_infocreate(TeamUtil.getStringSecond());
		studentDao.saveObj(stuinfoNotice);
		return true;
	}

	@Override
	public boolean UpdatePassword(String stu_id, String newPassword) {
		boolean flag = false;
		if (stu_id == null || stu_id.trim().length() <= 0) {
			return false;
		}
		if (newPassword == null || newPassword.trim().length() <= 0) {
			return false;
		}
		flag = studentDao.UpdatePassword(stu_id, md5.GetMD5Code(newPassword), TeamUtil.getStringSecond());
		return flag;
	}
	/*
	 * @Override public boolean StudentAddJobInfoAndNotice(StudentDTO
	 * studentDTO, JobInfoAndNotice jobInfoAndNotice) {
	 * jobInfoAndNotice.setStuinfoStuOnjob(stuinfoStuOnjob); return false; }
	 */

	@Override
	public List<stuinfo_stubaseinfo> GetJobRecodeById(String stu_id) {
		return studentDao.GetJobRecodeById(stu_id);
	}

	@Override
	public StudentInfoVO<StudentDTO> findNoPage(StudentDTO stdo) {
		System.out.println("aa" + stdo);
		StudentInfoVO<StudentDTO> studentInfoPage = new StudentInfoVO<StudentDTO>();

		// 封装当前页数

		// 每页显示的记录数
		// 封装每页显示 的记录数

		// 查询总记录数
		int totalRecords = studentDao.findCount(stdo.getStuinfo_stubaseinfo().getStu_status());
		// 封装总记录数
		studentInfoPage.setTotalRecords(totalRecords);

		// 查询总页数
		// 封装总页数

		// 按当前页面，查询当前页面记录
		List<StudentDTO> studentList = studentDao.findNoPage(stdo);
		// 封装当前页面记录
		studentInfoPage.setStudentList(studentList);
		System.out.println("sasa" + studentList);
		return studentInfoPage;
	}

	@Override
	public void writeStudentInformation(StudentInfoVO<StudentDTO> studentPage, StudentFiled studentFiled,
			HSSFWorkbook wb) {

		// 第二步，在webbook中添加一个sheet，对应Excel文件中的 sheet
		HSSFSheet sheet = wb.createSheet("测试表格1");
		// 第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行数列数有限制
		HSSFRow row = sheet.createRow(0);

		// 第五步，创建表头单元格，并设置样式
		HSSFCell cell;

		// 表头数
		int sheetHead_num = 0;

		/**
		 * 设置表头
		 */
		if (studentFiled.getStu_account_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("学号");
		}
		if (studentFiled.getStu_name_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("姓名");
		}
		if (studentFiled.getStu_sex_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("性别");
		}
		if (studentFiled.getStu_adress_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("家庭地址");
		}
		if (studentFiled.getStu_bir_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("出生日期");
		}
		if (studentFiled.getStu_familytype_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("户口类型");
		}
		if (studentFiled.getStu_nation_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("民族");
		}
		if (studentFiled.getStu_policits_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("政治面貌");
		}
		if (studentFiled.getStu_idcard_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("身份证号");
		}
		if (studentFiled.getStu_phenumber_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("手机号码");
		}
		if (studentFiled.getStu_fathername_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("父亲姓名");
		}
		if (studentFiled.getStu_fathernum_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("父亲联系方式");
		}
		if (studentFiled.getStu_mothername_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("母亲姓名");
		}
		if (studentFiled.getStu_mothernum_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("母亲联系方式");
		}
		if (studentFiled.getStu_lev_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("层次");
		}
		if (studentFiled.getStu_change_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("学籍异动");
		}
		if (studentFiled.getStu_college_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("学校");
		}
		if (studentFiled.getStu_const_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("学院");
		}
		if (studentFiled.getStu_grade_name_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("年级");
		}
		if (studentFiled.getStu_class_name_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("班级");
		}
		if (studentFiled.getStu_year_field() == 1) {
			cell = row.createCell(sheetHead_num++);
			cell.setCellValue("学制");
		}
		/**
		 * 写入数据
		 */
		int listNum = 1;
		System.out.println("sdsd" + studentPage.getStudentList());
		for (StudentDTO student : studentPage.getStudentList()) {
			sheetHead_num = 0;
			row = sheet.createRow(listNum++);

			if (studentFiled.getStu_account_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_account());
			}
			if (studentFiled.getStu_name_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_name());
			}
			if (studentFiled.getStu_sex_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_sex());
			}
			if (studentFiled.getStu_adress_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_adress());
			}
			if (studentFiled.getStu_bir_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_bir());
			}
			if (studentFiled.getStu_familytype_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_familytype());
			}
			if (studentFiled.getStu_nation_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_nation());
			}
			if (studentFiled.getStu_policits_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_policits());
			}
			if (studentFiled.getStu_idcard_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_idcard());
			}
			if (studentFiled.getStu_phenumber_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_phenumber());
			}
			if (studentFiled.getStu_fathername_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_fathername());
			}
			if (studentFiled.getStu_fathernum_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_fathernum());
			}
			if (studentFiled.getStu_mothername_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_mothername());
			}
			if (studentFiled.getStu_mothernum_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_mothernum());
			}
			if (studentFiled.getStu_lev_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_lev());
			}
			if (studentFiled.getStu_change_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_change());
			}
			if (studentFiled.getStu_college_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_college());
			}
			if (studentFiled.getStu_const_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_const());
			}
			if (studentFiled.getStu_grade_name_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfoStuGrade().getStu_grade_name());
			}
			if (studentFiled.getStu_class_name_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfoStuClass().getStu_class_name());
			}
			if (studentFiled.getStu_year_field() == 1) {
				cell = row.createCell(sheetHead_num++);
				cell.setCellValue(student.getStuinfo_stubaseinfo().getStu_year());
			}

		}

	}

	@Override
	public int insertInfoToDB(List<Object> list) {
		studentDao.insertInfoToDB(list);
		return 0;
	}

}
