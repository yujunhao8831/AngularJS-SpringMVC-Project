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

<title>修改部门</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form action="clientAction_edit" method="post">
		<table width="50%" border="1" >
			<tr>
				<td>客户编号 :</td>
				<td><input type="text" name="id" value="${client.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td>客户名称 :</td>
				<td><input type="text" name="name" value="${client.name}"/></td>
			</tr>
			<tr>
				<td>客户性别 :</td>
				<td><input type="text" name="sex" value="${client.sex}"/></td>
			</tr>
			<tr>
				<td>客户电话 :</td>
				<td><input type="text" name="phoneNumber" value="${client.phoneNumber}"/></td>
			</tr>
			<tr>
				<td>客户生日 :</td>
				<td><input type="text" name="birthday" value="${client.birthday}"/></td>
			</tr>
			<tr>
				<td>客户年龄 :</td>
				<td><input type="text" name="age" value="${client.age}"/></td>
			</tr>
			<tr>
				<td>客户地址 :</td>
				<td><input type="text" name="address" value="${client.address}"/></td>
			</tr>
			<tr>
				<td>客户描述 :</td>
				<td><input type="text" name="description" value="${client.description}"/></td>
			</tr>
			<tr>
				<td>客户结婚时间 :</td>
				<td><input type="text" name="marriageTime" value="${client.marriageTime}"/></td>
			</tr>
			<tr>
				<td>客户孩子 :</td>
				<c:if test="${client.childrenSet != null && client.childrenSet.size() != 0}">
					<td>
						<c:forEach var="children" items="${client.childrenSet}">
							<a href="${pageContext.request.contextPath}/childrenAction_editUI?id=${client.id}&isClientAction=clientAction_editUI&isClientActionId=${client.id}">${children.name }</a>
						</c:forEach>
						点击进入页面修改.
					</td>
				</c:if>
			</tr>
			<tr>
				<td>客户订单 :</td>
				<c:if test="${client.goodsOrderSet != null && client.goodsOrderSet.size() != 0}">
					<td><input type="text" name="goodsOrderSet" value="${client.goodsOrderSet}"/></td>
				</c:if>
			</tr>
			<tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
