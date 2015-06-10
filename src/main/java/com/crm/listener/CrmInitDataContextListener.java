package com.crm.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 监听器
 */
public class CrmInitDataContextListener implements ServletContextListener {
	private ApplicationContext context;
	// 销毁
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	// 初始化
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 完成项目启动数据的初始化功能
		// 1. 如果数据库不大,更新不频繁可以存储到app缓存中,缺点 : 需要自己解决同步问题
		// 2. 数据量大,可以考虑使用Hibernate二级缓存,Hibernate自己提供了同步功能
		// TODO
		// TODO 准备菜单列表数据 ,应该放到程序初始化的地方,在程序中应该只执行一次 
		// TODO 准备所有权限的URL列表,只执行一次
		// Spring的配置文件,项目启动的时候配置文件读取后也存储到了application内置对象中
		context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		
		
	}

}







