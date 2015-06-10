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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery_treeview/jquery.treeview.css" />
	
<script src="${pageContext.request.contextPath}/js/jquery_treeview/lib/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery_treeview/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery_treeview/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery_treeview/demo/demo.js"></script>

<script>
	$(function() {
		$("#checkedAll").click(function(){

			if($(this).attr("checked") == true){ 
				$("input[name='ids']").each(function(){
					$(this).attr("checked",true);
				});
			}else{
				$("input[name='ids']").each(function(){
					$(this).attr("checked",false);
				});
			}

		});
	});
</script>

<body>
	<form action="goodsClassificationAction/add.action" method="post">
		
		<table width="50%" border="1" >
			<tr>
				<td width="50%">类别名称 :</td>
				<td width="50%"><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>类别商品 :</td>
				<td>
					<!-- goodsList 商品数据列表
					从数据库中查询所有商品,然后循环显示, 显示为check框,有全选和全选取消的功能.	 -->	
					<c:choose>
					   <c:when test="${goodsList != null || goodsList.size() != 0 }">    <!-- 如果 -->
					   		<c:forEach var="goods" items="${goodsList }">
						       <input type="checkbox" name="ids" id="checkbox_name_${goods.id }" value="${goods.id}"  />${goods.name }<br />
					   		</c:forEach>
					   </c:when>
					   <c:otherwise>  <!-- 否则 -->
					   		目前还没有商品!请添加商品后再进行操作.
					   </c:otherwise>
					</c:choose>		
					<br/>
	        		<input type="checkbox"  id="checkedAll"/>全选/取消全选
				</td>
			</tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
