/* 获取所有班级 */
function Get_Student_Class() {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var classList = JSON.parse(xhr.responseText);
				/*
				 * 
				 * 清空原表数据
				 * 
				 */
				var new_tr_list = document.getElementsByClassName("class_tr");
				var long = new_tr_list.length;
				for (var num = 0; num < long; num++) {
					new_tr_list[0].parentNode.removeChild(new_tr_list[0]);
				}

				var class_table = document.getElementById("class_table");
				var new_tr = null;
				var new_td = null;
				for (var num = 0; num < classList.length; num++) {
					var stu_class_id = classList[num].stu_class_id;
					new_tr = document.createElement("tr");
					class_table.firstElementChild.appendChild(new_tr);
					new_tr.className = "class_tr";
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = num + 1;
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (classList[num] != undefined && classList[num] != "") {
						new_td.innerHTML = classList[num].stuinfoStuGrade.stu_grade_name;
					} else {
						new_td.innerHTML = '无';
					}
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (classList[num] != undefined && classList[num] != "") {
						new_td.innerHTML = classList[num].stuinfoStuClass.stu_class_name;
					} else {
						new_td.innerHTML = '无';
					}
				}
			} else {
				alert(xhr.status);
			}
		}
	}
	xhr.open("POST", "/stuinfo/class/listClassAll");
	xhr.send(null);
}
/* 获取到年级写入select内 */
function getGradeToSelect() {
	var grade_select = document.getElementById("grade_select");
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var gradeList = JSON.parse(xhr.responseText);
				var new_tr = null;
				var new_td = null;
				for (var num = 0; num < gradeList.length; num++) {
					grade_option = document.getElementById("grade_option");
					new_option = document.createElement("option");
					grade_option.appendChild(new_option);
					if (gradeList[num] != undefined && gradeList[num] != "") {
						new_option.value = gradeList[num].stu_grade_id;
						new_option.text = gradeList[num].stu_grade_name;
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
// 添加班级
function AddStudentClass() {
	getGradeToSelect();
	var jc = $
			.confirm({
				columnClass : 'col-md-4 col-md-offset-3',
				title : '添加班级',
				content : '<div class="form-group" id="grade_select">'
						+ '<select class="form-control" id="grade_option">'
						+ '</select>'
						+ '</div>'
						+ '<div class="form-group">'
						+ '<input type="text" id="class_input" class="form-control" placeholder="请输入班级" required>'
						+ '</div>',
				buttons : {
					'确认添加' : {
						btnClass : 'btn btn-success',
						action : function() {
							var formData = new FormData();
							var xhr = false;
							xhr = new XMLHttpRequest();
							var grade_obj = document
									.getElementById('grade_option');
							var grade_index = grade_obj.selectedIndex; // 选中索引
							var grade_text = grade_obj.options[grade_index].text; // 选中文本
							var grade_value = grade_obj.options[grade_index].value; // 选中值
							xhr.onreadystatechange = function() {
								var message;
								if (xhr.readyState == 4) {
									if (xhr.status == 200) {
										if (xhr.responseText == "success") {
											toastr.success("添加成功！");
											Get_Student_Class();
											jc.close();
										}
									} else {
										alert(xhr.status);
									}
								}
							}
							var class_input = document
									.getElementById('class_input');
							if (!class_input.value == "") {
								formData.append("newClass.stu_class_name",
										class_input.value);
							}
							if (!grade_value == "") {
								formData.append("newClass.stu_grade_id",
										grade_value);
							}
							xhr.open("POST", "/stuinfo/class/CreateClass");
							xhr.send(formData);

						}
					},
					'返回 ' : function() {
					}
				}
			})
}