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
<!-- 	
	client 客户数据 
	employeeList员工数据
 -->
<body>
	<h2 style="color: red">正在对 [${client.name}客户] 进行添加受理员工操作</h2>
	<form action="clientAction_addOrUpdateEmployee" method="post">
		
		<input type="hidden" name="id" value="${client.id}" />
		<div style="float: left;width: auto;height: auto;">
			<table width="100%" border="1" >
			<%-- <c:choose>
			   <c:when test="${employeeList != null && employeeList.size() != 0 }">  --%>
			   		<c:forEach var="employee" items="${employeeList }">
						<tr>
							<td><input type="checkbox" name="employeeIds" id="checkbox_name_${employee.id }" value="${employee.id}"/>${employee.name }</td>
							<td>${employee.description }</td>
						</tr>
					</c:forEach>
					<c:forEach var="employee" items="${employeeSet }">
						<tr>
							<td><input type="checkbox" name="employeeIds" id="checkbox_name_${employee.id }" value="${employee.id}" checked="checked"/>${employee.name }</td>
							<td>${employee.description }</td>
						</tr>
					</c:forEach>
					<br/>
					<tr>
						<td>
							<input type="checkbox" name="checkedAll" id="checkedAll"/><br/>全选/取消全选
						</td>	
						<td><input type="submit" value="返回" /><input type="submit" value="提交" /></td>
					</tr>
				<%-- </c:when>
			   	<c:otherwise> 
			   		<h3 style="color: red">您已被所有员工受理过了,无需再受理</h3>
			   		<a href="javascript:history.go(-1);">点击返回!</a>
			   	</c:otherwise>
			</c:choose> --%>
			</table>
		</div>
	</form>
</body>
</html>
