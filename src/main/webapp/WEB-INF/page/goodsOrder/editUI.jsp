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
	<form action="goodsOrderAction_edit" method="post">
		<table width="50%" border="1" >
			<tr>
				<td>订单编号 :</td>
				<td><input type="text" name="id" value="${goodsOrder.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td>预约收款 :</td>
				<td><input type="text" name="reservationReceipts" value="${goodsOrder.reservationReceipts}"/></td>
			</tr>
			<tr>
				<td>预约时间 :</td>
				<td><input type="text" name="anAppointmentTime" value="${goodsOrder.anAppointmentTime}"/></td>
			</tr>
			<tr>
				<td>预约打折 :</td>
				<td><input type="text" name="bookingDiscount" value="${goodsOrder.bookingDiscount}"/></td>
			</tr>
			<tr>
				<td>拍照时间 :</td>
				<td><input type="text" name="timeToTakePhotographs" value="${goodsOrder.timeToTakePhotographs}"/></td>
			</tr>
			<tr>
				<td>选片时间 :</td>
				<td><input type="text" name="chipSelectTime" value="${goodsOrder.chipSelectTime}"/></td>
			</tr>
			<tr>
				<td>已收款 :</td>
				<td><input type="text" name="hasReceivables" value="${goodsOrder.hasReceivables}"/></td>
			</tr>
			<tr>
				<td>应收款 :</td>
				<td><input type="text" name="receivables" value="${goodsOrder.receivables}"/></td>
			</tr>
			<tr>
				<td>欠款 :</td>
				<td><input type="text" name="arrears" value="${goodsOrder.arrears}"/></td>
			</tr>
			<tr>
				<td>总价 :</td>
				<td><input type="text" name="price" value="${goodsOrder.price}"/></td>
			</tr>
			<tr>
				<td>套餐 :</td>
				<td>
				<c:if test="${goodsOrder.goodsSetMealSet != null && goodsOrder.goodsSetMealSet.size() != 0}">
					<c:forEach var="goodsSetMeal" items="${goodsOrder.goodsSetMealSet }">
						<input type="text" name="goodsSetMealSet" value="${goodsSetMeal.name }" /> 
					</c:forEach>
				</c:if>
				</td>
			</tr>
			<tr>
				<td>订单所有者 :</td>
				<c:if test="${goodsOrder.client != null}">
					<td><span style="color: red">${goodsOrder.client.name}</span></td>
					<input type="hidden" name="clientId" value="${goodsOrder.client.id}"/>
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
