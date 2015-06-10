//package com.crm.interceptor;
//
//import com.crm.action.LoginAction;
//import com.crm.domain.User;
//import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.ActionInvocation;
//import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
//
///**
// * 拦截器 功能 : 用户拦截用户没有登陆就进入系统
// */
//public class CheckUserIsLoginInterceptor extends AbstractInterceptor {
//
//	public String intercept(ActionInvocation invocation) throws Exception {
//		System.out.println("CheckUserIsLoginInterceptor.intercept()");
//		// 从Session中获取用户
//		User user = (User) ActionContext.getContext().getSession().get("user");
//		
//		// 情况1 : 如果用户没有登陆
//		if (user == null) {
//			// 如果正在登陆,那么放行
//			if (invocation.getProxy().getAction() instanceof LoginAction) {
//				return invocation.invoke();
//			} else {
//				// 否则就让他登陆
//				return "loginUI";
//			}
//		}
//		return invocation.invoke(); // 该干嘛干嘛
//	}
//
//}
