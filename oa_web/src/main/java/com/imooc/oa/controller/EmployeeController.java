package com.imooc.oa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imooc.oa.biz.DepartmentBiz;
import com.imooc.oa.biz.EmployeeBiz;
import com.imooc.oa.entity.Employee;
import com.imooc.oa.global.Contant;

@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeBiz employeeBiz;

	@Autowired
	private DepartmentBiz departmentBiz;

	// 展示用户列表
	@RequestMapping("/list")
	public String list(Map<String, Object> map) {
		map.put("list", employeeBiz.getAll());
		return "employee_list";
	}

	// 进入添加用户页面
	@RequestMapping("/to_add")
	public String toAdd(Map<String, Object> map) {
		map.put("employee", new Employee());
		map.put("dlist", departmentBiz.getAll());
		map.put("plist", Contant.getPosts());
		return "employee_add";
	}

	// 进行添加用户操作
	@RequestMapping("/add")
	public String add(Employee employee) {
		employeeBiz.add(employee);
		return "redirect:list";
	}

	// 进入修改用户页面 必须传递sn
	@RequestMapping(value = "/to_update", params = "sn")
	public String toUpdate(String sn, Map<String, Object> map) {
		map.put("employee", employeeBiz.get(sn));
		map.put("dlist", departmentBiz.getAll());
		map.put("plist", Contant.getPosts());
		return "employee_update";
	}

	// 进行修改用户操作
	@RequestMapping("/update")
	public String update(Employee employee) {
		employeeBiz.edit(employee);
		return "redirect:list";
	}

	// 进行删除用户操作
	@RequestMapping(value = "/remove", params = "sn")
	public String remove(String sn) {
		employeeBiz.remove(sn);
		return "redirect:list";
	}

}
