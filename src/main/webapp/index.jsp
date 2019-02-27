<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="include/include.html" %>
<title>社团管理-首页</title>
<style>
	.index-img{
		width: auto;
		height: 300px;
	}
</style>
</head>
<body>  
	<!-- 头部，显示当前登录账号 -->
	<jsp:include page="include/header.jsp"></jsp:include>
	<!-- 体部 -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8">
				<!-- 轮播图 -->
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
				</ol>
				<!-- Wrapper for slides -->
				<div class="carousel-inner index-img" role="listbox">
					<div class="item active">
						<img src="image/Chrysanthemum.jpg" >
					</div>
					<div class="item">
							<img src="image/Chrysanthemum.jpg" >
					</div>
					<div class="item">
							<img src="image/Koala.jpg" >
					</div>
				
					<div class="item">
							<img src="image/Jellyfish.jpg" >
					</div>
				</div>
					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					</a>
				</div>
			</div>
			<!-- 登录框 -->
			<div class="col-lg-3">
				<div class="text-info" style="margin: 5px;font-size: large;">登录</div>
				<form  action="Login" method="post" name="userLogin">
					<div class="input-group" style="margin: 5px;">
						<span class="input-group-addon glyphicon glyphicon-user" style="top: 0px;"></span>
						<input type="text" name="username" class="form-control" placeholder="用户名">
					</div>
					<div class="input-group" style="margin: 5px;">
						<span class="input-group-addon glyphicon glyphicon-lock" style="top: 0px;"></span>
						<input type="password" class="form-control" name="password" placeholder="密码">
					</div>
					<div class="input-group" style="margin: 5px;text-align: center;">
						<input type="radio" checked="checked" value="club" name="user">社团
						<input type="radio"  value="admin" name="user">管理员
						<input type="radio"  value="teacher" name="user">老师
						<input type="radio"  value="student" name="user">学生
					</div>
					<div class="btn-group">
						<input type="submit"  value="登录" class="btn btn-default">
					</div>
				</form>
			</div>
		</div>
		
	</div>
	<!-- 尾部 -->
	<jsp:include page="include/copyright.jsp"></jsp:include>
</body>
</html>