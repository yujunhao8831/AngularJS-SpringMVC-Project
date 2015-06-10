<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>添加员工</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/style.css">

<body>
	<form action="employeeAction_add" method="post">
		<table width="50%" border="1" >
			<tr>
				<td width="50%">员工名称 :</td>
				<td width="50%"><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>员工性别 :</td>
				<td><input type="text" name="sex" /></td>
			</tr>
			<tr>
				<td>员工电话 :</td>
				<td><input type="text" name="phoneNumber" /></td>
			</tr>
			<tr>
				<td>员工地址 :</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>员工描述 :</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>员工身份证 :</td>
				<td><input type="text" name="idCard" /></td>
			</tr>
			<tr>
				<td>员工年龄 :</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>员工生日 :</td>
				<td><input type="text" name="birthday" /></td>
			</tr>
			<tr>
			<tr>
				<td>员工薪水 :</td>
				<td><input type="text" name="salary" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
