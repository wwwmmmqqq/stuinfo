<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<link href="<%=basePath%>assets/css/ubuntufonts.css"
	rel="stylesheet">
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

<link
	href="<%=basePath%>css/all_pages.css"
	rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/toastr.css" rel="stylesheet">
	<link href="<%=basePath%>css/need/laydate.css" rel="stylesheet">
	<link href="<%=basePath%>css/jquery-confirm.css" rel="stylesheet"> 
<!-- Theme Styles -->
<link href="assets/css/ecaps.min.css" rel="stylesheet">
<link href="assets/css/custom.css" rel="stylesheet">
 <link href="<%=basePath%>assets/plugins/vertical-timeline/css/style.css" rel="stylesheet">
</head>
<body>
	<div class="page-container">
		<!-- Page Sidebar -->
		<div class="page-sidebar">
			<a class="logo-box" href="listSchoolStudent.jsp"> <span>毕业生就业信息管理系统</span> <i
				class="icon-radio_button_unchecked" id="fixed-sidebar-toggle-button"></i>
				<i class="icon-close" id="sidebar-toggle-button-close"></i>
			</a>
			<div class="page-sidebar-inner">
				<div class="page-sidebar-menu">
					<ul class="accordion-menu">
						<li><a href="javascript:void(0)"> <i
								class="menu-icon icon-flash_on"></i><span>非毕业班管理</span><i
								class="accordion-icon fa fa-angle-left"></i>
						</a>
							<ul class="sub-menu">
								<li><a href="GradeAndClass.jsp">班级/年级管理</a></li>
								<li><a href="listSchoolStudent.jsp">学生管理</a></li>
							</ul></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon icon-flash_on"></i><span>毕业班学生管理</span><i
								class="accordion-icon fa fa-angle-left"></i>
						</a>
							<ul class="sub-menu">
								<li><a href="postgraduatestudent.jsp">考研学生管理</a></li>
								<li><a href="ArmyStudent.jsp">参军学生管理</a></li>
								<li><a href="listJobStudent.jsp">就业学生管理</a></li>
								<li><a href="NoJobStudent.jsp">未就业学生管理</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- /Page Sidebar -->
		<!-- Page Content -->
		<div class="page-content">
			<!-- Page Header -->
			<div class="page-header">
				<div class="search-form">
					<form action="#" method="GET">
						<div class="input-group">
							<input type="text" name="search"
								class="form-control search-input"
								placeholder="Type something..."> <span
								class="input-group-btn">
								<button class="btn btn-default" id="close-search" type="button">
									<i class="icon-close"></i>
								</button>
							</span>
						</div>
					</form>
				</div>
				<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<div class="logo-sm">
							<a href="javascript:void(0)" id="sidebar-toggle-button"><i
								class="fa fa-bars"></i></a> <a class="logo-box" href="listSchoolStudent.jsp"><span>ecaps</span></a>
						</div>
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<i class="fa fa-angle-down"></i>
						</button>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->

				<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="javascript:void(0)"
								id="collapsed-sidebar-toggle-button"><i class="fa fa-bars"></i></a></li>
							<li><a href="javascript:void(0)" id="toggle-fullscreen"><i
									class="fa fa-expand"></i></a></li>
							<li><a data-toggle="collapse" data-parent="#accordion" 
				   href="#search_group"><i
									class="fa fa-search "></i></a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
						<li class="user_name"><span>欢迎<span class="name_color">管理员</span>登录</span></li>
							<li class="dropdown"><a href="javascript:void(0)"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"  onclick="GetNonReadNotices()"><i
									class="fa fa-bell"></i><img id="noctice_img" src="<%=basePath%>assets/images/point_2.png" /></a>
								<ul class="dropdown-menu dropdown-lg dropdown-content">
									<li class="drop-title">消息通知<a href="#"
										class="drop-title-link"><i class="fa fa-angle-right"></i></a></li>
									<li class="slimscroll dropdown-notifications ">
										<ul class="list-unstyled dropdown-oc" id="notice_ul">
										
											<!-- <li id="history_li"><a href="#">历史通知记录...</a></li> -->
										</ul>
									</li>
								</ul></li>
							<li class="dropdown user-dropdown"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">  <i class="fa fa-user"></i></a>
								<ul class="dropdown-menu">
								<li><a href="#">导入</a></li>
								<!-- <li><a href="#" onclick="ChooseInfoToExcel()" data-toggle="modal" data-target="#to_excel_modal" >导出excel表</a></li> -->
									<li><a onclick="UpdatePassword()">修改密码</a></li>
									<li><a href="#">退出登录</a></li>
								</ul></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid --> </nav>
			</div>
			<!-- /Page Header -->
				<!-- Search Content -->
			<div class=" panel-collapse collapse" id="search_group">
			<div class="panel panel-body">
		<div id="select_group" >
	<div class="col-md-3 input_group">
				
			<table>
				<tbody>
					<td>
							<label>请选择搜索条件：</label>
					</td>
					<td>
						<select id="sele" class="form-control">
		<option selected="selected" disabled="disabled" >请选择</option>
<option value="学号">学号</option>
	<option value="姓名">姓名</option>
	<option value="班级">班级</option>
	<option value="年级">年级</option>
	<option value="专业">专业</option>
	</select>
					</td>
				</tbody>
			</table>
	</div>
		</div>
		<div  class="col-xs-2 sure_search">
			<a><button class="btn btn-success ">确认搜索</button></a>
			</div>
			</div>	
				
		
			</div>
				<!--/ Search Content -->
			<!-- Page Inner -->
			<div class="page-inner">
				<div class="page-title">
					<h3 class="breadcrumb-header">毕业班学生信息管理</h3>
				</div>
				<div id="main-wrapper">
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-white" id="js-alerts">
								<div class="panel-heading clearfix">
									<h4 class="panel-title">在职学生信息</h4>
								</div>
								<div class="panel-body">
									<table class="table table-hover" id="job_student_table">
										<thead>
											<tr>
												<th>#</th>
												<th>学号</th>
												<th>姓名</th>
												<th>专业</th>
												<th>年级</th>
												<th>班级</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
										
									</table>
									<ul class="pager">
	<li>
		<a href="#" onclick="flip(1)">上一页</a>
	</li>
	<li>
		<a href="#" onclick="flip(2)">下一页</a>
	</li>
</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /Page Content -->
	 
	</div>
	<script type="text/javascript">
		window.onload = function() {
			GetAllJobStudentsByPageAndSearch(1);
			NoticeRedPoint();
			SearchByOption();
		}
		function time(){
			!function(){
	laydate.skin('danlan');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#stu_bir_modify'});//绑定元素
}();
//日期范围限制
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
    min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};

var end = {
    elem: '#end',
    format: 'YYYY-MM-DD',
    min: laydate.now(),
    max: '2099-06-16',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，充值开始日的最大日期
    }
};
laydate(start);
laydate(end);
		}
	</script>
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
	 <script src="<%=basePath%>assets/plugins/vertical-timeline/js/main.js"></script> 
	<script src="<%=basePath%>js/JobStudent/GetAllJobStudents.js"></script>
	<script src="<%=basePath%>js/JobStudent/UpdateJobStudent.js"></script>
	<script src="<%=basePath%>js/JobStudent/DeleteJobStudent.js"></script>
	<script src="<%=basePath%>js/Common/CommonJs.js"></script>
	<script src="<%=basePath%>js/laydate.js"></script>
	<script src="<%=basePath%>js/toastr.js"></script>
	 <script src="<%=basePath%>js/jquery-confirm.js"></script> 
</body>
</html>