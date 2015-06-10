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

<title>添加部门</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<script src="${pageContext.request.contextPath}/js/jquery_treeview/lib/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery_treeview/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery_treeview/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery_treeview/demo/demo.js"></script>

<script>
	$(function() {
		$("#checkedAll").click(function(){

			if($(this).attr("checked") == true){ 
				$("input[name='goodsSetMealIds']").each(function(){
					$(this).attr("checked",true);
				});
			}else{
				$("input[name='goodsSetMealIds']").each(function(){
					$(this).attr("checked",false);
				});
			}

		});
	});
</script>

</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/style.css">

<body>
	<table width="80%" border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td>客户编号</td>
				<td>客户姓名</td>
				<td>客户性别</td>
				<td>客户电话</td>
				<td>客户生日</td>
				<td>客户年龄</td>
				<td>客户地址</td>
				<td>客户描述</td>
				<td>客户结婚时间</td>
				<td>客户孩子</td>
			</tr>
			<tr>
			 	<td>${client.id }</td>
				<td>${client.name}</td>
				<td>${client.sex}</td>
			 	<td>${client.phoneNumber }</td>
			 	<td>${client.birthday }</td>
				<td>${client.age}</td>
			 	<td>${client.address }</td>
				<td>${client.description}</td>
				<td>${client.marriageTime}</td>
				<td>
					<c:if test="${client.childrenSet != null && client.childrenSet.size() != 0}">
						<c:forEach var="children" items="${client.childrenSet}">
							${children.name } </br>
						</c:forEach>
					</c:if>
				</td>
			</tr>
		</table>
	<form action="goodsOrderAction_addOrder" method="post">
		
		<input type="hidden" name="clientId" value="${client.id }" />
		
		<table width="80%" border="1" >
			<tr>
				<td>套餐 :</td>
				<td>
					<!-- goodsSetMealSet : 套餐内容 -->
					<c:choose>
						<c:when test="${goodsSetMealSet != null && goodsSetMealSet.size() != 0 }">
							<c:forEach var="goodsSetMeal" items="${goodsSetMealSet }">
								<input type="checkbox" name="goodsSetMealIds" id="checkbox_name_${goodsSetMeal.id }" value="${goodsSetMeal.id}"/>${goodsSetMeal.name }
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h3 style="color: red">系统当前还没有添加套餐,请添加完套餐后再进行操作!</h3>
							<br/>
							<a href="${pageContext.request.contextPath}/goodsSetMealAction_addUI?isClientAction=clientAction_addOrderUI&isClientActionId=${client.id}" target="right" >添加</a>
						</c:otherwise>
					</c:choose>
					<br/>
					<br/>
					全选/取消全选<input type="checkbox" name="checkedAll" id="checkedAll"/><br/>
					<a href="${pageContext.request.contextPath}/goodsSetMealAction_addUI?isClientAction=clientAction_addOrderUI&isClientActionId=${client.id}" target="right" >自定义套餐</a>
				</td>
			</tr>
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
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
	
</body>
</html>
