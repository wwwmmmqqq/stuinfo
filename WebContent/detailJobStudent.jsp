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
        <link href="<%=basePath%>assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=basePath%>assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="<%=basePath%>assets/plugins/icomoon/style.css" rel="stylesheet">
        <link href="<%=basePath%>assets/plugins/uniform/css/default.css" rel="stylesheet"/>
        <link href="<%=basePath%>assets/plugins/switchery/switchery.min.css" rel="stylesheet"/>
        <link href="<%=basePath%>assets/plugins/vertical-timeline/css/style.css" rel="stylesheet">
 <link href="<%=basePath%>css/jquery-confirm.css" rel="stylesheet"> 
        <!-- Theme Styles -->
        <link href="<%=basePath%>assets/css/ecaps.min.css" rel="stylesheet">
        <link href="<%=basePath%>assets/css/custom.css" rel="stylesheet">
        <script src="<%=basePath%>assets/plugins/vertical-timeline/js/modernizr.js"></script>
        <link
	href="<%=basePath%>css/all_pages.css"
	rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/toastr.css" rel="stylesheet">
</head>
<body>
<!-- Page Container -->
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
                                <input type="text" name="search" class="form-control search-input" placeholder="Type something...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" id="close-search" type="button"><i class="icon-close"></i></button>
                                </span>
                            </div>
                        </form>
                    </div>
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                                <div class="logo-sm">
                                    <a href="javascript:void(0)" id="sidebar-toggle-button"><i class="fa fa-bars"></i></a>
                                    <a class="logo-box" href="listSchoolStudent.jsp"><span>毕业生就业信息管理系统</span></a>
                                </div>
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
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
									<li><a onclick="UpdatePassword()">修改密码</a></li>
									<li><a href="#">退出登录</a></li>
								</ul></li>
						</ul>
					</div><!-- /.navbar-collapse -->
                        </div><!-- /.container-fluid -->
                    </nav>
                </div><!-- /Page Header -->
                 <!-- Page Inner -->
                <div class="page-inner no-page-title">
                 <div id="main-wrapper">
              <button type="button" class="btn btn-success m-b-sm" data-toggle="modal" data-target="#baseStuinfo" onclick="detailBaseJobStudent()">查看基本信息</button> 
                                <div class="row">
                  
                  <div class="col-md-12"> 
                  <section id="cd-timeline" class="cd-container">
                    
                  </section>
                  </div>
                  </div>
                 </div>
                </div>
                
            </div>
            
            	<!-- model学生信息查看 -->
	 <div id="baseStuinfo" class="modal fade bs-example-modal-lg stuinfo" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span> 
						</button>
						<h4 class="modal-title" id="myLargeModalLabel">在职学生信息</h4>
					</div>
					<div class="modal-body">
						<div id="main_body">
							<table class="base_student_table" id="base_student_table">
								<tbody>
									<tr>
										<td>学号：</td>
										<td><input class="form-control  "  id="stu_account" type="text"></td>
									</tr>
									<tr>
										<td>姓名：</td>
										<td><input class="form-control " id="stu_name" type="text"></td>
										<td>照片：</td>
										<td><input class="form-control  " id="stu_photo" type="text"></td>
									</tr>
									<tr>
										<td>性别：</td> 
										<td><select class="form-control " id="stu_sex">
												<option>男</option>
												<option>女</option>
										</select></td>
										<td>家庭住址：</td>
										<td><input class="form-control " id="stu_adress" type="text"></td>
									</tr>
									<tr>
										<td>出生年月：</td>
										<td><input class="form-control " id="stu_bir"
											type="text"></td>
										<td>户口类型：</td>
										<td><select class="form-control  " id="stu_familytype">
												<option>农村</option>
												<option>城镇</option>
										</select></td>
									</tr>
									<tr>
										<td>民族：</td>
										<td><input class="form-control  " id="stu_nation" type="text"></td>
										<td>政治面貌：</td>
										<td><select class="form-control " id="stu_policits">
												<option>共青团员</option>
												<option>中共中央预备党员</option>
												<option>中共中央党员</option>
												<option>群众</option>
										</select></td>
									</tr>
									<tr>
										<td>证件号码：</td>
										<td><input class="form-control " id="stu_idcard" type="text"></td>
										<td>本人联系电话：</td>
										<td><input class="form-control " id="stu_phenumber" type="text"></td>
									</tr>
									<tr>
										<td>父亲姓名：</td>
										<td><input class="form-control " id="stu_fathername" type="text"></td>
										<td>父亲联系电话：</td>
										<td><input class="form-control " id="stu_fathernum" type="text"></td>
									</tr>
									<tr>
										<td>母亲姓名：</td>
										<td><input class="form-control " id="stu_mothername" type="text"></td>
										<td>母亲联系电话：</td>
										<td><input class="form-control  " id="stu_mothernum" type="text"></td>
									</tr>
									<tr>
										<td>层次：</td>
										<td><select class="form-control " id="stu_lev">
												<option>本科</option>
												<option>专科</option>
										</select></td>
										<td>学校：</td>
										<td><input class="form-control "  id="stu_college" type="text"></td>
									</tr>
									<tr>
										<td>学院：</td>
										<td><input class="form-control " id="stu_const" type="text"></td>
										<td>专业：</td>
										<td><select class="form-control " id="stu_major">
												<option>软件工程</option>
												<option>数字媒体技术</option>
												<option>软件技术</option>
												<option>数字媒体应用技术</option>
												<option>计算机信息管理</option>
										</select></td>
									</tr>
									<tr>
										<td>年级：</td>
										<td><input class="form-control " id="stu_grade_id" type="text"></td>
										<td>班级：</td>
										<td><input class="form-control " id="stu_class_id" type="text"></td>
									</tr>
									<tr>
										<td>学制：</td>
										<td><select class="form-control " id="stu_year">
												<option>三年</option>
												<option>四年</option>
										</select></td>
										<td>学籍异动：</td>
										<td><input class="form-control " id="stu_change" type="text"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="close_info" class="btn btn-info " data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		</div>
		<script type="text/javascript">
		window.onload = function(){
			detailJobStudent();
			NoticeRedPoint();
		}
		</script>
		 <!-- Javascripts -->
        <script src="<%=basePath%>assets/plugins/jquery/jquery-3.1.0.min.js"></script>
        <script src="<%=basePath%>assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=basePath%>assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="<%=basePath%>assets/plugins/uniform/js/jquery.uniform.standalone.js"></script>
        <script src="<%=basePath%>assets/plugins/switchery/switchery.min.js"></script>
        <script src="<%=basePath%>assets/plugins/vertical-timeline/js/main.js"></script> 
        <script src="<%=basePath%>assets/js/ecaps.min.js"></script>
        <%-- <script src="<%=basePath%>assets/js/pages/timeline.js"></script> --%>
     <script src="<%=basePath%>js/jquery-confirm.js"></script> 
         <script src="<%=basePath%>js/JobStudent/addJobStudent.js"></script>
           <script src="<%=basePath%>js/JobStudent/detailJobStudent.js"></script>
           <script src="<%=basePath%>js/Common/CommonJs.js"></script>
           <script src="<%=basePath%>js/toastr.js"></script>
</body>
</html>