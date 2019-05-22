var classList = null;
/*
 * 获取所有班级
 */
function Get_Student_Class() {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				classList = JSON.parse(xhr.responseText);
			} else {
				alert(xhr.status);
			}
		}
	}
	xhr.open("POST", "/stuinfo/class/listClassAll");
	xhr.send(null);
}
/* 修改个学生信息 */
function UpdatePostGraStudent(thisStudentInfo) {
	var jc = $
			.confirm({
				columnClass : 'col-md-8 col-md-offset-3',
				title : '学生详细信息',
				content : '<table id="table_stuinfo_update" class="table table-hover" style="text-align: center;width:90%;">'
						+ '<tbody></tbody>' + '</table>',
				buttons : {
					'提交修改' : {
						btnClass : 'btn-blue',
						action : function() {
							var formData = new FormData();
							var xhr = false;
							xhr = new XMLHttpRequest();
							xhr.onreadystatechange = function() {

								var message;
								if (xhr.readyState == 4) {
									if (xhr.status == 200) {
										if (xhr.responseText == "success") {
											alert("更新成功");
											GetAllPostGraduateStudentsByPageAndSearch(postGraduateStudentList.pageIndex);
											jc.close();
										}
									} else {
										alert(xhr.status);
									}
								}

							}
							formData
									.append(
											"stuinfoStuBaseinfo.stu_account",
											document
													.getElementById("stu_account_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_id",
											document
													.getElementById("stu_id_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_name",
											document
													.getElementById("stu_name_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_photo",
											document
													.getElementById("stu_photo_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_sex",
											document
													.getElementById("stu_sex_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_adress",
											document
													.getElementById("stu_adress_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_bir",
											document
													.getElementById("stu_bir_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_familytype",
											document
													.getElementById("stu_familytype_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_nation",
											document
													.getElementById("stu_nation_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_policits",
											document
													.getElementById("stu_policits_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_idcard",
											document
													.getElementById("stu_idcard_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_phenumber",
											document
													.getElementById("stu_phenumber_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_fathername",
											document
													.getElementById("stu_fathername_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_fathernum",
											document
													.getElementById("stu_fathernum_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_mothername",
											document
													.getElementById("stu_mothername_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_mothernum",
											document
													.getElementById("stu_mothernum_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_lev",
											document
													.getElementById("stu_lev_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_college",
											document
													.getElementById("stu_college_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_const",
											document
													.getElementById("stu_const_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_major",
											document
													.getElementById("stu_major_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_const",
											document
													.getElementById("stu_const_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_grade",
											document
													.getElementById("stu_grade_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_class_id",
											document
													.getElementById("stu_class_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_year",
											document
													.getElementById("stu_year_modify").value);
							formData
									.append(
											"stuinfoStuBaseinfo.stu_change",
											document
													.getElementById("stu_change_modify").value);

							xhr
									.open("POST",
											"/stuinfo/postGraduateStudent/UpdatePostGraduateStudentById");

							xhr.send(formData);
							/*
							 * 
							 */
							return false;

						}
					},
					'返回 ' : function() {
					}
				},
				/*
				 * 修改前显示信息
				 */
				onContentReady : function() {
					var xhr = false;
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange = function() {

						var message;
						if (xhr.readyState == 4) {
							if (xhr.status == 200) {

								var postGraStudentById = JSON
										.parse(xhr.responseText);
								var new_tr_1 = null;
								var table_stuinfo_update = document
										.getElementById("table_stuinfo_update");
								table_stuinfo_update.firstElementChild.innerHTML = "";
								if (postGraStudentById[0].stuinfoStuBaseinfo.stu_id == thisStudentInfo.id) {

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>学号：</td>'
											+ '<td><input class="form-control  "  id="stu_account_modify"  value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_account
											+ '"></td>'
											+ '<td><input class="form-control  " type="hidden" id="stu_id_modify"  value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_id
											+ '"></td>'

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>姓名：</td>'
											+ '<td><input class="form-control  "  id="stu_name_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_name
											+ '"></td>'
											+ '<td>照片：</td>'
											+ '<input class="form-control  " id="stu_photo_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_photo
											+ '" >'

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>性别：</td>'
											+ '<td>'
											+ '<select class="form-control " id="stu_sex_modify">'
											+ '<option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_sex
											+ '">男</option><option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_sex
											+ '">女</option>'
											+ '</select>'
											+ '</td>'
											+ '<td>家庭住址：</td>'
											+ '<td><input class="form-control  " id="stu_adress_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_adress
											+ '" ></td>'
									var select = document
											.getElementById("stu_sex_modify");
									var options = select.options;
									for (i = 0; i < options.length; i++) {
										var value_i = options[i].value;
										var text_i = options[i].text;
										if (value_i == text_i) {
											options[i].selected = "selected";
										}
									}

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>出生年月：</td>'
											+ '<td><input class="form-control laydate-icon"  id="stu_bir_modify"  type="text" onclick="time()" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_bir
											+ '"></td>'
											+ '<td>户口类型：</td>'
											+ '<td>'
											+ '<select class="form-control " id="stu_familytype_modify" >'
											+ '<option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_familytype
											+ '">农村</option><option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_familytype
											+ '">城镇</option>' + '</select>'
											+ '</td>'
									var select = document
											.getElementById("stu_familytype");
									var options = select.options;
									for (i = 0; i < options.length; i++) {
										var value_i = options[i].value;
										var text_i = options[i].text;
										if (value_i == text_i) {
											options[i].selected = "selected";
										}
									}

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>民族：</td>'
											+ '<td><input class="form-control  "  id="stu_nation_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_nation
											+ '"></td>'
											+ '<td>政治面貌：</td>'
											+ '<td>'
											+ '<select class="form-control " id="stu_policits_modify" >'
											+ '<option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_policits
											+ '">共青团员</option><option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_policits
											+ '">中共中央预备党员</option><option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_policits
											+ '">中共中央党员</option><option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_policits
											+ '">群众</option>' + '</select>'
											+ '</td>'
									var select = document
											.getElementById("stu_policits_modify");
									var options = select.options;
									for (i = 0; i < options.length; i++) {
										var value_i = options[i].value;
										var text_i = options[i].text;
										if (value_i == text_i) {
											options[i].selected = "selected";
										}
									}

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>证件号码：</td>'
											+ '<td><input class="form-control  "  id="stu_idcard_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_idcard
											+ '"></td>'
											+ '<td>本人联系电话：</td>'
											+ '<input class="form-control  " id="stu_phenumber_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_phenumber
											+ '" >'

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>父亲姓名：</td>'
											+ '<td><input class="form-control  "  id="stu_fathername_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_fathername
											+ '"></td>'
											+ '<td>父亲联系电话：</td>'
											+ '<input class="form-control  " id="stu_fathernum_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_fathernum
											+ '" >'

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>母亲姓名：</td>'
											+ '<td><input class="form-control  "  id="stu_mothername_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_mothername
											+ '"></td>'
											+ '<td>母亲联系电话：</td>'
											+ '<input class="form-control  " id="stu_mothernum_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_mothernum
											+ '" >'

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>层次：</td>'
											+ '<td>'
											+ '<select class="form-control " id="stu_lev_modify">'
											+ '<option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_lev
											+ '">本科</option><option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_lev
											+ '">专科</option>'
											+ '</select>'
											+ '</td>'
											+ '<td>学校：</td>'
											+ '<td><input class="form-control  " id="stu_college_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_college
											+ '" ></td>'
									var select = document
											.getElementById("stu_lev_modify");
									var options = select.options;
									for (i = 0; i < options.length; i++) {
										var value_i = options[i].value;
										var text_i = options[i].text;
										if (value_i == text_i) {
											options[i].selected = "selected";
										}
									}

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>学院：</td>'
											+ '<td><input class="form-control  "  id="stu_const_modify" type="text" ></td>'
											+ '<td>专业：</td>'
											+ '<td>'
											+ '<select class="form-control " id="stu_major_modify" >'
											+ '<option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_major
											+ '">软件工程</option><option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_major
											+ '">数字媒体技术</option><option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_major
											+ '">软件技术</option><option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_major
											+ '">数字媒体应用技术</option><option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_major
											+ '">计算机信息管理</option>'
											+ '</select>' + '</td>'
									var select = document
											.getElementById("stu_major_modify");
									var options = select.options;
									for (i = 0; i < options.length; i++) {
										var value_i = options[i].value;
										var text_i = options[i].text;
										if (value_i == text_i) {
											options[i].selected = "selected";
										}
									}

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>年级：</td>'
											+ '<td><select id="stu_grade_modify" class="form-control"></select></td>'
											+ '<td>班级：</td>'
											+ '<td><select id="stu_class_modify" class="form-control" ></select></td>'

									for (var num1 = 0; num1 < classList.length; num1++) {

										var option = document
												.createElement("option");
										option
												.appendChild(document
														.createTextNode(classList[num1].stuinfoStuGrade.stu_grade_name));
										document.getElementById(
												"stu_grade_modify")
												.appendChild(option);
										option.value = classList[num1].stuinfoStuGrade.stu_grade_id;
										if (option.value == postGraStudentById[0].stuinfoStuGrade.stu_grade_id) {
											option.selected = "selected";
										}

										var option = document
												.createElement("option");
										option
												.appendChild(document
														.createTextNode(classList[num1].stuinfoStuClass.stu_class_name));
										document.getElementById(
												"stu_class_modify")
												.appendChild(option);
										option.value = classList[num1].stuinfoStuClass.stu_class_id;
										if (option.value == postGraStudentById[0].stuinfoStuGrade.stu_class_id) {
											option.selected = "selected";
										}
									}

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>学制：</td>'
											+ '<td>'
											+ '<select class="form-control " id="stu_year_modify">'
											+ '<option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_year
											+ '">三年</option><option value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_year
											+ '">四年</option>'
											+ '</select>'
											+ '</td>'
											+ '<td>学籍异动：</td>'
											+ '<td><input class="form-control  " id="stu_change_modify" type="text" value="'
											+ postGraStudentById[0].stuinfoStuBaseinfo.stu_change
											+ '" ></td>'

									var select = document
											.getElementById("stu_year_modify   ");
									var options = select.options;
									for (i = 0; i < options.length; i++) {
										var value_i = options[i].value;
										var text_i = options[i].text;
										if (value_i == text_i) {
											options[i].selected = "selected";
										}
									}

								}

							} else {
								alert(xhr.status);
							}
						}
					}
					xhr
							.open("POST",
									"/stuinfo/postGraduateStudent/getPostGraduateStudentById");
					var formData = new FormData();
					var this_i_id = thisStudentInfo.id;
					formData.append("stuinfoStuBaseinfo.stu_id", this_i_id);
					xhr.send(formData);

				}
			});

}
