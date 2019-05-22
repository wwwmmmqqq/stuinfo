var this_stu_id = null;
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
function UpdateJobStudentBaseInfo() {
	this_stu_id = window.location.search.substr(27);
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
											"/stuinfo/jobStudent/UpdateJobStudentBaseInfo");

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

								var jobStudentBaseListById = JSON
										.parse(xhr.responseText);
								var new_tr_1 = null;
								var table_stuinfo_update = document
										.getElementById("table_stuinfo_update");
								table_stuinfo_update.firstElementChild.innerHTML = "";

								if (jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_id == this_stu_id) {

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>学号：</td>'
											+ '<td><input class="form-control  "  id="stu_account_modify"  value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_account
											+ '"></td>'
											+ '<td><input class="form-control  " type="hidden" id="stu_id_modify"  value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_id
											+ '"></td>'

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>姓名：</td>'
											+ '<td><input class="form-control  "  id="stu_name_modify" type="text" value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_name
											+ '"></td>'
											+ '<td>照片：</td>'
											+ '<input class="form-control  " id="stu_photo_modify" type="text" value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_photo
											+ '" >'

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>性别：</td>'
											+ '<td>'
											+ '<select class="form-control " id="stu_sex_modify">'
											+ '<option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_sex
											+ '">男</option><option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_sex
											+ '">女</option>'
											+ '</select>'
											+ '</td>'
											+ '<td>家庭住址：</td>'
											+ '<td><input class="form-control  " id="stu_adress_modify" type="text" value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_adress
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
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_bir
											+ '"></td>'
											+ '<td>'
											+ '<select class="form-control " id="stu_familytype_modify" >'
											+ '<option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_familytype
											+ '">农村</option><option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_familytype
											+ '">城镇</option>' + '</select>'
											+ '</td>'
									var select = document
											.getElementById("stu_familytype_modify");
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
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_nation
											+ '"></td>'
											+ '<td>政治面貌：</td>'
											+ '<td>'
											+ '<select class="form-control " id="stu_policits_modify" >'
											+ '<option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_policits
											+ '">共青团员</option><option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_policits
											+ '">中共中央预备党员</option><option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_policits
											+ '">中共中央党员</option><option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_policits
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
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_idcard
											+ '"></td>'
											+ '<td>本人联系电话：</td>'
											+ '<input class="form-control  " id="stu_phenumber_modify" type="text" value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_phenumber
											+ '" >'

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>父亲姓名：</td>'
											+ '<td><input class="form-control  "  id="stu_fathername_modify" type="text" value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_fathername
											+ '"></td>'
											+ '<td>父亲联系电话：</td>'
											+ '<input class="form-control  " id="stu_fathernum_modify" type="text" value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_fathernum
											+ '" >'

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>母亲姓名：</td>'
											+ '<td><input class="form-control  "  id="stu_mothername_modify" type="text" value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_mothername
											+ '"></td>'
											+ '<td>母亲联系电话：</td>'
											+ '<input class="form-control  " id="stu_mothernum_modify" type="text" value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_mothernum
											+ '" >'

									new_tr_1 = document.createElement("tr");
									table_stuinfo_update.firstElementChild
											.appendChild(new_tr_1);
									new_tr_1.innerHTML = '<td>层次：</td>'
											+ '<td>'
											+ '<select class="form-control " id="stu_lev_modify">'
											+ '<option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_lev
											+ '">本科</option><option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_lev
											+ '">专科</option>'
											+ '</select>'
											+ '</td>'
											+ '<td>学校：</td>'
											+ '<td><input class="form-control  " id="stu_college_modify" type="text" value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_college
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
											+ '<td><input class="form-control  "  id="stu_const_modify" type="text" value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_const
											+ '" ></td>'
											+ '<td>专业：</td>'
											+ '<td>'
											+ '<select class="form-control " id="stu_major_modify" >'
											+ '<option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_major
											+ '">软件工程</option><option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_major
											+ '">数字媒体技术</option><option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_major
											+ '">软件技术</option><option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_major
											+ '">数字媒体应用技术</option><option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_major
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
										if (option.value == jobStudentBaseListById[0].stuinfoStuGrade.stu_grade_id) {
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
										if (option.value == jobStudentBaseListById[0].stuinfoStuGrade.stu_class_id) {
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
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_year
											+ '">三年</option><option value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_year
											+ '">四年</option>'
											+ '</select>'
											+ '</td>'
											+ '<td>学籍异动：</td>'
											+ '<td><input class="form-control  " id="stu_change_modify" type="text" value="'
											+ jobStudentBaseListById[0].stuinfoStuBaseinfo.stu_change
											+ '" ></td>'

									var select = document
											.getElementById("stu_year_modify");
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
					xhr.open("POST", "/stuinfo/jobStudent/getJobStuById");
					var formData = new FormData();
					var this_i_id = this_stu_id;
					formData.append("stuinfoStuBaseinfo.stu_id", this_i_id);
					xhr.send(formData);

				}
			});

}
function detailJobStudent() {
	this_stu_id = window.location.search.substr(27);
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var jobStudentListById = JSON.parse(xhr.responseText);
				var cd_timeline = document.getElementById("cd-timeline");
				cd_timeline.innerHTML = "";
				for (num = 0; num < jobStudentListById.length; num++) {
					var div_1 = document.createElement("div");
					cd_timeline.appendChild(div_1);
					div_1.className = "cd-timeline-block";

					var div_2 = document.createElement("div");
					div_1.appendChild(div_2);
					div_2.className = "cd-timeline-img cd-success";
					div_2.innerHTML = num + 1;

					var div_3 = document.createElement("div");
					div_1.appendChild(div_3);
					div_3.className = "cd-timeline-content";

					var i_lable = document.createElement("i");
					i_lable.className = "fa fa-pencil";
					i_lable.id = jobStudentListById[num].stuinfoStuOnJob.stu_job_id;
					div_3.appendChild(i_lable);

					i_lable.onclick = function() {
						UpdateJobInfo(this);
					}

					var table_1 = document.createElement("table");
					div_3.appendChild(table_1);
					table_1.className = "table";
					table_1.innerHTML = '<tr>'
							+ '<td class="first_td">单位名称：</td>' + '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_comname
							+ '</td>'
							+ '<td class="first_td">单位地点：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_comadress
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td">组织机构代码：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_constitute_code
							+ '</td>'
							+ '<td class="first_td">单位行业：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_industry
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td">单位联系人姓名：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_contactname
							+ '</td>'
							+ '<td class="first_td">单位联系人电话：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_contactnum
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td">开始工作时间：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_indate
							+ '</td>'
							+ '<td class="first_td">离职时间：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_outdate
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td">在职状态：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_status
							+ '</td>' + '</tr>'
					var lable_td = document.getElementsByTagName("td");
					for (i = 0; i < lable_td.length; i++) {
						if (lable_td[i].innerHTML == "undefined"
								|| lable_td[i].innerHTML == "") {
							lable_td[i].innerHTML = "无"
						}

					}
				}

			} else {
				alert(xhr.status);
			}
		}
	}
	xhr.open("POST", "/stuinfo/jobStudent/getJobStuById");
	var formData = new FormData();
	formData.append("stuinfoStuBaseinfo.stu_id", this_stu_id);
	xhr.send(formData);
}
function UpdateJobInfo(thisJobInfo) {
	this_stu_id = window.location.search.substr(27);
	var jc = $
			.confirm({
				columnClass : 'col-md-6 col-md-offset-3',
				title : '学生就业信息',
				content : '<table id="jobinfo_table" class="table table-hover" style="text-align: center;width:90%;">'
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
											detailJobStudent();
											jc.close();
										}
									} else {
										alert(xhr.status);
									}
								}

							}
							formData
									.append(
											"stuinfoStuOnJob.stu_job_comname",
											document
													.getElementById("stu_job_comname_modify").value);
							formData
									.append(
											"stuinfoStuOnJob.stu_job_id",
											document
													.getElementById("stu_job_id_modify").value);

							formData.append("stuinfoStuOnJob.stu_id",
									this_stu_id);
							formData
									.append(
											"stuinfoStuOnJob.stu_job_comadress",
											document
													.getElementById("stu_job_comadress_modify").value);
							formData
									.append(
											"stuinfoStuOnJob.stu_job_constitute_code",
											document
													.getElementById("stu_job_constitute_code_modify").value);
							formData
									.append(
											"stuinfoStuOnJob.stu_job_industry",
											document
													.getElementById("stu_job_industry_modify").value);
							formData
									.append(
											"stuinfoStuOnJob.stu_job_contactname",
											document
													.getElementById("stu_job_contactname_modify").value);
							formData
									.append(
											"stuinfoStuOnJob.stu_job_contactnum",
											document
													.getElementById("stu_job_contactnum_modify").value);
							formData
									.append(
											"stuinfoStuOnJob.stu_job_indate",
											document
													.getElementById("stu_job_indate_modify").value);
							formData
									.append(
											"stuinfoStuOnJob.stu_job_outdate",
											document
													.getElementById("stu_job_outdate_modify").value);
							formData
									.append(
											"stuinfoStuOnJob.stu_job_status",
											document
													.getElementById("stu_job_status_modify").value);

							xhr
									.open("POST",
											"/stuinfo/jobStudent/UpdateJobStudentJobInfo");

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
								var jobStudentListById = JSON
										.parse(xhr.responseText);
								var new_tr_1 = null;
								var jobinfo_table = document
										.getElementById("jobinfo_table");
								jobinfo_table.firstElementChild.innerHTML = "";
								for (num = 0; num < jobStudentListById.length; num++) {
									if (jobStudentListById[num].stuinfoStuOnJob.stu_job_id == thisJobInfo.id) {
										var new_tr_1 = document
												.createElement("tr");
										jobinfo_table.firstElementChild
												.appendChild(new_tr_1);
										new_tr_1.innerHTML = '<td>单位名称：</td>'
												+ '<td>'
												+ '<input type="text" class="form-control" id="stu_job_comname_modify" value="'
												+ jobStudentListById[num].stuinfoStuOnJob.stu_job_comname
												+ '"/>'
												+ '<input class="form-control  " type="hidden" id="stu_job_id_modify"  value="'
												+ jobStudentListById[num].stuinfoStuOnJob.stu_job_id
												+ '">'
												+ '</td>'

												+ '<td>单位地点：</td>'
												+ '<td>'
												+ '<input type="text" class="form-control " id="stu_job_comadress_modify" value="'
												+ jobStudentListById[num].stuinfoStuOnJob.stu_job_comadress
												+ '"/>' + '</td>'

										var new_tr_2 = document
												.createElement("tr");
										jobinfo_table.appendChild(new_tr_2);
										new_tr_2.innerHTML = '<td>组织机构代码：</td>'
												+ '<td>'
												+ '<input type="text" class="form-control "  id="stu_job_constitute_code_modify" value="'
												+ jobStudentListById[num].stuinfoStuOnJob.stu_job_constitute_code
												+ '"/>'
												+ '</td>'
												+ '<td>单位行业：</td>'
												+ '<td>'
												+ '<input type="text" class="form-control " id="stu_job_industry_modify" value="'
												+ jobStudentListById[num].stuinfoStuOnJob.stu_job_industry
												+ '"/>' + '</td>'

										var new_tr_3 = document
												.createElement("tr");
										jobinfo_table.appendChild(new_tr_3);
										new_tr_3.innerHTML = '<td>单位联系人姓名：</td>'
												+ '<td>'
												+ '<input type="text" class="form-control " id="stu_job_contactname_modify" value="'
												+ jobStudentListById[num].stuinfoStuOnJob.stu_job_contactname
												+ '"/>'
												+ '</td>'
												+ '<td>单位联系人电话：</td>'
												+ '<td>'
												+ '<input type="text" class="form-control " id="stu_job_contactnum_modify" value="'
												+ jobStudentListById[num].stuinfoStuOnJob.stu_job_contactnum
												+ '"/>' + '</td>'

										var new_tr_4 = document
												.createElement("tr");
										jobinfo_table.appendChild(new_tr_4);
										new_tr_4.innerHTML = '<td>开始工作时间：</td>'
												+ '<td>'
												+ '<input type="text" class="form-control " id="stu_job_indate_modify" value="'
												+ jobStudentListById[num].stuinfoStuOnJob.stu_job_indate
												+ '"/>'
												+ '</td>'
												+ '<td>离职时间：</td>'
												+ '<td>'
												+ '<input type="text" class="form-control"  id="stu_job_outdate_modify" value="'
												+ jobStudentListById[num].stuinfoStuOnJob.stu_job_outdate
												+ '"/>' + '</td>'

										var new_tr_5 = document
												.createElement("tr");
										jobinfo_table.appendChild(new_tr_5);
										new_tr_5.innerHTML = '<td>在职状态：</td>'
												+ '<td>'
												+ '<select class="form-control " id="stu_job_status_modify" >'
												+ '<option value="'
												+ jobStudentListById[num].stuinfoStuOnJob.stu_job_status
												+ '">是</option><option value="'
												+ jobStudentListById[num].stuinfoStuOnJob.stu_job_status
												+ '">否</option>' + '</td>'

										var select = document
												.getElementById("stu_job_status_modify");
										var options = select.options;
										for (i = 0; i < options.length; i++) {
											var value_i = options[i].value;
											var text_i = options[i].text;
											if (value_i == text_i) {
												options[i].selected = "selected";
											}
										}

									}
								}

							} else {
								alert(xhr.status);
							}
						}
					}
					xhr.open("POST", "/stuinfo/jobStudent/getJobStuById");
					var formData = new FormData();
					var this_i_id = this_stu_id;
					formData.append("stuinfoStuBaseinfo.stu_id", this_i_id);
					xhr.send(formData);
				}
			});
}