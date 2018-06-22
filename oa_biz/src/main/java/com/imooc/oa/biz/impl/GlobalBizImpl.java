package com.imooc.oa.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.oa.biz.GlobalBiz;
import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.Employee;

@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {

	@Autowired
	private EmployeeDao employeeDao;

	public Employee login(String sn, String password) {
		Employee employee = employeeDao.select(sn);
		if (employee != null && employee.getPassword().equals(password)) {
			return employee;
		} else {
			return null;
		}
	}

	public void changePassword(Employee employee) {
		employeeDao.update(employee);
	}
}
