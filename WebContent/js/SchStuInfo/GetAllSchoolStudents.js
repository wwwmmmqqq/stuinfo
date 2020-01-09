var schoolStudentList = null;
var stu_status = null;
var stu_id = null;
var stu_grade_name = null;
var stu_class_name = null;
function GetAllSchoolStudentsByPageAndSearch(pageIndex) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				schoolStudentList = JSON.parse(xhr.responseText);
				/*
				 * 
				 * 清空原表数据
				 * 
				 */
				var new_tr_list = document.getElementsByClassName("new_tr");
				var long = new_tr_list.length;
				for (var num = 0; num < long; num++) {
					new_tr_list[0].parentNode.removeChild(new_tr_list[0]);
				}

				var school_student_table = document
						.getElementById("school_student_table");
				var new_tr = null;
				var new_td = null;
				for (var num = 0; num < schoolStudentList.StudentDTO.length; num++) {
					stu_id = schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id;
					stu_status = schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_status;
					stu_grade_name = schoolStudentList.StudentDTO[num].stuinfoStuGrade.stu_grade_name;
					stu_class_name = schoolStudentList.StudentDTO[num].stuinfoStuClass.stu_class_name;
					new_tr = document.createElement("tr");
					school_student_table.firstElementChild.appendChild(new_tr);
					new_tr.className = "new_tr";
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = num + 1;

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (schoolStudentList.StudentDTO[num] != undefined
							&& schoolStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_account;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (schoolStudentList.StudentDTO[num] != undefined
							&& schoolStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (schoolStudentList.StudentDTO[num] != undefined
							&& schoolStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_major;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (schoolStudentList.StudentDTO[num] != undefined
							&& schoolStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = schoolStudentList.StudentDTO[num].stuinfoStuGrade.stu_grade_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (schoolStudentList.StudentDTO[num] != undefined
							&& schoolStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = schoolStudentList.StudentDTO[num].stuinfoStuClass.stu_class_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<i class="fa fa-eye" aria-hidden="true"  data-toggle="modal" data-target=".stuinfo" id="'
							+ schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '"  onclick="detailSchoolStuById(this)">'
							+ '</i>&nbsp;&nbsp;'
							+ '<i class="fa fa-pencil"   id="'
							+ schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '" onclick="updateSchoolStudentInfo(this)">'
							+ '</i>&nbsp;&nbsp;'
							+ '<i class="fa fa-trash"   id="'
							+ schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '" onclick="deleteSchoolStudentInfo(this)">'
							+ '</i>'
							+ '<input type="hidden"  name="stu_id">'
							+ '</input>'
				}
			} else {
				alert(xhr.status);
			}
		}
	}
	xhr.open("POST", "/stuinfo/schoolStudent/listSchoolStudentByPage");
	var formData = new FormData();
	if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}

	formData.append("studentInfoVO.pageIndex", pageIndex);
	xhr.send(formData);
}

function flip(flipPage) {
	switch (flipPage) {

	case 1: {
		if (schoolStudentList.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			GetAllSchoolStudentsByPageAndSearch(schoolStudentList.pageIndex - 1);
		}
		break;
	}
	case 2: {
		if (schoolStudentList.pageIndex == schoolStudentList.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			GetAllSchoolStudentsByPageAndSearch(schoolStudentList.pageIndex + 1);
		}
		break;
	}

	}
}

function test() {
	var school_student_table = document.getElementById("school_student_table");
	var lable_input = school_student_table.getElementsByTagName("input");
	for (i = 0; i < lable_input.length; i++) {
		if (lable_input[i].getAttribute('type') == 'checkbox'
				&& lable_input[i].checked) {
		}
	}
}
// 确认搜索
function SureSearch() {
	var stu_account = document.getElementById("account");
	var stu_name = document.getElementById("name");
	var stu_major = document.getElementById("major");
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				schoolStudentList = JSON.parse(xhr.responseText);
				/*
				 * 
				 * 清空原表数据
				 * 
				 */
				var new_tr_list = document.getElementsByClassName("new_tr");
				var long = new_tr_list.length;
				for (var num = 0; num < long; num++) {
					new_tr_list[0].parentNode.removeChild(new_tr_list[0]);
				}

				var school_student_table = document
						.getElementById("school_student_table");
				var new_tr = null;
				var new_td = null;
				for (var num = 0; num < schoolStudentList.StudentDTO.length; num++) {
					stu_id = schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id;
					stu_status = schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_status;
					stu_grade_name = schoolStudentList.StudentDTO[num].stuinfoStuGrade.stu_grade_name;
					stu_class_name = schoolStudentList.StudentDTO[num].stuinfoStuClass.stu_class_name;
					new_tr = document.createElement("tr");
					school_student_table.firstElementChild.appendChild(new_tr);
					new_tr.className = "new_tr";
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = num + 1;

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (schoolStudentList.StudentDTO[num] != undefined
							&& schoolStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_account;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (schoolStudentList.StudentDTO[num] != undefined
							&& schoolStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (schoolStudentList.StudentDTO[num] != undefined
							&& schoolStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_major;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (schoolStudentList.StudentDTO[num] != undefined
							&& schoolStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = schoolStudentList.StudentDTO[num].stuinfoStuGrade.stu_grade_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (schoolStudentList.StudentDTO[num] != undefined
							&& schoolStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = schoolStudentList.StudentDTO[num].stuinfoStuClass.stu_class_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<i class="fa fa-eye" aria-hidden="true"  data-toggle="modal" data-target=".stuinfo" id="'
							+ schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '"  onclick="detailSchoolStuById(this)">'
							+ '</i>&nbsp;&nbsp;'
							+ '<i class="fa fa-pencil"   id="'
							+ schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '" onclick="updateSchoolStudentInfo(this)">'
							+ '</i>&nbsp;&nbsp;'
							+ '<i class="fa fa-trash"   id="'
							+ schoolStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '" onclick="deleteSchoolStudentInfo(this)">'
							+ '</i>'
							+ '<input type="hidden"  name="stu_id">'
							+ '</input>'
				}
			}
		}
	}
	xhr.open("POST", "/stuinfo/schoolStudent/listSchoolStudentByPageAndSearch");
	var formData = new FormData();
	formData.append("studentInfoVO.stu_account", stu_account.value);
	formData.append("studentInfoVO.stu_name", stu_name.value);
	formData.append("studentInfoVO.stu_major", stu_major.value);
	xhr.send(formData);
}