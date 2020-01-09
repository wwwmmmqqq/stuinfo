var input_id = null;
// 获取未读通知并显示

function GetNonReadNotices() {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				// 清空原来数据
				var new_li_list = document.getElementsByClassName("new_li");
				var long = new_li_list.length;
				for (var num = 0; num < long; num++) {
					new_li_list[0].parentNode.removeChild(new_li_list[0]);
				}
				var notice_ul = document.getElementById("notice_ul");
				var noctice_img = document.getElementById("noctice_img");
				NoticeList = JSON.parse(xhr.responseText);
				for (num = 0; num < NoticeList.length; num++) {
					var new_li = document.createElement("li");
					new_li.className = "new_li";
					notice_ul.appendChild(new_li);
					new_li.innerHTML = '<a href="#">'
							+ '<p class="notification-info">'
							+ NoticeList[num].notice_stu_grade
							+ NoticeList[num].notice_stu_major
							+ NoticeList[num].notice_stu_class
							+ NoticeList[num].notice_stu_account
							+ NoticeList[num].notice_stu_name
							+ NoticeList[num].notice_content
							+ '&nbsp &nbsp<small class="notification-date">'
							+ NoticeList[num].notice_infocreate
							+ '</small>'
							+ '</p>'
							+ '<button class="btn btn-primary btn-xs btn_position" id="'
							+ NoticeList[num].notice_id
							+ '" onclick="RemoveNotice(this)">知道了'
							+ '</button>' + '</a>';
				}
				var new_li = document.createElement("li");
				new_li.className = "new_li";
				notice_ul.appendChild(new_li);
				var new_a = document.createElement("a");
				new_a.innerHTML = "历史通知记录...";
				new_li.appendChild(new_a);
				new_a.href = "HistoryNoticeList.jsp";
			}
		}
	}
	xhr.open("POST", "/stuinfo/noticeManage/listNoticesAll");
	xhr.send(null);
}

// 点击知道了按钮 移除通知
function RemoveNotice(thisNotice) {

	$.confirm({
		title : '警告！移除该条通知',
		content : '此操作会将这条通知移除通知列表，请确认是否继续操作！',
		type : 'red',
		autoClose : '取消|5000',// 自动关闭
		buttons : {
			确定 : {
				btnClass : 'btn-red',
				action : function() {
					var xhr = false;
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange = function() {
						var message;
						if (xhr.readyState == 4) {
							if (xhr.status == 200) {
								if (xhr.responseText == "success") {

									toastr.success("移除成功");
									GetNonReadNotices();
									NoticeRedPoint();
								}
							} else {
								alert(xhr.status);
							}
						}
					}

					var formData = new FormData();
					var notice_id = thisNotice.id;
					formData.append("NoticeId", notice_id);
					xhr.open("POST", "/stuinfo/noticeManage/NoticeOk");
					xhr.send(formData);
				}
			},
			取消 : function() {
			}
		}
	});
}
// 判断是否有新的消息通知 有则显示红点
function NoticeRedPoint() {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				NoticeList = JSON.parse(xhr.responseText);
				if (NoticeList.length > 0) {
					noctice_img.style = "display: inline-block";
				} else {
					noctice_img.style = "display: none";
				}
			}
		}
	}
	xhr.open("POST", "/stuinfo/noticeManage/listNoticesAll");
	xhr.send(null);
}
// 修改密码
function UpdatePassword() {

	var jc = $
			.confirm({
				title : '修改密码',
				content : '<table  class="table table-hover" style="text-align: center;">'
						+ '<tbody>'
						// + '<tr>旧密码：'
						// + '<input type="password" id="oldPassword"
						// class="form-control" required />'
						// + '</tr>'
						+ '<tr>新密码：'
						+ '<input type="password" id="newPassword" class="form-control" required />'
						+ '</tr>'
						+ '<tr>重复密码：'
						+ '<input type="password" id="newPassword2" class="form-control" required />'
						+ '</tr>' + '</tbody>' + '</table>',
				buttons : {
					'提交修改 ' : {
						btnClass : 'btn-red',
						action : function() {
							// var oldPassword = document
							// .getElementById("oldPassword");
							var newPassword = document
									.getElementById("newPassword");
							var newPassword2 = document
									.getElementById("newPassword2");

							/*
							 * 2、判断密码是否复合要求（长度20之内，不能带空格）
							 */
							if (newPassword.value.length <= 20) {

							} else {
								toastr.warning("新密码长度不得大于二十");
								return false;
							}
							/*
							 * 3、判断两次输入密码是否一致
							 */
							if (newPassword.value == newPassword2.value) {

							} else {
								toastr.warning("新密码输入不一致");
								return false;
							}
							/*
							 * 通过ajax传给后台旧密码和新密码，得到旧密码是否正确，若正确则表示修改成功
							 */
							var xhr = false;
							xhr = new XMLHttpRequest();
							xhr.onreadystatechange = function() {
								var message;
								if (xhr.readyState == 4) {
									if (xhr.status == 200) {
										if (xhr.responseText == "success") {
											toastr.success("修改成功");
											window.location = "/stuinfo/Login.jsp";
											return true;
										} else {
											toastr.error("修改失败");
											return false;
										}
									} else {
										alert(xhr.status);
									}
								}
							}
							var formData = new FormData();
							// formData.append("oldPassword",
							// oldPassword.value);
							formData.append("newPassword", newPassword.value);
							xhr.open("POST",
									"/stuinfo/loginAndLogout/UpdatePassword");
							xhr.send(formData);
						}
					},
					'返回 ' : function() {
					}
				},
				onContentReady : function() {

				}
			});
}

