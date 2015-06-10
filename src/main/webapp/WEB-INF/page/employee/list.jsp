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
		<table width="100%" border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td>员工编号</td>
				<td>员工名称</td>
				<td>员工性别</td>
				<td>员工电话</td>
				<td>员工地址</td>
				<td>员工描述</td>
				<td>员工身份证</td>
				<td>员工年龄</td>
				<td>员工生日</td>
				<td>员工薪水</td>
				<td>员工上级</td>
				<td>员工下级</td>
				<td>员工部门</td>
				<td>员工的客户</td>
				<td>操作
					<a href="${pageContext.request.contextPath}/employeeAction_addUI" target="right" >添加</a>
				</td>
			</tr>
			<c:forEach var="employee" items="${employeeList}">
				<tr>
					 	<td>${employee.id }</td>
						<td>${employee.name}</td>
						<td>${employee.sex}</td>
						<td>${employee.phoneNumber}</td>
						<td>${employee.address}</td>
						<td>${employee.description}</td>
						<td>${employee.idCard}</td>
						<td>${employee.age}</td>
						<td>${employee.birthday}</td>
						<td>${employee.salary}</td>
						<td style="width: 150px">
							<c:if test="${employee.parent != null }"> 
								${employee.parent.name }
							</c:if>
						</td>
						<td style="width: 150px">
							<c:if test="${employee.children != null && employee.children.size() != 0}">
								<c:forEach var="children" items="${employee.children}">
									${children.name }
									<br/>
								</c:forEach>
							</c:if>
						</td>
						<td>
							<c:if test="${employee.department != null }">
								${employee.department.name}
							</c:if>
						</td>
						<td>
							<c:if test="${employee.clientSet != null && employee.clientSet.size() != 0 }">
								<c:forEach var="client" items="${employee.clientSet}">
									${client.name }<br/>
								</c:forEach>
							</c:if>
						</td>
						
						<td>
							
							<a href="${pageContext.request.contextPath}/employeeAction_editUI?id=${employee.id }">修改</a>
							<a href="${pageContext.request.contextPath}/employeeAction_delete?id=${employee.id }">删除</a>
							<a href="${pageContext.request.contextPath}/employeeAction_addChildrenUI?id=${employee.id }">添加下级</a>
							
						</td>
				</tr>
			</c:forEach>
		</table>
	</form>



</body>
</html>
