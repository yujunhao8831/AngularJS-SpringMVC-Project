<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html ng-app="app">
<head>

<title>伊凡仕影楼系统</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/angular/angular.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/angular/angular-route.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/angular/angular-resource.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/angular/angular-messages.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-2.1.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/goodsClassification/app.js"></script>

<body>
<form novalidate name="myForm">
<div ng-controller="pageController">
	<table width="80%" border="1" cellspacing="0" cellpadding="0">
		<input type="file" name="file" />
		<input type="submit" value="导出Excel" id="export"/>
		
		<input type="hidden" name="_method" value="DELETE"/>
		
		<tr>
			<td>类别编号</td>
			<td>类别名称</td>
			<td>类别商品</td>
			<td>操作
				<%-- ${pageContext.request.contextPath}/goodsClassificationAction/addUI.action --%>
				<button ng-click="addUI()">添加</button>
			</td>
		</tr>
		<hr/>
		
		<tr ng-repeat="model in modelList" >
			<input type="hidden" value="{{model.id }}" name="ids"/>
		 	<td>{{model.id }}</td>
			<td>{{model.name}}</td>
		 	<td>
		 		<!-- TODO! -->
		 		<c:if test="${model.goodsSet != null && model.goodsSet.size() != 0 }">
					<c:forEach var="goods" items="${model.goodsSet}">
						${goods.name }
					</c:forEach>
		 		</c:if>
		 	</td>
		 	<td>
		 	<%-- ${pageContext.request.contextPath}/goodsClassificationAction/editUI.action/${model.id } --%>
		 		<button ng-click="updateUI(model.id)">修改</button>
		 		<button ng-click="remove(model.id)">删除</button>
				</td>
		</tr> 
	</table>
	
	<div style="text-align: center;" >
		            共{{allRow}}条记录,&nbsp;&nbsp;当前第<span id="currentPage">{{currentPage}}</span>页,&nbsp;&nbsp;共{{totalPage}}页<br/><br/>	


		<span ng-if="currentPage === 1">
			首页  上一页 
		</span>
		<span ng-if="currentPage != 1">
			<a href="#" ng-click="nextPage(1)">首页</a>
			<a href="#" ng-click="nextPage(currentPage-1)">上一页</a>
		</span>
		
		<span ng-repeat="start in starts track by $index">
			<span ng-if="currentPage == start">
				{{start}}
			</span>
			<span ng-if="currentPage != start">
				<a href="#" ng-click="nextPage(start)">{{start}}</a>
			</span>
		</span>
		
        <span ng-if="currentPage != totalPage && totalPage != 0">
        	<a href="#" ng-click="nextPage(currentPage+1)">下一页</a>
        	<a href="#" ng-click="nextPage(totalPage)">末页</a>
        </span>
        
        <span ng-if="currentPage == totalPage || totalPage == 0">
        	下一页
        	末页
        </span>
        
        <br/>
        <label>每页显示多少</label>
        
        <button ng-click="pageSizeView(10)">10</button>
        <button ng-click="pageSizeView(30)">30</button>
        <button ng-click="pageSizeView(50)">50</button>
	        
       	<br/>
        <div>
       		跳转至
       		<input type="text" ng-model="nextPageNumber" size="3" maxlength="3" name="nextPageNumber" ng-pattern="/^[0-9]*[1-9][0-9]*$/" required/>页
       		<button ng-click="nextPage(nextPageNumber)" ng-disabled="!myForm.nextPageNumber.$valid">GO</button>
       		<div ng-messages="myForm.nextPageNumber.$error" style="color:red">
       			<div ng-if="nextPageNumber > totalPage">
       				没有该页面!最大页面为[{{totalPage}}]
       			</div>
       			<div ng-message="pattern">请输入正确的数字!</div>
			</div>
          </div>
</div>
</body>
</html>


