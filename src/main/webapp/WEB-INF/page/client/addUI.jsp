<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>添加客户</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/style.css">

<body>
	<form action="clientAction_add" method="post">
		<table width="50%" border="1" >
			<tr>
				<td width="50%">客户名称 :</td>
				<td width="50%"><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>客户性别 :</td>
				<td><input type="text" name="sex" /></td>
			</tr>
			<tr>
				<td>客户电话 :</td>
				<td><input type="text" name="phoneNumber" /></td>
			</tr>
			<tr>
				<td>客户生日 :</td>
				<td><input type="text" name="birthday" /></td>
			</tr>
			<tr>
				<td>客户年龄 :</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>客户地址 :</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>客户描述 :</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>客户结婚时间 :</td>
				<td><input type="text" name="marriageTime" /></td>
			</tr>
			<tr>
				<td>客户受理于哪个员工 :</td>
				<td>
					<select name="employeeIds" id="employeeIds">
						<option selected="selected" value="">请选择</option>
							<c:choose>
							   <c:when test="${employeeList != null && employeeList.size() != 0 }">   
							   		<c:forEach var="employee" items="${employeeList }">
										<option value="${employee.id}" >${employee.name}</option>							   		
							   		</c:forEach>
							   </c:when>
							   <c:otherwise> 
							   		<option value="" >系统目前没有员工!</option>
							   </c:otherwise>
							</c:choose>
					</select>
				</td>
			</tr>
			<tr>
				<td>客户订单 :</td>
				<td><input type="text" name="goodsOrderSet" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
