<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>添加部门</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery_treeview/jquery.treeview.css" />
</head>
<body>

<form action="roleAction_edit" method="post">
		<table width="50%" border="1" >
			
			<tr>
				<td>角色编号 :</td>
				<td><input type="text" name="id" value="${role.id }"/></td>
			</tr>
			<tr>
				<td>角色名称 :</td>
				<td><input type="text" name="name" value="${role.name }" /></td>
			</tr>
			<tr>
				<td>角色说明 :</td>
				<td><input type="text" name="description" value="${role.description }"/></td>
			</tr>
			<tr>
				<td>角色所属用户 :</td>
				<td>
					<c:if test="${role.userSet != null && role.userSet.size() != 0}">
						<c:forEach var="user" items="role.userSet">
								${userSet.name}
						</c:forEach>
					</c:if>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
</form>	
</body>
</html>
