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

<link href="https://fonts.googleapis.com/css?family=Ubuntu"
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
<!-- Theme Styles -->
<link href="assets/css/ecaps.min.css" rel="stylesheet">
<link href="assets/css/custom.css" rel="stylesheet">
</head>
<body>
	<div class="page-container">
		<!-- Page Sidebar -->
		<div class="page-sidebar">
			<a class="logo-box" href="index.html"> <span>毕业生就业信息管理系统</span> <i
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
								<li><a href="">班级/年级管理</a></li>
								<li><a href="ui-buttons.html">学生管理</a></li>
							</ul></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon icon-flash_on"></i><span>毕业班学生管理</span><i
								class="accordion-icon fa fa-angle-left"></i>
						</a>
							<ul class="sub-menu">
								<li><a href="">考研学生管理</a></li>
								<li><a href="ui-buttons.html">参军学生管理</a></li>
								<li><a href="ui-icons.html">就业学生管理</a></li>
								<li><a href="ui-typography.html">未就业学生管理</a></li>
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
								class="fa fa-bars"></i></a> <a class="logo-box" href="index.html"><span>ecaps</span></a>
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
							<li><a href="javascript:void(0)" id="search-button"><i
									class="fa fa-search"></i></a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="javascript:void(0)"
								class="right-sidebar-toggle"
								data-sidebar-id="main-right-sidebar"><i
									class="fa fa-envelope"></i></a></li>
							<li class="dropdown"><a href="javascript:void(0)"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"><i
									class="fa fa-bell"></i></a>
								<ul class="dropdown-menu dropdown-lg dropdown-content">
									<li class="drop-title">Notifications<a href="#"
										class="drop-title-link"><i class="fa fa-angle-right"></i></a></li>
									<li class="slimscroll dropdown-notifications">
										<ul class="list-unstyled dropdown-oc">
											<li><a href="#"><span
													class="notification-badge bg-primary"><i
														class="fa fa-photo"></i></span> <span class="notification-info">Finished
														uploading photos to gallery <b>"South Africa"</b>. <small
														class="notification-date">20:00</small>
												</span></a></li>
											<li><a href="#"><span
													class="notification-badge bg-primary"><i
														class="fa fa-at"></i></span> <span class="notification-info"><b>John
															Doe</b> mentioned you in a post "Update v1.5". <small
														class="notification-date">06:07</small> </span></a></li>
											<li><a href="#"><span
													class="notification-badge bg-danger"><i
														class="fa fa-bolt"></i></span> <span class="notification-info">4
														new special offers from the apps you follow! <small
														class="notification-date">Yesterday</small>
												</span></a></li>
											<li><a href="#"><span
													class="notification-badge bg-success"><i
														class="fa fa-bullhorn"></i></span> <span
													class="notification-info">There is a meeting with <b>Ethan</b>
														in 15 minutes! <small class="notification-date">Yesterday</small>
												</span></a></li>
										</ul>
									</li>
								</ul></li>
							<li class="dropdown user-dropdown"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"><img
									src="http://via.placeholder.com/36x36" alt=""
									class="img-circle"></a>
								<ul class="dropdown-menu">
									<li><a href="#">Profile</a></li>
									<li><a href="#">Calendar</a></li>
									<li><a href="#"><span
											class="badge pull-right badge-danger">42</span>Messages</a></li>
									<li role="separator" class="divider"></li>
									<li><a href="#">Account Settings</a></li>
									<li><a href="#">Log Out</a></li>
								</ul></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid --> </nav>
			</div>
			<!-- /Page Header -->
			<!-- Page Inner -->
			<div class="page-inner">
				<div class="page-title">
					<h3 class="breadcrumb-header">学生信息管理</h3>
				</div>
				<div id="main-wrapper">
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-white" id="js-alerts">
								<div class="panel-heading clearfix">
									<h4 class="panel-title">学生信息</h4>
								</div>
								<div class="panel-body">
									<table class="table table-hover" id="school_student_table">
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
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /Page Content -->
		<!-- model学生信息查看 -->
		<div class="modal fade bs-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myLargeModalLabel">在校学生信息</h4>
					</div>
					<div class="modal-body">
						<div id="main_body">
							<table class="school_student_table" id="school_student_table">
								<tbody>
									<tr>
										<td>学号：</td>
										<td><input class="form-control  "  name="stu_account" type="text"></td>
									</tr>
								</tbody>
								<tbody>
									<tr>
										<td>姓名：</td>
										<td><input class="form-control " name="stu_name" type="text"></td>
										<td>照片：</td>
										<td><input class="form-control  " name="stu_photo" type="text"></td>
									</tr>
									<tr>
										<td>性别：</td>
										<td><select class="form-control " name="stu_sex">
												<option>男</option>
												<option>女</option>
										</select></td>
										<td>家庭住址：</td>
										<td><input class="form-control " name="stu_adress" type="text"></td>
									</tr>
									<tr>
										<td>出生年月：</td>
										<td><input class="form-control " name="stu_bir"
											type="text"></td>
										<td>户口类型：</td>
										<td><select class="form-control  " name="stu_familytype">
												<option>农村</option>
												<option>城镇</option>
										</select></td>
									</tr>
									<tr>
										<td>民族：</td>
										<td><input class="form-control  " name="stu_nation" type="text"></td>
										<td>政治面貌：</td>
										<td><select class="form-control " name="stu_policits">
												<option>共青团员</option>
												<option>中共中央预备党员</option>
												<option>中共中央党员</option>
												<option>群众</option>
										</select></td>
									</tr>
									<tr>
										<td>证件号码：</td>
										<td><input class="form-control " name="stu_idcard" type="text"></td>
										<td>本人联系电话：</td>
										<td><input class="form-control " name="stu_phenumber" type="text"></td>
									</tr>
									<tr>
										<td>父亲姓名：</td>
										<td><input class="form-control " name="stu_fathername" type="text"></td>
										<td>父亲联系电话：</td>
										<td><input class="form-control " name="stu_fathernum" type="text"></td>
									</tr>
									<tr>
										<td>母亲姓名：</td>
										<td><input class="form-control " name="stu_mothername" type="text"></td>
										<td>母亲联系电话：</td>
										<td><input class="form-control  " name="stu_mothernum" type="text"></td>
									</tr>
									<tr>
										<td>层次：</td>
										<td><select class="form-control " name="stu_lev">
												<option>本科</option>
												<option>专科</option>
										</select></td>
										<td>学校：</td>
										<td><input class="form-control "  name="stu_college" type="text"></td>
									</tr>
									<tr>
										<td>学院：</td>
										<td><input class="form-control " name="stu_const" type="text"></td>
										<td>专业：</td>
										<td><select class="form-control " name="stu_major">
												<option>软件工程</option>
												<option>数字媒体技术</option>
												<option>软件技术</option>
												<option>数字媒体应用技术</option>
												<option>计算机信息管理</option>
										</select></td>
									</tr>
									<tr>
										<td>年级：</td>
										<td><input class="form-control " name="stu_grade_id" type="text"></td>
										<td>班级：</td>
										<td><input class="form-control " name="stu_class_id" type="text"></td>
									</tr>
									<tr>
										<td>学制：</td>
										<td><select class="form-control " name="stu_year">
												<option>三年</option>
												<option>四年</option>
										</select></td>
										<td>学籍异动：</td>
										<td><input class="form-control " name="stu_change" type="text"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		window.onload = function() {
			GetAllSchoolStudents();
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
	<script src="<%=basePath%>js/SchStuInfo/SchStuInfo.js"></script>
</body>
</html>