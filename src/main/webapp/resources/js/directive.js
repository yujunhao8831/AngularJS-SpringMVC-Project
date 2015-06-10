"use strict";

/** 指令 : rd-loading 开始 **/
app.directive("rdLoading", rdLoading);

function rdLoading() {
	var d = {
		restrict : "AE",
		template : '<div class="loading"><div class="double-bounce1"></div><div class="double-bounce2"></div></div>'
	};
	return d
}
/** 指令 : rd-loading 结束 **/

/** 指令 : rd-widget-body 开始 **/
app.directive("rdWidgetBody", rdWidgetBody);

function rdWidgetBody() {
	var d = {
		requires : "^rdWidget",
		scope : {
			loading : "@?",
			classes : "@?"
		},
		transclude : !0,
		template : '<div class="widget-body" ng-class="classes"><rd-loading ng-show="loading"></rd-loading><div ng-hide="loading" class="widget-content" ng-transclude></div></div>',
		restrict : "E"
	};
	return d
}

/** 指令 : rd-widget-body 结束 **/

/** 指令 : rd-widget-footer 开始 **/
app.directive("rdWidgetFooter", rdWidgetFooter);

function rdWidgetFooter() {
	var e = {
		requires : "^rdWidget",
		transclude : !0,
		template : '<div class="widget-footer" ng-transclude></div>',
		restrict : "E"
	};
	return e
}

/** 指令 : rd-widget-footer 结束 **/


/** 指令 : rd-widget-header 开始 */
app.directive("rdWidgetHeader", rdWidgetTitle);
function rdWidgetTitle() {
	var i = {
		requires : "^rdWidget",
		scope : {
			title : "@",
			icon  : "@"
		},
		transclude : !0,
		template : '<div class="widget-header"><div class="row"><div class="pull-left"><i class="fa" ng-class="icon"></i> {{title}} </div><div class="pull-right col-xs-6 col-sm-4" ng-transclude></div></div></div>',
		restrict : "E"
	};
	return i
}

/** 指令 : rd-widget-header 结束 */


/** 指令 : rd-widget 开始 */
app.directive("rdWidget", rdWidget);
function rdWidget() {
	var d = {
		// 嵌入模板 : 默认 false 
		// 也就是说,我希望我这个指令,可以包含任意内容的指令时,才会用到 transclude : true
		transclude : !0,
		template : '<div class="widget" ng-transclude></div>',
		restrict : "EA"
	};
	return d
}
/** 指令 : rd-widget 结束 */
