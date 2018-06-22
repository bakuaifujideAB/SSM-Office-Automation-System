package com.imooc.oa.biz;

import java.util.List;

import com.imooc.oa.entity.Employee;

public interface EmployeeBiz {

	void add(Employee employee);

	void edit(Employee employee);

	void remove(String sn);

	Employee get(String sn);

	List<Employee> getAll();
}
