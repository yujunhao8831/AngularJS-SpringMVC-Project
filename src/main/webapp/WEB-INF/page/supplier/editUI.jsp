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

<title>修改供应商</title>

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
	<form action="supplierAction_edit" method="post">
		<table width="50%" border="1" >
			<tr>
				<td>供应商编号 :</td>
				<td><input type="text" name="id" value="${supplier.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td width="50%">供应商名称 :</td>
				<td width="50%"><input type="text" name="name" value="${supplier.name }"/></td>
			</tr>
			<tr>
				<td>供应商电话 :</td>
				<td><input type="text" name="phoneNumber" value="${supplier.phoneNumber}"/></td>
			</tr>
			<tr>
				<td>供应商地址 :</td>
				<td><input type="text" name="address" value="${supplier.address}"/></td>
			</tr>
			<tr>
				<td>供应商网址 :</td>
				<td><input type="text" name="website" value="${supplier.website}"/></td>
			</tr>
			<tr>
				<td>供应商邮政编码 :</td>
				<td><input type="text" name="zipCode" value="${supplier.zipCode}"/></td>
			</tr>
			<tr>
				<td>供应商传真 :</td>
				<td><input type="text" name="fax" value="${supplier.fax}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
