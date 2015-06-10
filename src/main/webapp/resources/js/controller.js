
"use strict";
/** 控制器 :  AlertsCtrl 开始 **/
app.controller("AlertsCtrl", [ "$scope", AlertsCtrl ]);
function AlertsCtrl(e) {
			e.alerts = [
					{
						type : "success",
						msg : "Thanks for visiting! Feel free to create pull requests to improve the dashboard!"
					},
					{
						type : "danger",
						msg : "Found a bug? Create an issue with as many details as you can."
					} ], e.addAlert = function() {
				e.alerts.push({
					msg : "Another alert!"
				})
			}, e.closeAlert = function(t) {
				e.alerts.splice(t, 1)
			}
}
/** 控制器 :  AlertsCtrl 结束 **/

/** 控制器 :  MasterCtrl 开始 **/
app.controller("MasterCtrl", [ "$scope", "$cookieStore", MasterCtrl ]);

function MasterCtrl(t, e) {
	var o = 992;
	t.getWidth = function() {
		return window.innerWidth
	}, t.$watch(t.getWidth, function(g, n) {
		t.toggle = g >= o ? angular.isDefined(e.get("toggle")) ? e
				.get("toggle") ? !0 : !1 : !0 : !1
	}), t.toggleSidebar = function() {
		t.toggle = !t.toggle, e.put("toggle", t.toggle)
	}, window.onresize = function() {
		t.$apply()
	}
}
/** 控制器 :  MasterCtrl 结束 **/