var noJobStudentList = null;

function GetAllNoJobStudentByPageAndSearch(pageIndex) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				noJobStudentList = JSON.parse(xhr.responseText);
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
						.getElementById("nojob_student_table");
				var new_tr = null;
				var new_td = null;
				for (var num = 0; num < noJobStudentList.StudentDTO.length; num++) {
					var stu_id = noJobStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id;
					new_tr = document.createElement("tr");
					school_student_table.firstElementChild.appendChild(new_tr);
					new_tr.className = "new_tr";
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = num + 1;

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (noJobStudentList.StudentDTO[num] != undefined
							&& noJobStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = noJobStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_account;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (noJobStudentList.StudentDTO[num] != undefined
							&& noJobStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = noJobStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (noJobStudentList.StudentDTO[num] != undefined
							&& noJobStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = noJobStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_major;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (noJobStudentList.StudentDTO[num] != undefined
							&& noJobStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = noJobStudentList.StudentDTO[num].stuinfoStuGrade.stu_grade_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (noJobStudentList.StudentDTO[num] != undefined
							&& noJobStudentList.StudentDTO[num] != "") {
						new_td.innerHTML = noJobStudentList.StudentDTO[num].stuinfoStuClass.stu_class_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<i class="fa fa-eye" aria-hidden="true"  data-toggle="modal" data-target=".stuinfo" id="'
							+ noJobStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '"  onclick="detailNoJobStudentById(this)">'
							+ '</i>&nbsp;&nbsp;'
							+ '<i class="fa fa-pencil"   id="'
							+ noJobStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '" onclick="UpdateNoJobStudent(this)">'
							+ '</i>&nbsp;&nbsp;'
							+ '<i class="fa fa-trash"   id="'
							+ noJobStudentList.StudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '" onclick="DeleteNoJobStudent(this)">'
							+ '</i>'
							+ '<input type="hidden"  name="stu_id">'
							+ '</input>'
				}
			} else {
				alert(xhr.status);
			}
		}
	}
	xhr.open("POST", "/stuinfo/noJobStudent/listNoJobStudentByPageAndSearch");
	var formData = new FormData();
	if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}

	formData.append("noJobStudentVO.pageIndex", pageIndex);
	xhr.send(formData);
}

function flip(flipPage) {
	switch (flipPage) {

	case 1: {
		if (noJobStudentList.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			GetAllNoJobStudentByPageAndSearch(noJobStudentList.pageIndex - 1);
		}
		break;
	}
	case 2: {
		if (noJobStudentList.pageIndex == noJobStudentList.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			GetAllNoJobStudentByPageAndSearch(noJobStudentList.pageIndex + 1);
		}
		break;
	}

	}
}