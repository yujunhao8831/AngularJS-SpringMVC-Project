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
				$("input[name='roleIds']").each(function(){
					$(this).attr("checked",true);
				});
			}else{
				$("input[name='roleIds']").each(function(){
					$(this).attr("checked",false);
				});
			}

		});
	});
</script>
</head>
<body>
	<!-- user 对哪个用户操作? -->
	<!-- roleList 所有角色 -->
	<!-- roleIds 所有角色对应的Id -->
	<form action="userAction_setOrUpdateRole" method="post">
		<input type="hidden" name="id" value="${user.id }" />
	
		<h2 style="color:red">正在为${user.username }进行操作</h2>
		
		<c:choose>
		   <c:when test="${roleList == null || roleList.size() == 0 }">    <!-- 如果 -->
		   		<h2 style="color:red; ">系统还没有添加角色,请添加角色并授权后在进行操作</h2>
		   </c:when>
		   <c:otherwise>  <!-- 否则 -->
				<table width="50%" height="100%" border="2" >
					<tr>
				        <th scope="col" bgcolor="#33CC00" width="20%"><div align="center" style="color:red;">角色名称</div></th> 
				        <th scope="col" bgcolor="#33CC00" width="30%"><div align="center" style="color:red;">角色说明</div></th>
					</tr>
					<s:iterator value="#request.roleList">
						<tr>
					        <th scope="col"><div align="left"><input type="checkbox" name="roleIds" id="checkbox_name_${id }" value="${id}" <s:property value="%{id in roleIds ? 'checked' : ''}"/> />${role.name }<br /></div></th> 
					        <th scope="col"><div align="center">${description}</div></th>
						</tr>
				    </s:iterator>
				   		<tr>	
			        		<th scope="col"><div align="left"><input type="checkbox" name="checkedAll" id="checkedAll"/>全选/取消全选</div></th>
			        		<th scope="col"><div align="center"><input type="submit" value="提交" /></div></th>
			        	</tr>
				</table>
		   </c:otherwise>
		</c:choose>
	</form>	
</body>
</html>
