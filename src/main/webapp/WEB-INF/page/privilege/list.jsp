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
				<td>权限编号</td>
				<td>权限名称</td>
				<td>权限URL</td>
				<td>权限角色</td>
			</tr>
			<c:forEach var="privilege" items="${privilegeList}">
				<tr>
					
					 	<td>${privilege.id }</td>
						<td>${privilege.name}</td>
						<td>${privilege.url}</td>
						<td>
							<c:if test="${privilege.roleSet != null && privilege.roleSet.size() != 0}">
								<c:forEach var="role" items="${privilege.roleSet}">
									${role.name } </br>
								</c:forEach>
							</c:if>
						</td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>
