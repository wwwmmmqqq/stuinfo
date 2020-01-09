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
<link href="<%=basePath%>assets/plugins/vertical-timeline/css/style.css"
	rel="stylesheet">
<link href="<%=basePath%>css/jquery-confirm.css" rel="stylesheet">
<!-- Theme Styles -->
<link href="<%=basePath%>assets/css/ecaps.min.css" rel="stylesheet">
<link href="<%=basePath%>assets/css/custom.css" rel="stylesheet">
<script
	src="<%=basePath%>assets/plugins/vertical-timeline/js/modernizr.js"></script>
<link href="<%=basePath%>css/all_pages.css" rel="stylesheet"
	type="text/css" />
	<link
	href="<%=basePath%>assets/plugins/bootstrap-datepicker/css/datepicker3.css"
	rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/toastr.css" rel="stylesheet">
	<link href="<%=basePath%>css/need/laydate.css" rel="stylesheet">
</head>
<body>
	<!-- Page Container -->
	<div class="page-container">
		<!-- Page Sidebar -->
		<div class="page-sidebar">
			<a class="logo-box" href="Student.jsp"> <span>毕业生就业信息管理系统</span> <i
				class="icon-radio_button_unchecked" id="fixed-sidebar-toggle-button"></i>
				<i class="icon-close" id="sidebar-toggle-button-close"></i>
			</a>

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
								class="fa fa-bars"></i></a> <a class="logo-box" href="Student.jsp"><span>毕业就业信息管理系统</span></a>
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
						</ul>
						<ul class="nav navbar-nav navbar-right">
						<li class="user_name" id="user_name"></li>
							<li class="dropdown user-dropdown"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">  <i class="fa fa-user"></i></a>
								<ul class="dropdown-menu">
									<li><a onclick="UpdatePassword()">修改密码</a></li>
									<li><a href="<%=basePath%>/loginAndLogout/logout">退出登录</a></li>
								</ul></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid --> </nav>
			</div>
			<!-- /Page Header -->
			<!-- Page Inner -->
			<div class="page-inner no-page-title">
				<div id="main-wrapper">
					<div class="row">
						<div class="col-md-12">
						<a data-toggle="collapse" data-parent="#accordion" 
				   href="#collapseTwo">
						<button type="button" class="btn btn-success m-b-sm" >查看基本信息</button> 
							</a>
						<button type="button" class="btn btn-primary m-b-sm" data-toggle="modal" data-target="#job_recoder_modal"  onclick="AddJobRecode()" >添加工作记录</button>
							 <div id="collapseTwo" class="panel-collapse collapse">
								<div class="panel-body">
								<div class="panel-heading clearfix">
								
									<lable class="panel-title" style="font-size:18px">基本信息</lable>
									
											
									<table class="table base_info_table" id="base_info_table">
										<tbody>
											<tr>
												<td class="info_title">学号：
												<td>15478011
												<td class="info_title">姓名：
												<td> 翁梦倩
												<td>
												<td>
												<td>
												<td>
											</tr>
											<tr>
												<td class="info_title">性别：
												<td>女
												<td class="info_title">家庭住址：
												<td>翁梦倩
												<td class="info_title">出生年月
												<td>19960719
												<td class="info_title">户口类型：
												<td>农村
												
											</tr>
											<tr>
												<td class="info_title">民族：
												<td>汉
												<td class="info_title">政治面貌:
												<td>中共党员
												<td class="info_title">证件号码：
												<td>361102199607194529
												<td class="info_title">本人联系电话：
												<td>18307037491
												
											</tr>
											<tr>
											<td class="info_title">父亲姓名:
												<td>中共党员
												<td class="info_title">父亲联系电话：
												<td>18307037491
												<td class="info_title">母亲姓名：
												<td>18307037491
												<td class="info_title">母亲联系电话:
												<td>中共党员
												
											</tr>
											<tr>
												<td class="info_title">层次：
												<td>本科
												<td class="info_title">学校：
												<td>18307037491
												<td class="info_title">学院:
												<td>信息与计算机工程学院
												<td class="info_title">专业：
												<td>软件工程
												
											</tr>
											<tr>
												<td class="info_title">年级：
												<td>2015
												<td class="info_title">班级:
												<td>一班
												<td class="info_title">学制：
												<td>4年
												<td class="info_title">学籍异动：
												<td>无异动
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-12">
					 <section id="cd-timeline" class="cd-container">
					
					 </section>
					</div>
				</div>
			</div>

		</div>


	</div>
	 <!-- 修改工作记录模态框 -->
		 <div class="modal fade" id="job_recoder_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                            <h4 class="modal-title" id="myModalLabel">工作信息</h4>
                                                        </div>
                                                        <div class="modal-body" id="job_recode_table">
                                                         <!-- <table class="table">
                                        	<tr>
                                        		<td>单位名称：</td>
                                        		<td><input type="text" class="form-control "/></td>
                                        		
                                        		<td>单位地点：</td>
                                        		<td><input type="text" class="form-control "/></td>
                                        	</tr>
                                        	<tr>
                                        		<td>组织机构代码：</td>
                                        			<td><input type="text" class="form-control "/></td>
                                        		<td>单位行业：</td>
                                        		<td><input type="text" class="form-control "/></td>
                                        	</tr>
                                        		<tr>
                                        		<td>单位联系人姓名：</td>
                                        			<td><input type="text" class="form-control "/></td>
                                        		<td>单位联系人电话：</td>
                                        		<td><input type="text" class="form-control "/></td>
                                        	</tr>
                                        		<tr>
                                        		<td>开始工作时间：</td>
                                        		<td><input type="text" class="form-control "/></td>
                                        		<td>离职时间：</td>
                                        		<td><input type="text" class="form-control "/></td>
                                        	</tr>
                                        		<tr>
                                        		<td>在职状态：</td>
                                        		<td><input type="text" class="form-control "/></td>
                                        	</tr>
                                        </table> -->
                                                        </div>
                                                        <div class="modal-footer">
                                                        <button type="button" class="btn btn-info" data-dismiss="modal" onclick="WarnAddJobRecode()">确认添加   </button>
                                                            <button type="button" class="btn " data-dismiss="modal">关闭</button>
                                                        </div>
                                                    </div>
                                                </div>
                                    </div>
	<script type="text/javascript">
		window.onload = function() {
			ListJobRecord();
			LoginInformation();
		}
		function time(){
			!function(){
	laydate.skin('danlan');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#add_stu_job_indate'});//绑定元素
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
	<script src="<%=basePath%>assets/plugins/vertical-timeline/js/main.js"></script>
	<script src="<%=basePath%>assets/js/ecaps.min.js"></script>
	<%-- <script src="<%=basePath%>assets/js/pages/timeline.js"></script> --%>
	<script src="<%=basePath%>js/jquery-confirm.js"></script>
	<%-- <script src="<%=basePath%>js/Student/Student.js"></script> --%>
	
	<script
		src="<%=basePath%>assets/plugins/datatables/js/jquery.datatables.min.js"></script>
	<script
		src="<%=basePath%>assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script src="<%=basePath%>js/Student/addJobRecord.js"></script>
	<script src="<%=basePath%>js/Student/ListJobRecord.js"></script>
	<script src="<%=basePath%>js/Common/CommonJs.js"></script>
	<script src="<%=basePath%>js/Login/LoginAndLogout.js"></script>
	<script src="<%=basePath%>js/toastr.js"></script>
	<script src="<%=basePath%>js/laydate.js"></script>
</body>
</html>