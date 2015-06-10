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
		<table width="70%" border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td>部门编号</td>
				<td>部门名称</td>
				<td>部门员工</td>
				<td>操作
					<a href="${pageContext.request.contextPath}/departmentAction_addUI" target="right" >添加</a>
				</td>
			</tr>
			<c:forEach var="department" items="${departmentList}">
				<tr>
					
					 	<td>${department.id }</td>
						<td>${department.name}</td>
						<td>
							<c:choose>
							   <c:when test="${department.employeeSet == null || department.employeeSet.size() == 0}">   
							   	<h3 style="color: green;">该部门还没有员工</h3> 
							   </c:when>
							   
							   <c:otherwise>  
						   		<c:forEach var="employee" items="${department.employeeSet}">
						   			${employee.name }
								</c:forEach>
							   </c:otherwise>
							</c:choose>
						</td>
						<td>
							
							<a href="${pageContext.request.contextPath}/departmentAction_editUI?id=${department.id }">修改部门</a>
							<a href="${pageContext.request.contextPath}/departmentAction_delete?id=${department.id }">删除部门</a>
							<a href="${pageContext.request.contextPath}/departmentAction_addEmployeeUI?id=${department.id }">添加员工</a>
							<a href="${pageContext.request.contextPath}/departmentAction_deleteEmployeeUI?id=${department.id }">删除员工</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</form>



</body>
</html>
