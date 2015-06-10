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
				<td>商品编号</td>
				<td>商品名称</td>
				<td>商品进价</td>
				<td>商品卖价</td>
				<td>商品描述</td>
				<td>商品所属类别</td>
				<td>商品所属套餐</td>
				<td>操作
					<a href="${pageContext.request.contextPath}/goodsAction_addUI" target="right" >添加</a>
				</td>
			</tr>
			<c:forEach var="goods" items="${goodsList}">
				<tr>
					
					 	<td>${goods.id }</td>
						<td>${goods.name}</td>
						<td>${goods.putPrice}</td>
					 	<td>${goods.outPrice }</td>
						<td>${goods.description}</td>
					 	<td>
					 		<c:if test="${goods.goodsCategoriesSet != null && goods.goodsCategoriesSet.size() != 0 }">
								<c:forEach var="goodsCategories" items="${goods.goodsCategoriesSet}">
									${goodsCategories.name }
								</c:forEach>
					 		</c:if>
					 	</td>
					 	<td>
					 		<c:if test="${goods.goodsSetMealSet != null && goods.goodsSetMealSet.size() != 0 }">
								<c:forEach var="goodsSetMeal" items="${goods.goodsSetMealSet}">
									${goodsSetMeal.name }
								</c:forEach>
					 		</c:if>
					 	</td>
					 	<td>
					 		<a href="${pageContext.request.contextPath}/goodsAction_editUI?id=${goods.id }">修改</a>
							<a href="${pageContext.request.contextPath}/goodsAction_delete?id=${goods.id }">删除</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</form>



</body>
</html>
