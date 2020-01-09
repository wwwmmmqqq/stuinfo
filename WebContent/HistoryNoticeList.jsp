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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Responsive Admin Dashboard Template">
        <meta name="keywords" content="admin,dashboard">
        <meta name="author" content="skcats">
        <!-- The above 6 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        
        <!-- Title -->
        <title></title>

        <!-- Styles -->
         <link href="<%=basePath%>css/all_pages.css" rel="stylesheet"> 
      <%--  <link href="<%=basePath%>css/common.css" rel="stylesheet"> --%>
      <link href="<%=basePath%>assets/css/ubuntufonts.css" rel="stylesheet">
        <link href="<%=basePath%>assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=basePath%>assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="<%=basePath%>assets/plugins/icomoon/style.css" rel="stylesheet">
        <link href="<%=basePath%>assets/plugins/uniform/css/default.css" rel="stylesheet"/>
        <link href="<%=basePath%>assets/plugins/switchery/switchery.min.css" rel="stylesheet"/>
      
        <!-- Theme Styles -->
        <link href="<%=basePath%>css/all_pages.css" rel="stylesheet">
        <link href="<%=basePath%>css/toastr.css" rel="stylesheet">
        <link href="<%=basePath%>assets/css/ecaps.min.css" rel="stylesheet">
        <link href="<%=basePath%>assets/css/custom.css" rel="stylesheet">


        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
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
		</div><!-- /Page Sidebar -->
            
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
                        
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav">
                                    <li><a href="javascript:void(0)" id="collapsed-sidebar-toggle-button"><i class="fa fa-bars"></i></a></li>
                                    <li><a href="javascript:void(0)" id="toggle-fullscreen"><i class="fa fa-expand"></i></a></li>
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
                <div class="page-inner">
                    <div class="page-title">
                        <h3 class="breadcrumb-header">通知记录</h3>
                    </div>
                <div id="main-wrapper">
                    <div class="row">
                        <div class="panel panel-white" id="js-alerts">
                                <div class="panel-heading clearfix" id="Notice_panel">
                              <span ><a class="active" onclick="NonReadOnclick()" id="UnNotice"  >未读</a></span>
                              <span>/</span>
                                  <span><a onclick="ReadedOnclick()" id="ReadNotice" >已读</a></span>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-condensed " id="notice_table">
                                        <tbody>
                                        </tbody>
                                    </table>
                                     <ul class="pager" id="pager">
										<!-- <li><a href="#" onclick="flip(1)">上一页</a></li>
										<li><a href="#" onclick="flip(2)">下一页</a></li> -->
									</ul>
                                </div>
                               
                            </div>
                    </div><!-- Row -->
                </div><!-- Main Wrapper -->
                </div><!-- /Page Inner -->
            
            </div><!-- /Page Content -->
        </div><!-- /Page Container -->
        
        	<script type="text/javascript">
        	window.onload = function(){
        		var UnNotice=document.getElementById("UnNotice");
        		var ReadNotice=document.getElementById("ReadNotice");
        		UnNotice.click();
        		NoticeRedPoint();
        	}
        	</script> 
        <!-- Javascripts -->
        <script src="<%=basePath%>assets/plugins/jquery/jquery-3.1.0.min.js"></script>
        <script src="<%=basePath%>assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=basePath%>assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="<%=basePath%>assets/plugins/uniform/js/jquery.uniform.standalone.js"></script>
        <script src="<%=basePath%>assets/plugins/switchery/switchery.min.js"></script>
        <script src="<%=basePath%>assets/js/ecaps.min.js"></script>
        <script src="<%=basePath%>js/Notice/HistoryNotice.js"></script>
        <script src="<%=basePath%>js/Common/CommonJs.js"></script>
        <script src="<%=basePath%>js/toastr.js"></script>
    </body>
</html>