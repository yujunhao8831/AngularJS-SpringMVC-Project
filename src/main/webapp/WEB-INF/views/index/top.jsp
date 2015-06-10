<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<h1 style="text-align: center; color: green;">伊凡仕影楼系统</h1>
<div style="float: right; margin-top: -50px; padding-bottom: 80px; padding-right: 50px">
	<h3 style="color: red">欢迎${user.username}</h3>
	<a href="${pageContext.request.contextPath}/loginAction_login.action" target="new">退出</a>
</div>

