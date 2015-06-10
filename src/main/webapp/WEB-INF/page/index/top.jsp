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

<title>CRM</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body >
	
	<h1 style="text-align: center;color: green; ">OPEN CRM SYSTEM</h1>
	<div style="float: right; margin-top:-50px; padding-bottom: 80px; padding-right: 50px">
		<h3 style="color: red">欢迎${user.username}</h3>
		<a href="${pageContext.request.contextPath}/login/loginUI.action" target="new">退出</a>
	</div>
</body>

</html>
