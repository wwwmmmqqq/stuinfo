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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
<link href="<%=basePath%>assets/plugins/nvd3/nv.d3.min.css"
	rel="stylesheet">
<link href="<%=basePath%>assets/css/ecaps.min.css" rel="stylesheet">
<link href="<%=basePath%>assets/css/custom.css" rel="stylesheet">
</head>
<body>
	<!-- Page Container -->
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
						<li class="active-page"><a href="index.html"> <i
								class="menu-icon icon-home4"></i><span>非毕业班学生管理</span>
						</a></li>
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
											<li><a href="http://www.datouwang.com/"><span
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
					<h3 class="breadcrumb-header">年级/班级</h3>
				</div>
				<div id="main-wrapper">
					<div class="row">
						<div class="col-md-6">
							<div class="panel panel-white">
								<div class="panel-heading">
									<h4 class="panel-title">年级</h4>
								</div>
								<div class="panel-body">
									<button type="button" class="btn btn-success m-b-sm"
										data-toggle="modal" data-target="#addGrade">添加</button>
									<!-- Modal -->
									<form id="add_grade_form" action="javascript:void(0);">
										<div class="modal fade" id="addGrade" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
														<h4 class="modal-title" id="myModalLabel">添加年级</h4>
													</div>
													<div class="modal-body">
														<div class="form-group">
															<input type="text" id="grade_input" class="form-control"
																placeholder="请输入年级" required>
														</div>

													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">取消</button>
														<button type="submit" id="add-row" class="btn btn-success" onclick="Add_Student_Grade()"> 确认添加</button>
													</div>
												</div>
											</div>
										</div>
									</form>
									<div id="grade_panel" class="table-responsive">
										<table id="grade_table" class="display table "
											style="width: 100%; cellspacing: 0;">
											<thead>
												<tr>
													<th>#</th>
													<th>年级</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="panel panel-white">
								<div class="panel-heading">
									<h4 class="panel-title">班级</h4>
								</div>
								<div class="panel-body">
									<button type="button" class="btn btn-success m-b-sm"
										data-toggle="modal" data-target="#addClass" onclick="getGradeToSelect()">添加</button>
									<!-- Modal -->
									<form id="add-row-form" action="javascript:void(0);">
										<div class="modal fade" id="addClass" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
														<h4 class="modal-title" id="myModalLabel">添加班级</h4>
													</div>
													<div class="modal-body">
														<div class="form-group" id="grade_select">
															<select class="form-control" id="grade_option">
															</select>
														</div>
														<div class="form-group">
															<input type="text" id="class_input" class="form-control"
																placeholder="请输入班级" required>
														</div>

													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">取消</button>
														<button type="submit" id="add-row" class="btn btn-success" onclick="Add_Student_Class()">确认添加</button>
													</div>
												</div>
											</div>
										</div>
									</form>
									<div class="table-responsive">
										<table id="class_table" class="display table "
											style="width: 100%; cellspacing: 0;">
											<thead>
												<tr>
													<th>#</th>
													<th>年级</th>
													<th>班级</th>
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
					<!-- Row -->
				</div>
			</div>
		</div>
		<!-- /Page Content -->
	</div>
	<!-- Javascripts -->
	<script type="text/javascript">
		window.onload = function() {
			Get_Student_Grade();
			Get_Student_Class();
		}
	</script>
	<script src="<%=basePath%>assets/plugins/jquery/jquery-3.1.0.min.js"></script>
	<script src="<%=basePath%>assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="<%=basePath%>assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script
		src="<%=basePath%>assets/plugins/uniform/js/jquery.uniform.standalone.js"></script>
	<script src="<%=basePath%>assets/plugins/switchery/switchery.min.js"></script>
	<script src="<%=basePath%>assets/plugins/d3/d3.min.js"></script>
	<script src="<%=basePath%>assets/plugins/nvd3/nv.d3.min.js"></script>
	<script src="<%=basePath%>assets/plugins/flot/jquery.flot.min.js"></script>
	<script src="<%=basePath%>assets/plugins/flot/jquery.flot.time.min.js"></script>
	<script
		src="<%=basePath%>assets/plugins/flot/jquery.flot.symbol.min.js"></script>
	<script
		src="<%=basePath%>assets/plugins/flot/jquery.flot.resize.min.js"></script>
	<script
		src="<%=basePath%>assets/plugins/flot/jquery.flot.tooltip.min.js"></script>
	<script src="<%=basePath%>assets/plugins/flot/jquery.flot.pie.min.js"></script>
	<script src="<%=basePath%>assets/plugins/chartjs/chart.min.js"></script>
	<script src="<%=basePath%>assets/js/ecaps.min.js"></script>
	<script src="<%=basePath%>assets/js/pages/dashboard.js"></script>
	<script src="<%=basePath%>js/Grade/grade.js"></script>
	<script src="<%=basePath%>js/Class/class.js"></script>

</body>
</html>