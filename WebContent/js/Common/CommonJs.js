//获取未读通知并显示
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

									alert("移除成功");
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
								alert("新密码长度不得大于二十");
								return false;
							}
							/*
							 * 3、判断两次输入密码是否一致
							 */
							if (newPassword.value == newPassword2.value) {

							} else {
								alert("新密码输入不一致");
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
											alert("修改成功");
											return true;
										} else {
											alert("修改失败");
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