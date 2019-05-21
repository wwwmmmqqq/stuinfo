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
					alert("账号不存在");
					login_btn.disabled = "";
					login_btn.innerHTML = '登录';
					break;
				}
				case "密码不正确": {
					alert("密码不正确");
					login_btn.disabled = "";
					login_btn.innerHTML = '登录';
					break;
				}
				case "教师登录成功": {
					alert("教师登录成功");
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
// 登出
function Logout() {

}