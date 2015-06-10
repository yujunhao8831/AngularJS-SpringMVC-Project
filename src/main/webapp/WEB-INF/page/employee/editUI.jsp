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

<title>修改供应商</title>

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
	<form action="employeeAction_edit" method="post">
		<table width="50%" border="1" >
			<tr>
				<td>员工编号 :</td>
				<td><input type="text" name="id" value="${employee.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td width="50%">员工名称 :</td>
				<td width="50%"><input type="text" name="name" value="${employee.name }"/></td>
			</tr>
			<tr>
				<td width="50%">员工性别 :</td>
				<td width="50%"><input type="text" name="sex" value="${employee.sex }"/></td>
			</tr>
			<tr>
				<td>员工电话 :</td>
				<td><input type="text" name="phoneNumber" value="${employee.phoneNumber}"/></td>
			</tr>
			<tr>
				<td>员工地址 :</td>
				<td><input type="text" name="address" value="${employee.address}"/></td>
			</tr>
			<tr>
				<td>员工描述 :</td>
				<td><input type="text" name="description" value="${employee.description}"/></td>
			</tr>
			<tr>
				<td>员工身份证 :</td>
				<td><input type="text" name="idCard" value="${employee.idCard}"/></td>
			</tr>
			<tr>
				<td>员工年龄 :</td>
				<td><input type="text" name="age" value="${employee.age}"/></td>
			</tr>
			<tr>
				<td>员工生日 :</td>
				<td><input type="text" name="birthday" value="${employee.birthday}"/></td>
			</tr>
			<tr>
				<td>员工薪水 :</td>
				<td><input type="text" name="salary" value="${employee.salary}"/></td>
			</tr>
			<%-- <tr>
				<td>员工上级 :</td>
				<c:if test="${employee.parent != null }">
				<td><input type="text" name="parent" value="${employee.parent}"/></td>
				</c:if>
			</tr>
			<tr>
				<td>员工下级 :</td>
				 <c:if test="${employee.children != null && employee.children.size() != 0 }">
					<td><input type="text" name="children" value="${employee.children}"/></td>
				</c:if> 
			</tr> --%>
			<tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
