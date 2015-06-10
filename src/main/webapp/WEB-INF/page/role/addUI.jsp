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
	function doSelectAll(checked) {
		$("[name=privilegeIds]").attr("checked", checked);
	}

	$(function() {
		$("#tree").treeview();

		// 给所有的权限复选框加上click事件
		$("[name=privilegeIds]").click(
				function() {
					var checked = this.checked; // 当前触发事件的复选框的选中状态

					// 当选中或取消一个权限时，应同时也选中或取消他的所有下级
					$(this).siblings("ul").find("input").attr("checked",
							checked);

					// 当选中一个权限时，应该选中他的所有直系上级
					if (checked) {
						$(this).parents("li").children("input").attr("checked",
								true);
					}
					// 当取消一个权限时，如果同级的权限都是未选择状态，就应该取消选中他的直接上级，并向上做这个操作。
					else {
						if ($(this).parent().siblings("li").children(
								"input:checked").size() == 0) {
							$(this).parent().parent().siblings("input").attr(
									"checked", false);

							var startPoint = $(this).parent().parent();
							if (startPoint.parent().siblings("li").children(
									"input:checked").size() == 0) {
								startPoint.parent().parent().siblings("input")
										.attr("checked", false);
							}
						}
					}
				});
	});
</script>
</head>
<body>

<form action="roleAction_add" method="post">
		<table width="50%" border="1" >
		
			<tr>
				<td>角色名称 :</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>角色说明 :</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>角色所属用户 :</td>
				<td>
					<c:if test="${role.userSet != null && role.userSet.size() != 0}">
						<c:forEach var="user" items="role.userSet">
								${userSet.name}
						</c:forEach>
					</c:if>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="返回" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
<span style="color: red">给角色授权</span>
</hr>	

<input type="checkbox" id="cbSelectAll" onclick="doSelectAll(this.checked)"/>
<label for="cbSelectAll">全选</label>
<!-- rootPrivilegeList -->
<ul id="tree">
	<!-- 开始迭代 -->
	<c:if test="${rootPrivilegeList != null && rootPrivilegeList.size() != 0 }"> <!-- root -->
		<!-- root 开始 -->
		<c:forEach var="root" items="${rootPrivilegeList}">
			<li>
				<c:if test="${privilegeIds != null }">
				<c:forEach var="privilegeId" items="${privilegeIds }">
					<c:if test="${root.id == privilegeId}">
						<input type="checkbox" name="privilegeIds" value="${root.id}" id="cb_${root.id}" checked="checked" >
					</c:if>
					<c:if test="${root.id != privilegeId}">
						<input type="checkbox" name="privilegeIds" value="${root.id}" id="cb_${root.id}" >
					</c:if>
				<label for="cb_${root.id}"><span class="folder">${root.name}</span></label>
				</c:forEach>
				</c:if>
				
				<c:if test="${(fn:length(privilegeIds)) == 0}">
					<input type="checkbox" name="privilegeIds" value="${root.id}" id="cb_${root.id}" >
					<label for="cb_${root.id}"><span class="folder">${root.name}</span></label>
				</c:if>
				<!-- root 结束 -->
				<ul>
					<!-- 第二层 -->
					<c:if test="${root.children != null }">
						<c:forEach var="children" items="${root.children }">
							<li>
							<c:forEach var="privilegeId" items="${privilegeIds }">
								<c:if test="${children.id == privilegeId}">
									<input type="checkbox" name="privilegeIds" value="${children.id}" id="cb_${children.id}" checked="checked" >
								</c:if>
								<c:if test="${children.id != privilegeId}">
									<input type="checkbox" name="privilegeIds" value="${children.id}" id="cb_${children.id}" >
								</c:if>
							<label for="cb_${children.id}"><span class="folder">${children.name}</span></label>
							</c:forEach>
							
							<c:if test="${(fn:length(privilegeIds)) == 0}">
								<input type="checkbox" name="privilegeIds" value="${children.id}" id="cb_${children.id}" >
								<label for="cb_${children.id}"><span class="folder">${children.name}</span></label>
							</c:if>
							<!-- 第三层 -->
							<ul>
								<c:if test="${children.children != null }">
									<c:forEach var="children" items="${children.children }">
										<li>
											<c:forEach var="privilegeId" items="${privilegeIds }">
												<c:if test="${children.id == privilegeId}">
													<input type="checkbox" name="privilegeIds" value="${children.id}" id="cb_${children.id}" checked="checked" >
												</c:if>
												<c:if test="${children.id != privilegeId}">
													<input type="checkbox" name="privilegeIds" value="${children.id}" id="cb_${children.id}" >
												</c:if>
											<label for="cb_${children.id}"><span class="folder">${children.name}</span></label>
											</c:forEach>
											
											<c:if test="${(fn:length(privilegeIds)) == 0}">
												<input type="checkbox" name="privilegeIds" value="${children.id}" id="cb_${children.id}" >
												<label for="cb_${children.id}"><span class="folder">${children.name}</span></label>
											</c:if>
										</li>
									</c:forEach>
								</c:if>
							</ul>
							
						</c:forEach>
					</c:if>
					</li>
				</ul>
			</li>
		</c:forEach>
	</c:if>
	<%-- ${rootPrivilegeList.children != null && rootPrivilegeList.children.size() != 0} --%>
	<!-- 结束迭代 -->
	
</form>	
</body>
</html>
