<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html ng-app="app">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="../resources/lib/angular/angular.js"></script>
<script type="text/javascript" src="../resources/lib/angular/angular-route.js"></script>
<script type="text/javascript" src="../resources/lib/angular/angular-resource.js"></script>
<script type="text/javascript" src="../resources/lib/angular/angular-messages.js"></script>


<script type="text/javascript" src="../resources/js/login/app.js"></script>

</head>
<body>

	<form ng-controller="LoginController">
		<input type="text" placeholder="请输入用户名" ng-model="user.username" required="required"/><br/>
		<input type="password" placeholder="请输入密  码" ng-model="user.password"/><br/>
		<button ng-click="login(user)">确认</button><br/>
		<button ng-click="">重置</button><br/>
	</form>
</body>
</html>




