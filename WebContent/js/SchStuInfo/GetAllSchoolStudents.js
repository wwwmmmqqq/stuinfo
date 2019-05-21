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
	xhr.open("POST", "/stuinfo/schoolStudent/listSchoolStudentByPageAndSearch");
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
			alert("已经是第一页了");
		} else {
			GetAllSchoolStudentsByPageAndSearch(schoolStudentList.pageIndex - 1);
		}
		break;
	}
	case 2: {
		if (schoolStudentList.pageIndex == schoolStudentList.totalPages) {
			alert("已经是最后一页了");
		} else {
			GetAllSchoolStudentsByPageAndSearch(schoolStudentList.pageIndex + 1);
		}
		break;
	}

	}
}

// 选择所要导出的字段
function ChooseInfoToExcel() {
	var to_excel_tltle = document.getElementById("to_excel_tltle");

	// 先清除
	to_excel_tltle.innerHTML = "";

	var table_1 = document.createElement("table");

	var form_1 = document.createElement("form");
	to_excel_tltle.appendChild(form_1);
	form_1.method = "post";
	form_1.id = "export_form";
	form_1.appendChild(table_1);
	table_1.className = "table";
	table_1.id = "check_table";
	table_1.innerHTML = '<tr class="border_tr">'
			+ '<td><input type="checkbox" onclick="AllChecked()" /> <label>全选</label></td>'
			+ '<td><input type="checkbox"  onclick="AgainChecked(this)"/> <label>反选</label></td>'
			+ '<td></td>'
			+ '<td></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td><input type="checkbox" name="studentFiled.stu_account_field" value="1"/> <label>学号</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_name_field" value="1"/> <label>姓名</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_sex_field" value="1"/> <label>性别</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_adress_field" value="1"/> <label>家庭住址</label></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td><input type="checkbox" name="studentFiled.stu_bir_field" value="1"/> <label>出生年月</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_familytype_field" value="1"/> <label>户口类型</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_nation_field" value="1"/> <label>民族</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_policits_field" value="1"/> <label>政治面貌</label></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td><input type="checkbox" name="studentFiled.stu_idcard_field" value="1"/> <label>证件号码</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_phenumber_field" value="1"/> <label>本人联系电话</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_fathername_field" value="1"/> <label>父亲姓名</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_fathernum_field" value="1"/> <label>父亲联系电话</label></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td><input type="checkbox" name="studentFiled.stu_mothername_field" value="1"/> <label>母亲姓名</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_mothernum_field" value="1"/> <label>母亲联系电话</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_lev_field" value="1"/> <label>层次</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_college_field" value="1"/> <label>学校</label></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td><input type="checkbox"  name="studentFiled.stu_const_field" value="1"/> <label>学院</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_major_field" value="1"/> <label>专业</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_grade_name_field" value="1"/> <label>年级</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_class_name_field" value="1"/> <label>班级</label></td>'
			+ '</tr>'
			+ '<tr class="border_tr">'
			+ '<td><input type="checkbox" name="studentFiled.stu_year_field" value="1"/> <label>学制</label></td>'
			+ '<td><input type="checkbox" name="studentFiled.stu_change_field" value="1"/> <label>学籍异动</label></td>'
			+ '<td><input type="hidden" name="studentFiled.stu_class_id_field" value="1"/> </td>'
			+ '</tr>'
}
// 全选
function AllChecked() {
	var check_table = document.getElementById("check_table");
	var check_lable = check_table.getElementsByTagName("input");

	for (i = 2; i < check_lable.length; i++) {
		check_lable[i].checked = check_lable[0].checked;
	}
}
// 反选
function AgainChecked(thisCheck) {
	var check_table = document.getElementById("check_table");
	var check_lable = check_table.getElementsByTagName("input");
	for (i = 2; i < check_lable.length; i++) {
		check_lable[i].checked = !check_lable[i].checked;
	}
}
// 点击确认后
function SureExport() {
	var export_to_excel = document.getElementById("export_to_excel");
	var school_student_table = document.getElementById("school_student_table");
	var lable_tr = school_student_table.getElementsByTagName("tr");
	var lable_input = school_student_table.getElementsByTagName("input");

	var first_tr_td = school_student_table.getElementsByTagName("tr")[0].cells[0];
	first_tr_td.innerHTML = '<input type="checkbox"  id="all_check" onclick="AllCheckA()"/><lable>全选</lable>'
	var all_check = document.getElementById("all_check");
	for (i = 1; i < lable_tr.length; i++) {
		lable_tr[i].cells[0].innerHTML = '<input type="checkbox" value="' + i
				+ '"/>'
		lable_tr[i].onclick = function() {
			for (j = 0; j < this.children.length; j++) {
				this.children[j].children[0].checked = !this.children[j].children[0].checked;
			}
		}
	}

	export_to_excel.className = "btn btn-success btn_to_excel "
	export_to_excel.innerHTML = '确认导出'

}
function AllCheckA() {
	var lable_input = school_student_table.getElementsByTagName("input");
	for (i = 1; i < lable_input.length; i++) {
		lable_input[i].checked = lable_input[0].checked;
	}
}
// 确认导出
function ConfirmExport() {
	var export_form = document.getElementById("export_form");
	export_form.action = "/stuinfo/student/StuinfoExportToExcel?stdo.stuinfoStuBaseinfo.stu_status="
			+ stu_status;
	export_form.submit();
}
function test() {
	var school_student_table = document.getElementById("school_student_table");
	var lable_input = school_student_table.getElementsByTagName("input");
	for (i = 0; i < lable_input.length; i++) {
		if (lable_input[i].getAttribute('type') == 'checkbox'
				&& lable_input[i].checked) {
			alert(lable_input[i].value);
		}
	}
}