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
	<form action="goodsClassificationAction/edit/${model.id }" method="post">
		<input type="hidden" name="_method" value="PUT" />
		<table width="50%" border="1" >
			<tr>
				<td>类别编号 :</td>
				<td><input type="text" name="id" value="${model.id}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>类别名称 :</td>
				<td><input type="text" name="name" value="${model.name}"/></td>
			</tr>
			<tr>
				
				<td colspan="2" >类别包含的商品 : <br/> 
				<hr/>
					
					<c:forEach var="goods" items="${goodsSet }">
						<input type="checkbox" name="goodsIds" id="checkbox_name_${goods.id }" value="${goods.id}" checked="checked"/>${goods.name }  
					</c:forEach>
					
					<c:forEach var="goods" items="${goodsList }">
						<input type="checkbox" name="goodsIds" id="checkbox_name_${goods.id }" value="${goods.id}"/>${goods.name }  
					</c:forEach>
					
					<br/>
					<input type="checkbox" name="checkedAll" id="checkedAll"/>全选/取消全选
				</td>  
				
				
				
			</tr>
			<tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
