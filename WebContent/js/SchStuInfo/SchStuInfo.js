/* 获取所有学生信息 */
function GetAllSchoolStudents() {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var shoocStudentList = JSON.parse(xhr.responseText);
				/*
				 * 
				 * 清空原表数据
				 * 
				 */
				var new_tr_list = document
						.getElementsByClassName("shool_student_tr");
				var long = new_tr_list.length;
				for (var num = 0; num < long; num++) {
					new_tr_list[0].parentNode.removeChild(new_tr_list[0]);
				}

				var school_student_table = document
						.getElementById("school_student_table");
				var new_tr = null;
				var new_td = null;
				for (var num = 0; num < shoocStudentList.length; num++) {
					var stu_id = shoocStudentList[num].stu_id;
					new_tr = document.createElement("tr");
					school_student_table.firstElementChild.appendChild(new_tr);
					new_tr.className = "grade_tr";
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = num + 1;

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (shoocStudentList[num] != undefined
							&& shoocStudentList[num] != "") {
						new_td.innerHTML = shoocStudentList[num].stuinfoStuBaseinfo.stu_id;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (shoocStudentList[num] != undefined
							&& shoocStudentList[num] != "") {
						new_td.innerHTML = shoocStudentList[num].stuinfoStuBaseinfo.stu_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (shoocStudentList[num] != undefined
							&& shoocStudentList[num] != "") {
						new_td.innerHTML = shoocStudentList[num].stuinfoStuBaseinfo.stu_major;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (shoocStudentList[num] != undefined
							&& shoocStudentList[num] != "") {
						new_td.innerHTML = shoocStudentList[num].stuinfoStuGrade.stu_grade_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (shoocStudentList[num] != undefined
							&& shoocStudentList[num] != "") {
						new_td.innerHTML = shoocStudentList[num].stuinfoStuClass.stu_class_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<i class="fa fa-eye" aria-hidden="true"  data-toggle="modal" data-target=".bs-example-modal-lg">'
							+ '</i>'
							+ '<i class="fa fa-pencil" aria-hidden="true">'
							+ '</i>'
				}
			} else {
				alert(xhr.status);
			}
		}
	}
	xhr.open("POST", "/stuinfo/schoolStudent/listSchoolStudentAll");
	xhr.send(null);

}
/* 通过id查看单条记录详细信息 */
function detailSchoolStuByID() {
	var stu_account = document.getElementsByName('stu_account');
	var stu_name = document.getElementsByName('stu_name');
	var stu_photo = document.getElementsByName('stu_photo');
	var stu_sex = document.getElementsByName('stu_sex');
	var stu_adress = document.getElementsByName('stu_adress');
	var stu_bir = document.getElementsByName('stu_bir');
	var stu_familytype = document.getElementsByName('stu_familytype');
	var stu_nation = document.getElementsByName('stu_nation');
	var stu_policits = document.getElementsByName('stu_policits');
	var stu_idcard = document.getElementsByName('stu_idcard');
	var stu_phenumber = document.getElementsByName('stu_phenumber');
	var stu_fathername = document.getElementsByName('stu_fathername');
	var stu_fathernum = document.getElementsByName('stu_fathernum');
	var stu_lev = document.getElementsByName('stu_lev');
	var stu_change = document.getElementsByName('stu_change');
	var stu_college = document.getElementsByName('stu_college');
	var stu_const = document.getElementsByName('stu_const');
	var stu_major = document.getElementsByName('stu_major');
	var stu_class_id = document.getElementsByName('stu_class_id');
	var stu_grade_id = document.getElementsByName('stu_grade_id');
	var stu_year = document.getElementsByName('stu_year');

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var shoocStudentListById = JSON.parse(xhr.responseText);
				/*
				 * 
				 * 清空原表数据
				 * 
				 */
				var new_tr_list = document
						.getElementsByClassName("school_student_table");
				var long = new_tr_list.length;
				for (var num = 0; num < long; num++) {
					new_tr_list[0].parentNode.removeChild(new_tr_list[0]);
				}

				var school_student_table = document
						.getElementById("school_student_table");
				var new_tr = null;
				var new_td = null;
				for (var num = 0; num < shoocStudentList.length; num++) {

				}
			} else {
				alert(xhr.status);
			}
		}
	}
	xhr.open("POST", "/stuinfo/schoolStudent/listSchoolStudentById");
	xhr.send(null);

}