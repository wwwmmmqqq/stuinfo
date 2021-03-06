function login() {
	var login_btn = document.getElementById("login_btn");
	login_btn.disabled = "disabled";
	login_btn.innerHTML = '<i class="fa fa-refresh fa-spin"></i> 正在登录...';

	var user_account = document.getElementById("user_account");
	var user_password = document.getElementById("user_password");
	var formData = new FormData();
	formData.append("username", user_account.value);
	formData.append("password", user_password.value);
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var data = new Array();
				switch (xhr.responseText) {
				case "账号不存在": {
					toastr.error("账号不存在");
					login_btn.disabled = "";
					login_btn.innerHTML = '登录';
					break;
				}
				case "密码不正确": {
					toastr.error("密码不正确");
					login_btn.disabled = "";
					login_btn.innerHTML = '登录';
					break;
				}
				case "教师登录成功": {
					toastr.success("教师登录成功");
					break;
				}
				case "学生登录成功": {
					window.location = "/stuinfo/Student.jsp";
					break;
				}
				case "管理员登录成功": {
					window.location = "/stuinfo/listSchoolStudent.jsp";
					break;
				}
				}
			} else {
				login_btn.disabled = "";
				login_btn.innerHTML = '登录';
				ALERT(xhr.status);
			}
		}
	}

	xhr.open("POST", "/stuinfo/loginAndLogout/login");
	xhr.send(formData);
}
// 登录用户名
function LoginInformation() {
	var user_name = document.getElementById("user_name");
	user_name.innerHTML = '<span>欢迎<span class="name_color">聂志朋</span>登录</span>'
}