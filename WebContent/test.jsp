<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<%=basePath%>assets/css/ubuntufonts.css" rel="stylesheet">
<link href="<%=basePath%>assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=basePath%>assets/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<%=basePath%>assets/plugins/icomoon/style.css"
	rel="stylesheet">
<link href="<%=basePath%>assets/plugins/uniform/css/default.css"
	rel="stylesheet" />
<link href="<%=basePath%>assets/plugins/switchery/switchery.min.css"
	rel="stylesheet" />
<link
	href="<%=basePath%>assets/plugins/datatables/css/jquery.datatables.min.css"
	rel="stylesheet" type="text/css" />
<link 
	href="<%=basePath%>assets/plugins/datatables/css/jquery.datatables_themeroller.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=basePath%>assets/plugins/bootstrap-datepicker/css/datepicker3.css"
	rel="stylesheet" type="text/css" />

<link href="<%=basePath%>css/all_pages.css" rel="stylesheet">
<link href="<%=basePath%>css/jquery-confirm.css" rel="stylesheet">
<!-- Theme Styles -->
<link href="<%=basePath%>assets/css/ecaps.min.css" rel="stylesheet">
<link href="<%=basePath%>assets/css/custom.css" rel="stylesheet">
</head>
<body>
 
	<div id="test">
	
	</div>
	<script type="text/javascript">
	var test=document.getElementById("test");
	test.innerHTML='<td> <input type="text" class="form-control date-picker"></td>';
	</script>
	<!-- <script type="text/javascript">
	var xhr = false;
	xhr = new XMLHttpRequest();
	var formData = new FormData();
	xhr.onreadystatechange = function() {
		var message;
		
	
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
			alert("添加成功");
			} else {
				alert(xhr.status);
			}
		}
	}
	formData.append("newStudent.stu_account","12345");
	xhr.open("POST", "/stuinfo/loginAndLogout/testPassword");
	xhr.send(formData);
	</script> -->
	<!-- Javascripts -->
	<script src="<%=basePath%>assets/plugins/jquery/jquery-3.1.0.min.js"></script>
	<script src="<%=basePath%>assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="<%=basePath%>assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script
		src="<%=basePath%>assets/plugins/uniform/js/jquery.uniform.standalone.js"></script>
	<script src="<%=basePath%>assets/plugins/switchery/switchery.min.js"></script>
	<script
		src="<%=basePath%>assets/plugins/datatables/js/jquery.datatables.min.js"></script>
	<script
		src="<%=basePath%>assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script src="<%=basePath%>assets/js/ecaps.min.js"></script>
	<script src="<%=basePath%>assets/js/pages/table-data.js"></script>
	<script src="<%=basePath%>js/SchStuInfo/DetailSchoolStudent.js"></script>
	<script src="<%=basePath%>js/SchStuInfo/GetAllSchoolStudents.js"></script>
	<script src="<%=basePath%>js/SchStuInfo/UpdateSchoolStudent.js"></script>
	<script src="<%=basePath%>js/SchStuInfo/DeleteSchoolStudent.js"></script>
	<script src="<%=basePath%>js/Common/CommonJs.js"></script>
	<script src="<%=basePath%>js/jquery-confirm.js"></script>
</body>
</html>