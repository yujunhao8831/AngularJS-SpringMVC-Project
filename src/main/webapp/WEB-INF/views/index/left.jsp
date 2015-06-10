<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

	<ul >
		<li style="color: red;">系统管理</li>
		<li><a href="${pageContext.request.contextPath}/fileUpAction/list.action" target="right" >文件上传</a></li>
		<li><hr/></li>
		<li><a href="${pageContext.request.contextPath}/goodsClassificationAction/list.action" target="right" >商品类别</a></li>
		<li><a href="${pageContext.request.contextPath}/goodsAction/list.action" target="right" >商品管理</a></li>
		<li><a href="${pageContext.request.contextPath}/goodsSetMealAction/list.action" target="right" >套餐管理</a></li>
		<li><a href="${pageContext.request.contextPath}/goodsOrderAction/list.action" target="right" >订单管理</a></li>
		<li><a href="${pageContext.request.contextPath}/clientAction/list.action" target="right" >客户管理</a></li>
		
		<li><hr/></li>
		<li><a href="${pageContext.request.contextPath}/employeeAction/list.action" target="right" >员工管理</a></li>
		<li><a href="${pageContext.request.contextPath}/departmentAction/list.action" target="right" >部门管理</a></li>
		<li><a href="${pageContext.request.contextPath}/childrenAction/list.action" target="right" >孩子管理</a></li>
		<li><a href="${pageContext.request.contextPath}/supplierAction/list.action" target="right" >供应商管理</a></li>
		<li><a href="${pageContext.request.contextPath}/userAction/list.action" target="right" >用户管理</a></li>
		<li><a href="${pageContext.request.contextPath}/privilegeAction/list.action" target="right" >权限管理</a></li>
		<li><a href="${pageContext.request.contextPath}/roleAction/list.action" target="right" >角色管理</a></li>
	</ul>
