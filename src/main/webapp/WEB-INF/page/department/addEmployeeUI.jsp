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
	<form action="departmentAction_addEmployee" method="post">
		
		<input type="hidden" name="id" value="${department.id }" />
	
		<h2 style="color:red">正在为${department.name }进行操作</h2>
		<c:choose>
		   <c:when test="${employeeNotDepartmentList == null || employeeNotDepartmentList.size() == 0 }">    <!-- 如果 -->
		   		<h2 style="color:red; ">
		   		
		   			目前没有可用的员工!您可以添加后在进行操作<br/>
		   			<a href="${pageContext.request.contextPath}/employeeAction_addUI" target="right" >添加员工</a>
		   		</h2>
		   </c:when>
		   <c:otherwise>  <!-- 否则 -->
				<table width="auto" height="auto" border="2" >
					<tr>
						<!-- // department employeeNotDepartmentList -->
				        <th scope="col" bgcolor="#33CC00" width="200px"><div align="center" style="color:red;">请选择</div></th> 
				        <th scope="col" bgcolor="#33CC00" width="200px"><div align="center" style="color:red;">员工姓名</div></th> 
					</tr>
					<s:iterator value="#request.employeeNotDepartmentList">
						<tr> 			<%-- <s:property value="%{id in roleIds ? 'checked' : ''}"/> --%>
					        <th scope="col"><div align="center"><input type="checkbox" name="employeeIds" id="checkbox_name_${id }" value="${id}"  />${role.name }<br /></div></th> 
					        <th scope="col"><div align="center">${name}</div></th>
						</tr>
				    </s:iterator>
				   		<tr>	
			        		<th scope="col"><div align="center"><input type="checkbox" name="checkedAll" id="checkedAll"/><br/>全选/取消全选</div></th>
			        		<th scope="col"><div align="center"><input type="submit" value="提交" /></div></th>
			        	</tr>
				</table>
		   </c:otherwise>
		</c:choose>
		<div style="float: right; margin-right: 350px;margin-top: -112px;">
			<c:choose>
			   <c:when test="${department.employeeSet == null || department.employeeSet.size() == 0}">
			   	   <span style="color: red"> <h3>该部门还没有一个员工</h3></span>
			   </c:when>
			   <c:otherwise>  
			   		<h3>该部门目前员工</h3><br/>
			   		<c:forEach var="employee" items="${department.employeeSet}">
			   			员工姓名 : <span style="color: red">${employee.name}</span><br/>
			   		</c:forEach>
			   </c:otherwise>
			</c:choose>
		</div>
	</form>
	<br/>
	<a href="javascript:history.go(-1);">点击返回!</a>
</body>
</html>
