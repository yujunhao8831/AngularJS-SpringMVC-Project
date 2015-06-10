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

<title>伊凡仕影楼系统</title>

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
	<form action="" method="post">
		<table width="80%" border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td>订单编号</td>
				<td>预约收款</td>
				<td>预约时间</td>
				<td>预约打折</td>
				<td>拍照时间</td>
				<td>选片时间</td>
				<td>已收款</td>
				<td>应收款</td>
				<td>欠款</td>
				<td>总价</td>
				<td>套餐</td>
				<td>订单所有者</td>
				<td>操作
					<a href="${pageContext.request.contextPath}/goodsOrderAction_addUI" target="right" >添加</a>
				</td>
			</tr>
			<c:forEach var="goodsOrder" items="${goodsOrderList}">
				<tr>
					
					 	<td>${goodsOrder.id }</td>
						<td>${goodsOrder.reservationReceipts}</td>
						<td>${goodsOrder.anAppointmentTime}</td>
					 	<td>${goodsOrder.bookingDiscount }</td>
						<td>${goodsOrder.timeToTakePhotographs}</td>
					 	<td>${goodsOrder.chipSelectTime }</td>
						<td>${goodsOrder.hasReceivables}</td>
						<td>${goodsOrder.receivables}</td>
						<td>${goodsOrder.arrears}</td>
						<td>${goodsOrder.price}</td>
						<td>
							<c:if test="${goodsOrder.goodsSetMealSet != null && goodsOrder.goodsSetMealSet.size() != 0}">
								<c:forEach var="goodsSetMeal" items="${goodsOrder.goodsSetMealSet }">
									${goodsSetMeal.name }
								</c:forEach>
							</c:if>
						</td>
						<td>
							<c:if test="${goodsOrder.client != null}">
								${goodsOrder.client.name}
							</c:if>
						</td>
						<td>
							
							<a href="${pageContext.request.contextPath}/goodsOrderAction_editUI?id=${goodsOrder.id }">修改</a>
							<a href="${pageContext.request.contextPath}/goodsOrderAction_delete?id=${goodsOrder.id }">删除</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</form>



</body>
</html>
