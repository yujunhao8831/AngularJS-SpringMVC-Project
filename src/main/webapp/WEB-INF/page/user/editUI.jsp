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

<title>修改部门</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form action="userAction_edit" method="post">
		<table width="50%" border="1" >
			<tr>
				<td>客户编号 :</td>
				<td><input type="text" name="id" value="${user.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td>用户名 :</td>
				<td><input type="text" name="username" value="${user.username}"/></td>
			</tr>
			<tr>
				<td>密码 :</td>
				<td><input type="text" name="password" value="${user.password}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
