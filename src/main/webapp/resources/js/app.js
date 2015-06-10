"use strict";
/** 
 * 创建一个模块
 * ui.router(算是ngRoute的升级版) : 是AngularUI可提供的路由框架,它允许你通过状态机制管理路由.
 * 		在页面中使用路由时 : ui-view.   (已经不是ng-view了).
 * 
 */
var app = angular.module("app", [ "ui.bootstrap", "ui.router","ngResource", "ngCookies" ,"ngMessages","ngResource","checklist-model"]);

// 
app.config([ "$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise("/index");
	$stateProvider
		.state("index", { // 当浏览器地址栏中是 "/" 时,应用会转换到index状态,然后使用templateUrl对应的模板内容去填充ui-view
		url 		: "/index",
		views 		: {
			"" 			: { 
				templateUrl : "resources/templates/index/index.html",
			},
			"left@index": {
				templateUrl : "resources/templates/index/left.html",
			},
			"top@index" : {
				templateUrl : "resources/templates/index/top.html",
			},
			"main@index": {
				templateUrl : "resources/templates/dashboard.html",
			}
		},
	}).state("index.test",{
		 url: '/test',
		 views: {
             'main@index': {
            	 templateUrl: "resources/templates/tables.html"
             }
         }
        
	}).state("index.tables", {
		url 		: "/tables",
		views: {
            'main@index': {
            	templateUrl : "resources/templates/tables.html"
            }
        }
		
	}).state("index.goodsClassification", { // 地址栏中 : index/goodsClassification
		//这个函数为数据保证, 因此它将在控制器被实例化之前载入。
		url         : "/goodsClassification/list",
		views		: {
			"main@index" : { 
				templateUrl : "resources/templates/goodsClassification/list.html",
				controller  : "GoodsClassificationController"
			}
		}
	}).state("index.goodsClassification.editUI", { 
		url         : "/editUI/:id",
		views		: {
			"main@index" : { 
				templateUrl : "resources/templates/goodsClassification/editUI.html",
				controller  : "GoodsClassificationEditController",
			}
		},
	})
	
	
	
} ]);









