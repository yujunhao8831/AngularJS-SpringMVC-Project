<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
				$("input[name='employeeIds']").each(function(){
					$(this).attr("checked",true);
				});
			}else{
				$("input[name='employeeIds']").each(function(){
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
	<form action="departmentAction_deleteEmployee" method="post">
		
		<input type="hidden" name="id" value="${department.id }" />
		<!-- department employeeSet -->
		
		<h2 style="color:red">正在为[ 部门 : ${department.name } ]进行删除员工操作</h2>
		<c:if test="${employeeSet != null && employeeSet.size() != 0 }">
			<c:forEach var="employee" items="${employeeSet }">
				<input type="checkbox" name="employeeIds" id="checkbox_name_${employee.id }" value="${employee.id}"  />
				${employee.name }<br/>
			</c:forEach>
		</c:if>
		<br/>
		<input type="checkbox" name="checkedAll" id="checkedAll"/><br/>全选/取消全选
		<br/><br/><br/>
		<input type="submit" value="提交" />
		<a href="javascript:history.go(-1);">点击返回!</a>
		
		
		
	</form>
</body>
</html>
