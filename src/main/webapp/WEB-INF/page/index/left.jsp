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


<body>
	<ul class="left_menu">
		<li style="color: red;">系统管理</li>
		<li><a href="${pageContext.request.contextPath}/fileUpAction/list" target="right" >文件上传</a></li>
		<li><hr/></li>
		<li><a href="${pageContext.request.contextPath}/goodsClassification/view" target="right" >商品类别</a></li>
		<li><a href="${pageContext.request.contextPath}/goods/list" target="right" >商品管理</a></li>
		<li><a href="${pageContext.request.contextPath}/goodsSetMeal/list" target="right" >套餐管理</a></li>
		<li><a href="${pageContext.request.contextPath}/goodsOrder/list" target="right" >订单管理</a></li>
		<li><a href="${pageContext.request.contextPath}/client/list" target="right" >客户管理</a></li>
		
		<li><hr/></li>
		<li><a href="${pageContext.request.contextPath}/employee/list" target="right" >员工管理</a></li>
		<li><a href="${pageContext.request.contextPath}/department/list" target="right" >部门管理</a></li>
		<li><a href="${pageContext.request.contextPath}/children/list" target="right" >孩子管理</a></li>
		<li><a href="${pageContext.request.contextPath}/supplier/list" target="right" >供应商管理</a></li>
		<li><a href="${pageContext.request.contextPath}/user/list" target="right" >用户管理</a></li>
		<li><a href="${pageContext.request.contextPath}/privilege/list" target="right" >权限管理</a></li>
		<li><a href="${pageContext.request.contextPath}/role/list" target="right" >角色管理</a></li>

	</ul>

</body>
</html>
