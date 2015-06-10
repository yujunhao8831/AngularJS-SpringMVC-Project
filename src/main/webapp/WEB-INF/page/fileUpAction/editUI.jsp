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
	<form action="childrenAction_edit" method="post">
		<input type="hidden" name="isClientAction" value="${isClientAction}" />  
		<input type="hidden" name="isClientActionId" value="${isClientActionId}" />
		<table width="50%" border="1" >
			<tr>
				<td>孩子编号 :</td>
				<td><input type="text" name="id" value="${children.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td>孩子姓名 :</td>
				<td><input type="text" name="name" value="${children.name}"/></td>
			</tr>
			<tr>
				<td>孩子性别 :</td>
				<td><input type="text" name="sex" value="${children.sex}"/></td>
			</tr>
			<tr>
				<td>孩子生日 :</td>
				<td><input type="text" name="birthday" value="${children.birthday}"/></td>
			</tr>
			<tr>
				<td>孩子年龄 :</td>
				<td><input type="text" name="age" value="${children.age}"/></td>
			</tr>
			<tr>
				<td>孩子爱好 :</td>
				<td><input type="text" name="hobbies" value="${children.hobbies}"/></td>
			</tr>
			<tr>
				<td>孩子描述 :</td>
				<td><input type="text" name="description" value="${children.description}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
