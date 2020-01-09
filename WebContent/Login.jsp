<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
      <link href="<%=basePath%>assets/css/ubuntufonts.css"
	rel="stylesheet">
        <link href="<%=basePath%>assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=basePath%>assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="<%=basePath%>assets/plugins/icomoon/style.css" rel="stylesheet">
        <link href="<%=basePath%>assets/plugins/uniform/css/default.css" rel="stylesheet"/>
        <link href="<%=basePath%>assets/plugins/switchery/switchery.min.css" rel="stylesheet"/>
      
        <!-- Theme Styles -->
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
                <!-- Page Inner -->
                <div class="page-inner login-page">
                    <div id="main-wrapper" class="container-fluid">
                        <div class="row">
                            <div class="col-sm-6 col-md-3 login-box">
                                <h4 class="login-title">毕业生就业信息管理系统</h4>
                                <form>
                                    <div class="form-group">
                                        <label >账号</label>
                                        <input type="text" class="form-control" id="user_account"  placeholder="请输入账号">
                                    </div>
                                    <div class="form-group">
                                        <label >密码</label>
                                        <input type="password" class="form-control " id="user_password" placeholder="请输入密码">
                                    </div>
                                   
                                    <a id="login_btn" class="btn btn-primary" onclick="login()">登录</a>
                                </form>
                            </div>
                        </div>
                    </div>
            </div><!-- /Page Content -->
        </div><!-- /Page Container -->
        
        
        <!-- Javascripts -->
        <script src="<%=basePath%>assets/plugins/jquery/jquery-3.1.0.min.js"></script>
        <script src="<%=basePath%>assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=basePath%>assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="<%=basePath%>assets/plugins/uniform/js/jquery.uniform.standalone.js"></script>
        <script src="<%=basePath%>assets/plugins/switchery/switchery.min.js"></script>
        <script src="<%=basePath%>assets/js/ecaps.min.js"></script>
        <script src="<%=basePath%>js/Login/LoginAndLogout.js"></script>
    </body>
</html>