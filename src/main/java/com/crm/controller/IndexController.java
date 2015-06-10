package com.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	/** 主页面 */
	@RequestMapping(value="/")
	public String index(){
		System.out.println("main");
		return "index";
	}
	
	
//	/** index页面 */
//	@RequestMapping(value="/index/index")
//	public String index(){
//		System.out.println("index/index");
//		return "index/index";
//	}
//	
//	/** 顶部页面 */
//	@RequestMapping(value="/index/top")
//	public String top(){
//		System.out.println("index/top");
//		return "index/top";
//	}
//	/** 左部页面 */
//	@RequestMapping(value="/index/left")
//	public String left(){
//		System.out.println("index/left");
//		return "index/left";
//	}
//	/** 右部页面 */
//	@RequestMapping(value="/index/right")
//	public String right(){
//		System.out.println("index/right");
//		return "index/right";
//	}
//	/** 底部页面 */
//	@RequestMapping(value="/index/bottom")
//	public String bottom(){
//		System.out.println("index/bottom");
//		return "index/bottom";
//	}
    


}
