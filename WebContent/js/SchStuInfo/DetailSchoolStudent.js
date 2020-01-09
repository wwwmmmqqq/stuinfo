/**
 * 
 */
/* 通过id查看单条记录详细信息 */

function detailSchoolStuById(this_i) {

	var stu_account = document.getElementById('stu_account');
	var stu_name = document.getElementById('stu_name');
	var stu_sex = document.getElementById('stu_sex');
	var stu_adress = document.getElementById('stu_adress');
	var stu_bir = document.getElementById('stu_bir');
	var stu_familytype = document.getElementById('stu_familytype');
	var stu_nation = document.getElementById('stu_nation');
	var stu_policits = document.getElementById('stu_policits');
	var stu_idcard = document.getElementById('stu_idcard');
	var stu_phenumber = document.getElementById('stu_phenumber');
	var stu_fathername = document.getElementById('stu_fathername');
	var stu_fathernum = document.getElementById('stu_fathernum');
	var stu_lev = document.getElementById('stu_lev');
	var stu_change = document.getElementById('stu_change');
	var stu_college = document.getElementById('stu_college');
	var stu_const = document.getElementById('stu_const');
	var stu_major = document.getElementById('stu_major');
	var stu_class_id = document.getElementById('stu_class_id');
	var stu_grade_id = document.getElementById('stu_grade_id');
	var stu_year = document.getElementById('stu_year');

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {

				var schoolStudentListById = JSON.parse(xhr.responseText);
				var input_value = document.getElementsByTagName("input");
				input_value.value = "";
				var new_tr = null;
				var new_td = null;

				stu_account.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_account;
				stu_name.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_name;
				stu_sex.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_sex;
				stu_adress.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_adress;
				stu_bir.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_bir;
				stu_familytype.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_familytype;
				stu_policits.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_policits;
				stu_nation.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_nation;
				stu_idcard.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_idcard;
				stu_phenumber.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_phenumber;
				stu_fathername.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_fathername;
				stu_adress.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_adress;
				stu_fathernum.value == schoolStudentListById[0].stuinfoStuBaseinfo.stu_fathernum;
				stu_lev.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_lev;
				stu_change.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_change;
				stu_college.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_college;
				stu_const.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_const;
				stu_major.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_major;
				stu_class_id.value = schoolStudentListById[0].stuinfoStuClass.stu_class_name;
				stu_grade_id.value = schoolStudentListById[0].stuinfoStuGrade.stu_grade_name;
				stu_year.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_year;

				var lable_input = document.getElementsByTagName("input");
				for (i = 0; i < lable_input.length; i++) {
					if (lable_input[i].value == "undefined"
							|| lable_input[i].value == "") {
						lable_input[i].value = "无"
					}

				}
			}

		}
	}
	xhr.open("POST", "/stuinfo/schoolStudent/getSchoolStuById");
	var formData = new FormData();
	var this_i_id = this_i.id;
	formData.append("stuinfoStuBaseinfo.stu_id", this_i_id);
	xhr.send(formData);

}