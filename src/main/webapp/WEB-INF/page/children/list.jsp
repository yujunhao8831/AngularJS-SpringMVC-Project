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
				<td>孩子编号</td>
				<td>孩子姓名</td>
				<td>孩子性别</td>
				<td>孩子生日</td>
				<td>孩子年龄</td>
				<td>孩子爱好</td>
				<td>孩子描述</td>
				<td>孩子父母</td>
				<td>操作
					<a href="${pageContext.request.contextPath}/childrenAction_addUI" target="right" >添加</a>
				</td>
			</tr>
			<c:forEach var="children" items="${childrenList}">
				<tr>
					
					 	<td>${children.id }</td>
						<td>${children.name}</td>
						<td>${children.sex}</td>
					 	<td>${children.birthday }</td>
						<td>${children.age}</td>
					 	<td>${children.hobbies }</td>
						<td>${children.description}</td>
						<td>
							<c:if test="${children.client != null}">
								${children.client.name}
							</c:if>
						</td>
						<td>
							
							<a href="${pageContext.request.contextPath}/childrenAction_editUI?id=${children.id }">修改</a>
							<a href="${pageContext.request.contextPath}/childrenAction_delete?id=${children.id }">删除</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</form>



</body>
</html>
