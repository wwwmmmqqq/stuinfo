/* 获取所有年级 */
function Get_Student_Grade(select) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var gradeList = JSON.parse(xhr.responseText);
				/*
				 * 
				 * 清空原表数据
				 * 
				 */
				var new_tr_list = document.getElementsByClassName("grade_tr");
				var long = new_tr_list.length;
				for (var num = 0; num < long; num++) {
					new_tr_list[0].parentNode.removeChild(new_tr_list[0]);
				}

				var grade_table = document.getElementById("grade_table");
				var new_tr = null;
				var new_td = null;
				for (var num = 0; num < gradeList.length; num++) {
					var stu_grade_id = gradeList[num].stu_grade_id;
					new_tr = document.createElement("tr");
					grade_table.firstElementChild.appendChild(new_tr);
					new_tr.className = "grade_tr";

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);

					new_td.innerHTML = num + 1;

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (gradeList[num] != undefined && gradeList[num] != "") {
						new_td.innerHTML = gradeList[num].stu_grade_name;
					} else {
						new_td.innerHTML = '无';
					}
				}
			} else {
				alert(xhr.status);
			}
		}
	}
	xhr.open("POST", "/stuinfo/grade/listGradeAll");
	xhr.send(null);
}
/* 添加年级 */
function Add_Student_Grade() {
	var formData = new FormData();
	var xhr = false;
	xhr = new XMLHttpRequest();

	xhr.open("POST", "/stuinfo/grade/CreateGrade");
	var grade_input = document.getElementById('grade_input')
	if (!grade_input.value == "") {
		formData.append("newGrade.stu_grade_name", grade_input.value);
	}

	xhr.send(formData);
}
