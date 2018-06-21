package com.imooc.oa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imooc.oa.biz.DepartmentBiz;
import com.imooc.oa.entity.Department;

@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentBiz departmentBiz;

	// 展示部门列表
	@RequestMapping("/list")
	public String list(Map<String, Object> map) {
		map.put("list", departmentBiz.getAll());
		return "department_list";
	}

	// 进入添加部门页面
	@RequestMapping("/to_add")
	public String toAdd(Map<String, Object> map) {
		// 如果要在新的页面使用springmvc标签必须要传值，否则不用
		map.put("department", new Department());
		return "department_add";
	}

	// 进行添加部门操作
	@RequestMapping("/add")
	public String add(Department department) {
		departmentBiz.add(department);
		return "redirect:list";
	}

	// 进入修改部门页面 必须传递sn
	@RequestMapping(value = "/to_update", params = "sn")
	public String toUpdate(String sn, Map<String, Object> map) {
		map.put("department", departmentBiz.get(sn));
		return "department_update";
	}

	// 进行修改部门操作
	@RequestMapping("/update")
	public String update(Department department) {
		departmentBiz.edit(department);
		return "redirect:list";
	}

	// 进行删除部门操作
	@RequestMapping(value = "/remove", params = "sn")
	public String remove(String sn) {
		departmentBiz.remove(sn);
		return "redirect:list";
	}
}
