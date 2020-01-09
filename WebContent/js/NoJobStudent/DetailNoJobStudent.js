/**
 * 
 */
/* 通过id查看单条记录详细信息 */

function detailNoJobStudentById(this_i) {

	var stu_account = document.getElementById('stu_account');
	var stu_name = document.getElementById('stu_name');
	var stu_photo = document.getElementById('stu_photo');
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

				var noJobStudentListById = JSON.parse(xhr.responseText);
				var modal_nojob_student_table = document
						.getElementById("modal_nojob_student_table");
				var input_value = document.getElementsByTagName("input");
				input_value.value = "";
				var new_tr = null;
				var new_td = null;

				stu_account.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_account;
				stu_name.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_name;
				stu_photo.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_photo;
				stu_sex.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_sex;
				stu_adress.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_adress;
				stu_fathernum.value == noJobStudentListById[0].stuinfoStuBaseinfo.stu_fathernum;
				stu_bir.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_bir;
				stu_familytype.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_familytype;
				stu_policits.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_policits;
				stu_nation.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_nation;
				stu_idcard.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_idcard;
				stu_phenumber.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_phenumber;
				stu_fathername.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_fathername;
				stu_lev.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_lev;
				stu_change.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_change;
				stu_college.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_college;
				stu_const.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_const;
				stu_major.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_major;
				stu_class_id.value = noJobStudentListById[0].stuinfoStuClass.stu_class_name;
				stu_grade_id.value = noJobStudentListById[0].stuinfoStuGrade.stu_grade_name;
				stu_year.value = noJobStudentListById[0].stuinfoStuBaseinfo.stu_year;

			}

		}
	}
	xhr.open("POST", "/stuinfo/noJobStudent/getNoJobstudentById");
	var formData = new FormData();
	var this_i_id = this_i.id;
	formData.append("stuinfoStuBaseinfo.stu_id", this_i_id);
	xhr.send(formData);

}