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

<title>伊凡仕影楼系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>


<frameset rows="100,*,25" framespacing=0 border=0 frameborder="0">
	<frame noresize name="TopMenu" scrolling="no" src="${pageContext.request.contextPath}/index/top">
	<frameset cols="180,*" id="resize">
		<frame noresize name="menu" scrolling="yes" src="${pageContext.request.contextPath}/index/left">
		<frame noresize name="right" scrolling="yes" src="${pageContext.request.contextPath}/index/right">
	</frameset>
	<frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath}/index/bottom">
</frameset>

	
</html>
