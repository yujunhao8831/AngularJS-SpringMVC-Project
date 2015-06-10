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

<title>修改供应商</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
				$("input[name='childrenIds']").each(function(){
					$(this).attr("checked",true);
				});
			}else{
				$("input[name='childrenIds']").each(function(){
					$(this).attr("checked",false);
				});
			}

		});
	});
</script>

</head>
<!-- 
	 employee 当前需要添加下级的员工 
	 notParentEmployeeList  所有没有上级的员工
-->
<body>
	<h2 style="color: red">正在对 [${employee.name}员工] 进行添加下级员工操作</h2>
	<form action="employeeAction_addChildren" method="post">
		
		<input type="hidden" name="id" value="${employee.id}" />
		<div style="float: left;width: auto;height: auto;">
			<table width="100%" border="1" >
			<c:choose>
			   <c:when test="${notParentEmployeeList != null && notParentEmployeeList.size() != 0 }"> 
			   
			   		<c:forEach var="employee" items="${notParentEmployeeList }">
						<tr>
							<td><input type="checkbox" name="childrenIds" id="checkbox_name_${employee.id }" value="${employee.id}"  />${employee.name }</td>
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
				</c:when>
			   <c:otherwise> 
			   		<h3 style="color: red">现有员工中,都已有各自的上级!<br/>您可用添加新的员工进行操作!</h3>
			   </c:otherwise>
			</c:choose>
				
			</table>
		</div>
	</form>
	<div style="float: right; width: auto;height: auto;background: red;margin-right: 350px">
	// 添加新员工,提交后上级就是  [${employee.name}员工]
		<form action="employeeAction_add" method="post">
			<table width="100%" border="1" >
				<tr>
					<td>员工上级 :</td>
					<td><input type="text" name="parentId" value="${employee.id}" readonly="true"/></td>
				</tr>
				<tr>
					<td width="50%">员工名称 :</td>
					<td width="50%"><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>员工性别 :</td>
					<td><input type="text" name="sex" /></td>
				</tr>
				<tr>
					<td>员工电话 :</td>
					<td><input type="text" name="phoneNumber" /></td>
				</tr>
				<tr>
					<td>员工地址 :</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>员工描述 :</td>
					<td><input type="text" name="description" /></td>
				</tr>
				<tr>
					<td>员工身份证 :</td>
					<td><input type="text" name="idCard" /></td>
				</tr>
				<tr>
					<td>员工年龄 :</td>
					<td><input type="text" name="age" /></td>
				</tr>
				<tr>
					<td>员工生日 :</td>
					<td><input type="text" name="birthday" /></td>
				</tr>
				<tr>
				<tr>
					<td>员工薪水 :</td>
					<td><input type="text" name="salary" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="返回" /></td>
					<td><input type="submit" value="提交" /></td>
				</tr>
			</table>
	
		</form>
	</div>
</body>
</html>
