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
				<td>客户编号</td>
				<td>客户姓名</td>
				<td>客户性别</td>
				<td>客户电话</td>
				<td>客户生日</td>
				<td>客户年龄</td>
				<td>客户地址</td>
				<td>客户描述</td>
				<td>客户结婚时间</td>
				<td>客户孩子</td>
				<td>客户受理与哪个员工</td>
				<td>客户订单</td>
				<td>操作
					<a href="${pageContext.request.contextPath}/clientAction_addUI" target="right" >添加</a>
				</td>
			</tr>
			<c:forEach var="client" items="${clientList}">
				<tr>
					
					 	<td>${client.id }</td>
						<td>${client.name}</td>
						<td>${client.sex}</td>
					 	<td>${client.phoneNumber }</td>
					 	<td>${client.birthday }</td>
						<td>${client.age}</td>
					 	<td>${client.address }</td>
						<td>${client.description}</td>
						<td>${client.marriageTime}</td>
						<td>
							<c:if test="${client.childrenSet != null && client.childrenSet.size() != 0}">
								<c:forEach var="children" items="${client.childrenSet}">
									${children.name } </br>
								</c:forEach>
							</c:if>
						</td>
						<td>
							<c:if test="${client.employeeSet != null && client.employeeSet.size() != 0}">
								<c:forEach var="employee" items="${client.employeeSet}">
									${employee.name } </br>
								</c:forEach>
							</c:if>
						</td>
						
						<td>
							<c:if test="${client.goodsOrderSet != null && client.goodsOrderSet.size() != 0}">
								<c:forEach var="goodsOrder" items="${client.goodsOrderSet}">
									${goodsOrder.id } </br>
								</c:forEach>
							</c:if>
						</td>
						
						<td>
							
							<a href="${pageContext.request.contextPath}/clientAction_editUI?id=${client.id }">修改</a>
							<a href="${pageContext.request.contextPath}/clientAction_delete?id=${client.id }">删除</a>
							<a href="${pageContext.request.contextPath}/clientAction_addChildrenUI?id=${client.id}">添加孩子</a>
							<a href="${pageContext.request.contextPath}/clientAction_addOrUpdateEmployeeUI?id=${client.id}">修改受理员工</a>
							<a href="${pageContext.request.contextPath}/goodsOrderAction_addOrderUI?clientId=${client.id}">下订单</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>
