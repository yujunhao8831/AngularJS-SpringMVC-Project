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
				$("input[name='goodsIds']").each(function(){
					$(this).attr("checked",true);
				});
			}else{
				$("input[name='goodsIds']").each(function(){
					$(this).attr("checked",false);
				});
			}

		});
		
	});
</script>
</head>

<body>
	<form action="goodsSetMealAction_add" method="post">
		<input type="hidden" name="isGoodsOrderAction" value="${isGoodsOrderAction }" />
		<input type="hidden" name="isGoodsOrderActionId" value="${isGoodsOrderActionId }" />
		<table width="50%" border="1" >
			<tr>
				<td width="50%">套餐名称 :</td>
				<td width="50%"><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>赠送照片 :</td>
				<td><input type="text" name="givePhotoNumber" /></td>
			</tr>
			<tr>
				<td>套餐价格 :</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td colspan="2" >套餐商品 : <br/> 
					<hr/>
					<c:forEach var="goods" items="${goodsList }">
						<input type="checkbox" name="goodsIds" id="checkbox_name_${goods.id }" value="${goods.id}"/>${goods.name }
					</c:forEach>
					<br/>
					<input type="checkbox" name="checkedAll" id="checkedAll"/><br/>全选/取消全选
				</td>  
			</tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
