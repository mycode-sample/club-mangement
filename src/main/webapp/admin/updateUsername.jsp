<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../include/frame.jsp" %>
<link rel="stylesheet" href="../css/default.css">
<title>社团管理-管理员</title>
</head>
<body>
	<!-- 头部 -->
	<jsp:include page="../include/header.jsp"></jsp:include>
	<!-- 体部 -->
	<div class="container">
		<div class="row">
			<!-- 导航栏 -->
			<jsp:include page="../include/adminNavigation.jsp"></jsp:include>
			<!-- 内容栏 -->
			<div class="col-lg-3"></div>
			<div class="col-lg-3">
				<div  class="text-info" style="text-align: center;font-size: xx-large;">
					<form  action="../AdminImp" method="post" name="userLogin">
						<input type="hidden" name="adminType" value="updateUsername">
						<input type="hidden" name="id" value=${user.administratorId }>
						<div class="input-group" style="margin: 5px;">
							<span class="input-group-addon glyphicon glyphicon-lock" style="top: 0px;"></span>
							<input type="password" class="form-control" name="username" placeholder="用户名">
						</div>
						<div class="btn-group">
							<input type="submit"  value="确认修改" class="btn btn-default">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 底部 -->
	<jsp:include page="/include/copyright.jsp"></jsp:include>
</body>
</html>