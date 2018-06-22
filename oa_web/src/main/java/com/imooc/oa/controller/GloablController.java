package com.imooc.oa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imooc.oa.biz.GlobalBiz;
import com.imooc.oa.entity.Employee;

@Controller("globalController")
public class GloablController {

	@Autowired
	private GlobalBiz globalBiz;

	// 前往登陆页面
	@RequestMapping("/to_login")
	public String toLogin() {
		return "login";
	}

	// 登录操作
	@RequestMapping("/login")
	public String login(HttpSession session, @RequestParam String sn, @RequestParam String password) {
		Employee employee = globalBiz.login(sn, password);
		if (employee == null) {
			return "redirect:to_login";
		}
		session.setAttribute("employee", employee);
		return "redirect:self";
	}

	// 跳转到个人信息页面
	@RequestMapping("/self")
	public String self() {
		return "self";
	}

	// 退出登录
	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		session.setAttribute("employee", null);
		return "redirect:to_login";
	}

	// 进入修改密码页面
	@RequestMapping("/to_change_password")
	public String toChangePassword() {
		return "change_password";
	}

	// 进行修改密码操作
	@RequestMapping("/change_password")
	public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1,
			@RequestParam String new2) {
		Employee employee = (Employee) session.getAttribute("employee");
		if (employee.getPassword().equals(old)) {
			if (new1.equals(new2)) {
				employee.setPassword(new1);
				globalBiz.changePassword(employee);
				return "redirect:self";
			}
		}
		return "redirect:to_change_password";
	}
}