// 按条件搜索
function SearchByOption() {
	var select_group = document.getElementById("select_group");

	/* var data = sele_value.substring(0, i); */
	sele
			.addEventListener(
					'change',
					function() {
						var sele_value = document.getElementById("sele").value;
						var i = sele_value.indexOf('_');
						var input_value = sele_value.substring((i + 1),
								sele_value.length)
						var input_id = sele_value.substring(0, i)

						var new_div = document.createElement("div");
						new_div.className = "col-xs-2 input_group";
						new_div.innerHTML = '<table>'
								+ '<tbody>'
								+ '<td>'
								+ '<input type="text" class="form-control"  placeholder="请输入'
								+ input_value
								+ '" id="'
								+ input_id
								+ '" />'
								+ '</td>'
								+ '<td>'
								+ '<button class="btn btn-primary " onclick="RemoveInputSearch(this)">X</button>'
								+ '</td>' + '</tbody>' + '</table>'
						select_group.appendChild(new_div);
					})
}

// 点击X移除搜索输入框
function RemoveInputSearch(thisButton) {
	thisButton.parentNode.parentNode.parentNode.parentNode.parentNode.classList
			.add("display_input");
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
			+ '<td><input type="checkbox" name="stu_account_field" value="1"/> <label>学号</label></td>'
			+ '<td><input type="checkbox" name="stu_name_field" value="1"/> <label>姓名</label></td>'
			+ '<td><input type="checkbox" name="stu_sex_field" value="1"/> <label>性别</label></td>'
			+ '<td><input type="checkbox" name="stu_adress_field" value="1"/> <label>家庭住址</label></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td><input type="checkbox" name="stu_bir_field" value="1"/> <label>出生年月</label></td>'
			+ '<td><input type="checkbox" name="stu_familytype_field" value="1"/> <label>户口类型</label></td>'
			+ '<td><input type="checkbox" name="stu_nation_field" value="1"/> <label>民族</label></td>'
			+ '<td><input type="checkbox" name="stu_policits_field" value="1"/> <label>政治面貌</label></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td><input type="checkbox" name="stu_idcard_field" value="1"/> <label>证件号码</label></td>'
			+ '<td><input type="checkbox" name="stu_phenumber_field" value="1"/> <label>本人联系电话</label></td>'
			+ '<td><input type="checkbox" name="stu_fathername_field" value="1"/> <label>父亲姓名</label></td>'
			+ '<td><input type="checkbox" name="stu_fathernum_field" value="1"/> <label>父亲联系电话</label></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td><input type="checkbox" name="stu_mothername_field" value="1"/> <label>母亲姓名</label></td>'
			+ '<td><input type="checkbox" name="stu_mothernum_field" value="1"/> <label>母亲联系电话</label></td>'
			+ '<td><input type="checkbox" name="stu_lev_field" value="1"/> <label>层次</label></td>'
			+ '<td><input type="checkbox" name="stu_college_field" value="1"/> <label>学校</label></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td><input type="checkbox"  name="stu_const_field" value="1"/> <label>学院</label></td>'
			+ '<td><input type="checkbox" name="stu_major_field" value="1"/> <label>专业</label></td>'
			+ '<td><input type="checkbox" name="stu_grade_name_field" value="1"/> <label>年级</label></td>'
			+ '<td><input type="checkbox" name="stu_class_name_field" value="1"/> <label>班级</label></td>'
			+ '</tr>'
			+ '<tr class="border_tr">'
			+ '<td><input type="checkbox" name="stu_year_field" value="1"/> <label>学制</label></td>'
			+ '<td><input type="checkbox" name="stu_change_field" value="1"/> <label>学籍异动</label></td>'
			+ '<td><input type="hidden" name="stu_class_id_field" value="1"/> </td>'
			+ '</tr>'

}
// 获取字段
function get() {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {

		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {

			}
		}
	}
	var to_excel_tltle = document.getElementById("to_excel_tltle");
	var input_name = document.getElementsByTagName("input");
	var formData = new FormData();
	for (i = 0; i < input_name.length; i++) {
		if (input_name[i].checked) {
			formData.append("studentFiled." + input_name[i].name, "1");
		}
		formData.append("stdo." + input_name[i].name, input_name[i].name);
	}

	xhr.open("POST", "/stuinfo/student/StuinfoExportToExcel");
	xhr.send(formData);

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
