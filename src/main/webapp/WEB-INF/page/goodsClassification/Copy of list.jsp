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

<title>伊凡仕影楼系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/style.css">
	
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.js"></script>
<script src="${pageContext.request.contextPath}/Ext/ext-all.js"></script>
<script src="${pageContext.request.contextPath}/Ext/ext-locale/build/ext-locale-zh_CN.js"></script>
<link href="${pageContext.request.contextPath}/Ext/ext-theme-crisp/build/resources/ext-theme-crisp-all.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/goodsClassificationAction/list.js"></script>
<script type="text/javascript">
	/* $(function(){
		// 删除
		$(".delete").click(function(){
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();			
			return false;
		});
		// 页面跳转
		$('#GO').click(function(){
			var jumpPageNumber = parseInt($("#jumpPageNumber").val());
			var maxNumber = parseInt($("#maxNumber").val());
			
			var checkPageNumber = /[1-9]/;
	  	  	var checkValue = checkPageNumber.test(jumpPageNumber);
	        if(!checkValue) { // 如果不符合要求
	            window.alert("请输入一个数值!");
	            document.getElementById("jumpPageNumber").value = '';
	            return false;
	        }if(jumpPageNumber > maxNumber){
	            window.alert("没有该页码,请重新输入!");
	            document.getElementById("jumpPageNumber").value = '';
	            return false;
	        }
	        if(checkValue){
	        	var pageSize = $("#pageSize").val();
	        	window.location='goodsClassificationAction/list.action?jumpPageNumber='+jumpPageNumber+'&pageSize='+ pageSize;
	        }
        });
        // 每页显示
        $('#pageSize').change(function(){
        	var pageSize = $("#pageSize").val();
        	window.location='goodsClassificationAction/list.action?pageSize='+pageSize;
        });
        
        
	}) */
</script>

<body>


	<%-- <form action="${pageContext.request.contextPath}/goodsClassificationAction/export.action" method="post" enctype="multipart/form-data" >
		<input type="file" name="file" />
		<input type="submit" value="导出Excel" id="export"/>
		
		<input type="hidden" name="_method" value="DELETE"/>
		<table width="80%" border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td>类别编号</td>
				<td>类别名称</td>
				<td>类别商品</td>
				<td>操作
					<a href="${pageContext.request.contextPath}/goodsClassificationAction/addUI.action" target="right" >添加</a>
				</td>
			</tr>
			<c:forEach var="model" items="${page.list}">
				<tr>
					
						<input type="hidden" value="${model.id }" name="ids"/>
					 	<td>${model.id }</td>
						<td>${model.name}</td>
					 	<td>
					 		<c:if test="${model.goodsSet != null && model.goodsSet.size() != 0 }">
								<c:forEach var="goods" items="${model.goodsSet}">
									${goods.name }
								</c:forEach>
					 		</c:if>
					 	</td>
					 	<td>
					 		<a href="${pageContext.request.contextPath}/goodsClassificationAction/editUI.action/${model.id }" >修改</a>
							<a href="${pageContext.request.contextPath}/goodsClassificationAction/delete.action/${model.id }" class="delete">删除</a>
						</td>
				</tr> 
			</c:forEach>
		</table>
	</form>
	<div  style="text-align: center;">
		            共${page.allRow}条记录,&nbsp;&nbsp;当前第<span id="currentPage">${page.currentPage}</span>页,&nbsp;&nbsp;共${page.totalPage}页<br/><br/>	
		<c:choose>  
		 	<c:when test="${page.currentPage == 1}">	
				首页  上一页
        	</c:when>
        	<c:otherwise>
        	   <a href="${pageContext.request.contextPath }/goodsClassificationAction/list.action?jumpPageNumber=1?pageSize=${pageSize}" class="jumpPageNumber">首页</a>
          	   <a href="${pageContext.request.contextPath }/goodsClassificationAction/list.action?jumpPageNumber=${page.currentPage-1}&pageSize=${pageSize}" class="jumpPageNumber">上一页</a>
        	</c:otherwise>      	   
        </c:choose>
        
       	<c:set var="begin" value="${1 >= page.currentPage - 5  ? 1 : page.currentPage - 5}"></c:set>
        <c:set var="end" value="${page.totalPage <= page.currentPage + 4  ? page.totalPage : page.currentPage + 4}"></c:set>
        <c:set var="currentPage" value="${ page.currentPage}"></c:set>
        
        <c:forEach begin="${begin}" end="${end}" var="pageNumber" step="1">
       		<c:choose>  
			 	<c:when test="${page.currentPage == pageNumber}">	
			 		${pageNumber }
	        	</c:when>
	        	<c:otherwise>
		       		<a href="${pageContext.request.contextPath }/goodsClassificationAction/list.action?jumpPageNumber=${pageNumber }&pageSize=${pageSize}" class="jumpPageNumber">${pageNumber }</a>
	        	</c:otherwise>      	   
        </c:choose>
        </c:forEach>
        
		<c:choose> 
		    <c:when test="${(page.currentPage != page.totalPage)&&page.totalPage!=0}">
                 <a href="${pageContext.request.contextPath }/goodsClassificationAction/list.action?jumpPageNumber=${page.currentPage+1}&pageSize=${pageSize}" class="jumpPageNumber">下一页</a>
                 <a href="${pageContext.request.contextPath }/goodsClassificationAction/list.action?jumpPageNumber=${page.totalPage}&pageSize=${pageSize}"class="jumpPageNumber">末页</a>
            </c:when>
        	<c:otherwise>
				下一页   末页
        	</c:otherwise>   
       	</c:choose>
       	
       	<select name="pageSize" id="pageSize" >
       	  <option selected="selected" value="10">每页显示多少</option>
		  <option value="10" >每页显示10条记录</option>
		  <option value="20" >每页显示20条记录</option>
		  <option value="30" >每页显示30条记录</option>
		  <option value="50" >每页显示50条记录</option>
		</select>
       	</br>
        <div>
       		跳转至
       		<input type="text" size="2" id="jumpPageNumber"/>页
       		<input type="submit" value="GO"  id="GO" />
       		<input type="hidden" id="maxNumber" value="${page.totalPage}"/>
          </div>
		</div> --%>
</body>
</html>
