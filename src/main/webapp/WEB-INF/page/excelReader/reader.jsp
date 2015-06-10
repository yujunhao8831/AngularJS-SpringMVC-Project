<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>文件上传</title>

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


	<table width="100%"  border="1" cellspacing="1" cellpadding="1">
		<tr>
			<c:forEach items="${titleList }" var="title">
			<td>
				${title }
			</td>
			</c:forEach>
		</tr>
		
		<c:forEach items="${contentMap }" var="map"> 
			<tr>
				<c:forEach items="${map.value }" var="value">
					<td>${value }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
