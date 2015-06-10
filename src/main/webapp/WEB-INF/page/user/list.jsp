<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>伊凡仕影楼系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/style.css">
	
</head>

<body>
	<form action="" method="post">
		<table width="80%" border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td>用户编号</td>
				<td>用户名</td>
				<td>用户密码</td>
				<td>用户角色</td>
				<td>操作
					<a href="${pageContext.request.contextPath}/userAction_addUI" target="right" >添加</a>
				</td>
			</tr>
			<c:forEach var="user" items="${userList}">
				<tr>
					
					 	<td>${user.id }</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>
							<c:if test="${user.roleSet != null && user.roleSet.size() != 0}">
								<c:forEach var="role" items="${user.roleSet }">
									${role.name } </br>
								</c:forEach> 
							</c:if>
						</td>
						
						<td>
							
							<a href="${pageContext.request.contextPath}/userAction_editUI?id=${user.id }">修改</a>
							<a href="${pageContext.request.contextPath}/userAction_delete?id=${user.id }">删除</a>
							<a href="${pageContext.request.contextPath}/userAction_setOrUpdateRoleUI?id=${user.id }">修改/授予角色</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>
