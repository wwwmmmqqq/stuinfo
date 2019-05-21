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
</head>
<body>
<input type="checkbox" name="titles" value="a">a</input>
<input type="checkbox" name="titles" value="b"/>b</input>
<input type="checkbox" name="titles" value="c"/>c</input>
<input type="checkbox" name="titles" value="d"/>d</input>
<script src="<%=basePath%>assets/plugins/jquery/jquery-3.1.0.min.js"></script>
		<!-- <script type="text/javascript">
		
		
	    var a=[];
	//设置数组模式
	    for (var i = 0; i < 10; i++) {
	        a[i]=i;
	    }
	    //var b = $.param(a, true);
	    $.ajax({
	        url: "/stuinfo/loginAndLogout/test",
	        //data:{"ids":b},这种方式我这里测试获取到的数据个数为0，倒不是为null，也不行
	        dataType: "json",
	        type: "post",
	        data: { "titles": a },//使用这种数组方式的，得加下一句才可以，使用传统方式
	        traditional: true,
	        success: function (data) {
	            for (var i = 0; i < data.length; i++) {
	                console.log(data[i]);
	            }
	        }
	    })
	</script> -->
	
	<script type="text/javascript">
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
	</script>
	
</body>
</html>