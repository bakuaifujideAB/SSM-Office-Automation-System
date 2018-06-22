package com.imooc.oa.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.oa.biz.EmployeeBiz;
import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.Employee;

@Service("employeeBiz")
public class EmployeeBizImpl implements EmployeeBiz {

	@Autowired
	private EmployeeDao employeeDao;

	public void add(Employee employee) {
		// 添加员工时设置默认密码
		employee.setPassword("000000");
		employeeDao.insert(employee);
	}

	public void edit(Employee employee) {
		employeeDao.update(employee);
	}

	public void remove(String sn) {
		employeeDao.delete(sn);
	}

	public Employee get(String sn) {
		return employeeDao.select(sn);
	}

	public List<Employee> getAll() {
		return employeeDao.selectAll();
	}

}
