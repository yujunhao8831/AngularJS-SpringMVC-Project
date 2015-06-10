package com.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.core.base.BaseController;
import com.crm.domain.User;

@Controller
public class LoginController extends BaseController<Object> {

	/** 登陆页面 */
	@RequestMapping(value = "/login/loginUI*")
	public String loginUI() {
		return "login/loginUI";
	}

	/** 登陆校验 **/
	@ResponseBody
	@RequestMapping(value = "/login/login*")
	public String login(@RequestBody User loginUser, HttpServletRequest request) {

		User user = userService.checkUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword());
		if (null != user) {
			request.getSession().setAttribute("user", user);
			System.out.println("check Ok");
			return "{\"success\":\"登陆成功,来自后台!\"}";
		}
		return "{\"error\":\"用户名或密码错误,来自后台!\"}";
	}
}
