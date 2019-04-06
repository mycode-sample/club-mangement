<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../jquery/jquery.min.js"></script>
<link rel="stylesheet" href="../bootstrap/css/bootstrap/3.3.6/bootstrap.min.css">
<script type="text/javascript" src="../bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/logo.css">
<link rel="stylesheet" href="../css/default.css">
<title>社团管理-学生</title>
</head>
<body>
	<!-- 头部 -->
	<jsp:include page="/include/header.jsp"></jsp:include>
	<!-- 体部 -->
	<div class="container">
		<div class="row">
			<!-- 导航栏 -->
			<div class="col-lg-2">
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
									<font class="text-info">个人中心</font>
								</a>
							</h4>
							<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							  <div class="panel-body">
								<ul class="nav nav-pills nav-stacked" style="width:100px">
								  <li role="presentation"><a href="#" class="text-primary">修改密码</a></li>
								  <li role="presentation"><a href="#" class="text-primary">修改用户名</a></li>
								</ul>
							  </div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 内容栏 -->
			<div class="col-lg-10">
				
			</div>
		</div>
	</div>
	<!-- 底部 -->
	<jsp:include page="/include/copyright.jsp"></jsp:include>
</body>
</html>