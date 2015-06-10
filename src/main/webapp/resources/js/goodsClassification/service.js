"use strict";

app.service("GoodsClassificationService", ["$http","$resource",function($http,$resource) {
	var GoodsClassificationService = this;
	/**
	 * 数据初始化
	 */
	GoodsClassificationService.getByPageInit = function(scope,page){
		/** 一页的实体数据 **/
		scope.modelList   = page.list;
		/** 总记录数 **/
		scope.allRow 	  = page.allRow;
		/** 总页数 **/
		scope.totalPage   = page.totalPage;
		/** 当前页 **/
		scope.currentPage = page.currentPage;
		/** 页面显示多少条数据 **/
		scope.pageSize    = page.pageSize;
		
		/** 前面多少页 **/
		scope.begin 	  = 1 >= page.currentPage - 4  ? 1 : page.currentPage - 4;
		/** 后面多少页 **/
		scope.end 		  = page.totalPage <= page.currentPage + 5  ? page.totalPage : page.currentPage + 5;
		
		scope.starts 	  = new Array(scope.end - scope.begin);
		for (; scope.begin <= scope.end; ++scope.begin) {
			scope.starts[scope.begin] = scope.begin;
		}
	}
	
	/** 显示页面数据 **/
	GoodsClassificationService.list = function (scope){
		$http({
			url		: "goodsClassification/list",
			method	: "GET",
			params	: {
			}
		}).success(function(page) {
			GoodsClassificationService.getByPageInit(scope,page);
		}).error(function(error) {
			// 错误处理
		})
	}
	
	/** 下一个页面的数据 **/
	GoodsClassificationService.nextPage = function (scope,nextPageNumber){
		console.log("----下一个页面的数据-----");
		nextPageNumber = parseInt(nextPageNumber);
		if(nextPageNumber > scope.totalPage){
			alert("没有该页面,请重新输入!");
			return ;
		}
		
		$http({
			url		: "goodsClassification/list",
			method	: "GET",
			params	: {
				nextPageNumber : nextPageNumber,
				pageSize	   : scope.pageSize
			}
		}).success(function(page) {
			
			console.log("nextPage -> page value");
			console.log(page);
			
			GoodsClassificationService.getByPageInit(scope,page);
			
			/*
			 * 删除方法会调用该方法来更新页面状态,
			 * 问题 :  
			 * 		因为,在最后一页进行删除,最后一页的数据全部删除了,但是还会在最后一页.
			 * 		parseInt(scope.currentPage)    : 当前页
			 * 		scope.totalPage 			   : 总页数
			 *      所以,该回调函数中,判断,最新的当前页和总页数,是否是  当前页 > 总页数.如果是那么更新页面,当前页数为总页数
			 */ 
			if( parseInt(scope.currentPage) > scope.totalPage ){
				GoodsClassificationService.nextPage(scope,scope.totalPage);
			}
			
		}).error(function(error) {
			// 错误处理
		})
	}
	
	/** 一页显示多少条数据? **/
	GoodsClassificationService.pageSizeView = function (scope,pageSize){
		$http({
			url		: "goodsClassification/list",
			method	: "GET",
			params	: {
				pageSize : pageSize
			}
		}).success(function(page) {
			GoodsClassificationService.getByPageInit(scope,page);
		}).error(function(error) {
			// 错误处理
		})
	}
	
	/** 删除一条数据 **/
	GoodsClassificationService.remove = function (scope,id){
		$http({
			url		: "goodsClassification/delete/" + id,
			method	: "DELETE",
			params	: {
			}
		}).success(function(data) {
			/* TODO, 这里已经把数据删除了,但是页面中还会显示该数据
			 * 可以在前台解决该问题,如果删除成功了,那么就把该记录所属的DOM元素删除即可,就不用再去查询查询数据库了.
			 * 当然还要注意的问题是,最后一页中删除最后一条数据的话,那么一旦删除成功,当前页要改为上一页,因为当前页的数据已经全部被删除.
			 */
			GoodsClassificationService.nextPage(scope,scope.currentPage);
		}).error(function(error) {
			// 错误处理
			alert("不能这样操作,请先保证该类别下面没有商品!");
		})
	}
	/** 修改数据页面 **/
	GoodsClassificationService.editUI = function (scope,id){
		$http({
			url		: "goodsClassification/editUI/" + id,
			method	: "GET",
			params	: {
			}
		}).success(function(data) {
			// 准备需要修改的商品类别数据
			scope.model 	= data.model;
		}).error(function(error) {
			// 错误处理
		})
	}
	
	/** 修改Model **/
	GoodsClassificationService.edit = function (model){
		var Model = $resource("goodsClassification/edit/" + model.id,null,{
			edit : {
				method : "PUT"
			}
		});
		Model.edit(model,function(){
			console.log("修改成功");
		});
	}
	
	/** 添加Model之前准备数据 **/
	GoodsClassificationService.addUI = function (scope){
		$http({
			url		: "goodsClassification/addUI",
			method	: "GET",
			params	: {
			}
		}).success(function(data) {
			console.log(data);
			// 准备需要修改的商品类别数据
			scope.goodsList 	= data.goodsList;
		}).error(function(error) {
			// 错误处理
		})
	}
	
	/** 添加Model **/
	GoodsClassificationService.add = function (model){
		console.log("---------model.goodsSetIds---------");
		console.log(model.goodsSetIds);
		
		var Model = $resource("goodsClassification/add",null,{
			add : {
				method : "POST",
				params : {
					ids : model.goodsSetIds,
				}
			}
		});
		Model.add(model,function(){
			console.log("添加成功!");
		});
	}
	
	
	return this;
}])








