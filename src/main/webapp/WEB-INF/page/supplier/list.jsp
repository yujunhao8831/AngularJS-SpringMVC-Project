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
				<td>供应商编号</td>
				<td>供应商名称</td>
				<td>供应商电话</td>
				<td>供应商地址</td>
				<td>供应商网址</td>
				<td>供应商邮政编码</td>
				<td>供应商传真</td>
				<td>操作
					<a href="${pageContext.request.contextPath}/supplierAction_addUI" target="right" >添加</a>
				</td>
			</tr>
			<c:forEach var="supplier" items="${supplierList}">
				<tr>
					
					 	<td>${supplier.id }</td>
						<td>${supplier.name}</td>
						<td>${supplier.phoneNumber}</td>
						<td>${supplier.address}</td>
						<td>${supplier.website}</td>
						<td>${supplier.zipCode}</td>
						<td>${supplier.fax}</td>
						<td>
							
							<a href="${pageContext.request.contextPath}/supplierAction_editUI?id=${supplier.id }">修改</a>
							<a href="${pageContext.request.contextPath}/supplierAction_delete?id=${supplier.id }">删除</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</form>



</body>
</html>
