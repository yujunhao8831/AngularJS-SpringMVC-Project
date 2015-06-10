"use strict";
// 商品类别控制器  查询 - 删除
app.controller("GoodsClassificationController",["GoodsClassificationService","$scope","$state",function(GoodsClassificationService,$scope,$state){
	/** 刚进入页面显示的数据. **/
	$scope.list = function (){
		console.log("$scope.list 执行");
		GoodsClassificationService.list($scope);
	}
	/** 下一个页面的数据 **/
	$scope.nextPage = function (nextPageNumber){
		console.log("$scope.nextPage 执行");
		GoodsClassificationService.nextPage($scope,nextPageNumber);
	}
	/** 一页显示多少条数据? **/
	$scope.pageSizeView = function (pageSize){
		console.log("$scope.pageSizeView 执行");
		GoodsClassificationService.pageSizeView($scope,pageSize);
	}
	/** 删除一条数据 **/
	$scope.remove = function (id){
		console.log("$scope.remove 执行");
		GoodsClassificationService.remove($scope,id);
		// $state.reload('index.goodsClassification'); // 这个页面会震动一下, 效果不佳
	}
	
//	/** 修改数据页面 **/
//	$scope.editUI = function (id){
//		console.log("$scope.editUI 执行");
//		$state.go("index.goodsClassification.editUI");
//	}
	
	$scope.list();
	
}]);
// 修改 - 添加
app.controller("GoodsClassificationEditController",["GoodsClassificationService","$scope","$state","$stateParams",function(GoodsClassificationService,$scope,$state,$stateParams){
	
	$scope.model = {};
	
	/** 修改Model页面 **/
	$scope.editUI = function (scope,id){
		GoodsClassificationService.editUI(scope,id);
	}
	
	/** 修改Model **/
	$scope.edit = function (model){
		GoodsClassificationService.edit(model);
		$state.go('index.goodsClassification');
	}
	/** 添加Model **/
	$scope.add = function (model){
		console.log(model);
		GoodsClassificationService.add(model);
		$state.go('index.goodsClassification');
	}
	
	/** 添加Model之前准备数据 **/
	$scope.addUI = function (scope){
		GoodsClassificationService.addUI(scope);
	}
	/** 添加Model之前准备数据 **/
	$scope.reset = function (){
		$scope.model.name = "";
	}
	if(null != $stateParams.id && $stateParams.id != ''){
		console.log("$stateParams.id");
		console.log($stateParams.id);
		$scope.editUI($scope,$stateParams.id);
	} else {
		$scope.addUI($scope);
	}
	
	
	
}]);

