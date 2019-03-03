<%@page import="com.club.item.Student"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div class="col-lg-10">
			<table border="1" class="table table-bordered table-striped" style="text-align: center;">
				<tr>
					<td width="">序号</td>
					<td width="">学号</td>
					<td width="">姓名</td>
					<td width="" colspan="2">编辑</td>
				</tr>
				<c:forEach items="${student }" var="stu" varStatus="st"  >
				    <tr>
				    	<td>${st.count }</td>
				    	<td>${stu.studentId }</td>
				        <td>${stu.studentName}</td>
				        <td>
							<a href="#">编辑</a>
				        </td>
				        <td>
							<a href="../AdminStudentUpdate?type=deleteStudent&studentId=${stu.studentId }" class="text-capitalize">删除</a>
						</td>
				    </tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<!-- 底部 -->
<jsp:include page="/include/copyright.jsp"></jsp:include>
</body>
</html>