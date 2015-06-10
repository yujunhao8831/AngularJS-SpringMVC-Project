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
		$("#checkedGoodsCategorAll").click(function(){

			if($(this).attr("checked") == true){ 
				$("input[name='goodsCategoriesIds']").each(function(){
					$(this).attr("checked",true);
				});
			}else{
				$("input[name='goodsCategoriesIds']").each(function(){
					$(this).attr("checked",false);
				});
			}

		});
		
		$("#checkedGoodsSetMealAll").click(function(){

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
<body>
	<form action="goodsAction_add" method="post">
		<table width="50%" border="1">
			<tr>
				<td width="50%">商品进价 :</td>
				<td width="50%"><input type="text" name="putPrice" /></td>
			</tr>
			<tr>
				<td>商品名称 :</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>商品卖价 :</td>
				<td><input type="text" name="outPrice" /></td>
			</tr>
			<tr>
				<td>商品描述 :</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td colspan="2" >商品所属类别 : <br/> 
					<hr/>
					<c:forEach var="goodsCategories" items="${goodsCategoriesList }">
						<input type="checkbox" name="goodsCategoriesIds" id="checkbox_name_${goodsCategories.id }" value="${goodsCategories.id}"/>${goodsCategories.name }
					</c:forEach>
					<br/>
					<input type="checkbox" name="checkedGoodsCategorAll" id="checkedGoodsCategorAll"/><br/>全选/取消全选
				</td>  
			</tr>
			
			<tr>
				<td colspan="2" >商品所属套餐 : <br/> 
					<hr/>
					<c:forEach var="goodsSetMeal" items="${goodsSetMealList }">
						<input type="checkbox" name="goodsSetMealIds" id="checkbox_name_${goodsSetMeal.id }" value="${goodsSetMeal.id}"/>${goodsSetMeal.name }
					</c:forEach>
					<br/>
					<input type="checkbox" name="checkedGoodsSetMealAll" id="checkedGoodsSetMealAll"/><br/>全选/取消全选
				</td>  
			</tr>
			<td><input type="submit" value="返回" /></td>
			<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
