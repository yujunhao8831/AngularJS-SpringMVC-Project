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
				<td>套餐编号</td>
				<td>套餐名称</td>
				<td>赠送照片(张)</td>
				<td>套餐价格</td>
				<td>套餐内容</td>
				<td>操作
					<a href="${pageContext.request.contextPath}/goodsSetMealAction_addUI?isClientAction=" target="right" >添加</a>
				</td>
			</tr>
			<c:forEach var="goodsSetMeal" items="${goodsSetMealList}">
				<tr>
					
					 	<td>${goodsSetMeal.id }</td>
						<td>${goodsSetMeal.name}</td>
					 	<td>${goodsSetMeal.givePhotoNumber }</td>
						<td>${goodsSetMeal.price}</td>
					 	<td>
					 		<c:if test="${goodsSetMeal.goodsSet != null && goodsSetMeal.goodsSet.size() != 0 }">
								<c:forEach var="goods" items="${goodsSetMeal.goodsSet}">
									${goods.name }
								</c:forEach>
					 		</c:if>
					 	</td>
					 	<td>
					 		<a href="${pageContext.request.contextPath}/goodsSetMealAction_editUI?id=${goodsSetMeal.id }">修改</a>
							<a href="${pageContext.request.contextPath}/goodsSetMealAction_delete?id=${goodsSetMeal.id }">删除</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</form>



</body>
</html>
