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
				<td>角色编号</td>
				<td>角色姓名</td>
				<td>角色说明</td>
				<td>角色权限</td>
				<td>角色所属用户</td>
				<td>操作
					<a href="${pageContext.request.contextPath}/roleAction_addUI" target="right" >添加</a>
				</td>
			</tr>
			<c:forEach var="role" items="${roleList}">
				<tr>
					 	<td>${role.id }</td>
						<td>${role.name}</td>
						<td>${role.description}</td>
						<td>
							<c:if test="${role.privilegeSet != null && role.privilegeSet.size() != 0}">
								<c:forEach var="privilege" items="${role.privilegeSet}">
									${privilege.name },
								</c:forEach>
							</c:if>
						</td>
						<td>
							<c:if test="${role.userSet != null && role.userSet.size() != 0}">
								<c:forEach var="user" items="${role.userSet}">
									${user.username}
								</c:forEach>
							</c:if>
						</td>
						<td>
							
							<a href="${pageContext.request.contextPath}/roleAction_editUI?id=${role.id }">修改</a>
							<a href="${pageContext.request.contextPath}/roleAction_delete?id=${role.id }">删除</a>
							<a href="${pageContext.request.contextPath}/roleAction_setOrUpdatePrivilegeUI?id=${role.id }">设置/修改权限</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</form>



</body>
</html>
