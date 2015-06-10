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

<title>添加部门</title>

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
	<form action="goodsOrderAction_add" method="post">
		<table width="50%" border="1" >
			<tr>
				<td width="50%">预约收款 :</td>
				<td width="50%"><input type="text" name="reservationReceipts" /></td>
			</tr>
			<tr>
				<td>预约时间 :</td>
				<td><input type="text" name="anAppointmentTime" /></td>
			</tr>
			<tr>
				<td>预约打折 :</td>
				<td><input type="text" name="bookingDiscount" /></td>
			</tr>
			<tr>
				<td>拍照时间 :</td>
				<td><input type="text" name="timeToTakePhotographs" /></td>
			</tr>
			<tr>
				<td>选片时间 :</td>
				<td><input type="text" name="chipSelectTime" /></td>
			</tr>
			<tr>
				<td>已收款 :</td>
				<td><input type="text" name="hasReceivables" /></td>
			</tr>
			<tr>
				<td>应收款 :</td>
				<td><input type="text" name="receivables" /></td>
			</tr>
			<tr>
				<td>欠款 :</td>
				<td><input type="text" name="arrears" /></td>
			</tr>
			<tr>
				<td>总价 :</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>套餐 :</td>
				<td><input type="text" name="goodsSetMealSet" /></td>
			</tr>
			<tr>
				<td>订单所有者 :</td>
				<td><input type="text" name="client" /></td>
			</tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
