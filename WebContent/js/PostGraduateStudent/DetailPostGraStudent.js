/**
 * 
 */
/* 通过id查看单条记录详细信息 */

function detailPostGraduateStudentById(this_i) {

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

				var postGraStudentListById = JSON.parse(xhr.responseText);
				var input_value = document.getElementsByTagName("input");
				input_value.value = "";
				var new_tr = null;
				var new_td = null;

				stu_account.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_account;
				stu_name.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_name;
				stu_photo.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_photo;
				stu_sex.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_sex;
				stu_bir.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_bir;
				stu_familytype.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_familytype;
				stu_policits.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_policits;
				stu_nation.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_nation;
				stu_idcard.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_idcard;
				stu_phenumber.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_phenumber;
				stu_fathername.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_fathername;
				stu_lev.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_lev;
				stu_change.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_change;
				stu_college.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_college;
				stu_const.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_const;
				stu_major.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_major;
				stu_class_id.value = postGraStudentListById[0].stuinfoStuClass.stu_class_name;
				stu_grade_id.value = postGraStudentListById[0].stuinfoStuGrade.stu_grade_name;
				stu_year.value = postGraStudentListById[0].stuinfoStuBaseinfo.stu_year;

			}

		}
	}
	xhr.open("POST", "/stuinfo/postGraduateStudent/getPostGraduateStudentById");
	var formData = new FormData();
	var this_i_id = this_i.id;
	formData.append("stuinfoStuBaseinfo.stu_id", this_i_id);
	xhr.send(formData);

}