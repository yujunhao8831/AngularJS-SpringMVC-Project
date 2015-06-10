// 创建一个模块
var app = angular.module("app", ['ngRoute', 'ngResource']);

app.config(["$routeProvider"],function($routeProvider) {
	// 路由
	$routeProvider.when("/",{
		templateUrl : 'user/view',
		controller: "HelloController" 
	}).when("/user/editUI",{
		templateUrl : 'user/editUI',
		controller: "HelloController"
	}).otherwise({redirectTo : "/"});
})

app.controller("LoginController",["$scope","$resource","$location",'$window',function($scope,$resource,$location,$window) {
	var actions = {
			'get':    {method:'GET'   },
			'save':   {method:'POST'  },
			'query':  {method:'GET',  isArray : true },
			'remove': {method:'DELETE'},
			'delete': {method:'DELETE'},
			'check':  {method:'POST' }
	}
	$scope.login = function (user){
		var User = $resource("login", {}, actions);
		User.check(user,function(data){
			console.log(data);
			console.log("登陆成功!");
			
		},function(error){
			console.log(error);
			console.log("用户名或密码错误!");
		});
	}
	
}])