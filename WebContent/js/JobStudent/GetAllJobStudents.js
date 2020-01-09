var jobStudentList = null;
function GetAllJobStudentsByPageAndSearch(pageIndex) {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				jobStudentList = JSON.parse(xhr.responseText);
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
						.getElementById("job_student_table");
				var new_tr = null;
				var new_td = null;
				for (var num = 0; num < jobStudentList.jobStudentDTO.length; num++) {

					var stu_id = jobStudentList.jobStudentDTO[num].stuinfoStuBaseinfo.stu_id;
					new_tr = document.createElement("tr");
					school_student_table.firstElementChild.appendChild(new_tr);
					new_tr.className = "new_tr";
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = num + 1;

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (jobStudentList.jobStudentDTO[num] != undefined
							&& jobStudentList.jobStudentDTO[num] != "") {
						new_td.innerHTML = jobStudentList.jobStudentDTO[num].stuinfoStuBaseinfo.stu_account;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (jobStudentList.jobStudentDTO[num] != undefined
							&& jobStudentList.jobStudentDTO[num] != "") {
						new_td.innerHTML = jobStudentList.jobStudentDTO[num].stuinfoStuBaseinfo.stu_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (jobStudentList.jobStudentDTO[num] != undefined
							&& jobStudentList.jobStudentDTO[num] != "") {
						new_td.innerHTML = jobStudentList.jobStudentDTO[num].stuinfoStuBaseinfo.stu_major;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (jobStudentList.jobStudentDTO[num] != undefined
							&& jobStudentList.jobStudentDTO[num] != "") {
						new_td.innerHTML = jobStudentList.jobStudentDTO[num].stuinfoStuGrade.stu_grade_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (jobStudentList.jobStudentDTO[num] != undefined
							&& jobStudentList.jobStudentDTO[num] != "") {
						new_td.innerHTML = jobStudentList.jobStudentDTO[num].stuinfoStuClass.stu_class_name;
					} else {
						new_td.innerHTML = '无';
					}

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<a href="jobStudent/jumpTodetail?stuinfoStuBaseinfo.stu_id='
							+ jobStudentList.jobStudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '">'
							+ '<i class="fa fa-eye"   >'
							+ '</i>'
							+ '</a>&nbsp;&nbsp;'
							+ '<a href="jobStudent/jumpToUpdate?stuinfoStuBaseinfo.stu_id='
							+ jobStudentList.jobStudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '">'
							+ '<i class="fa fa-pencil"   id="'
							+ jobStudentList.jobStudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '" >'
							+ '</i>'
							+ '</a>&nbsp;&nbsp;'
							+ '<i class="fa fa-trash"   id="'
							+ jobStudentList.jobStudentDTO[num].stuinfoStuBaseinfo.stu_id
							+ '" onclick="DeleteJobStudent(this)" >'
							+ '</i>'
							+ '<input type="hidden"  name="stu_id">'
							+ '</input>'

				}
			} else {
				alert(xhr.status);
			}
		}
	}

	xhr.open("POST", "/stuinfo/jobStudent/listJobStudentByPageAndSearch");

	var formData = new FormData();
	if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}

	formData.append("jobStudentVO.pageIndex", pageIndex);
	xhr.send(formData);

}
function flip(flipPage) {
	switch (flipPage) {

	case 1: {
		if (jobStudentList.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			GetAllJobStudentsByPageAndSearch(jobStudentList.pageIndex - 1);
		}
		break;
	}
	case 2: {
		if (jobStudentList.pageIndex == jobStudentList.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			GetAllJobStudentsByPageAndSearch(jobStudentList.pageIndex + 1);
		}
		break;
	}

	}
}