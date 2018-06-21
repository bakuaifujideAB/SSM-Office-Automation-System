package com.imooc.oa.biz;

import java.util.List;

import com.imooc.oa.entity.Department;

public interface DepartmentBiz {

	void add(Department department);

	void edit(Department department);

	void remove(String sn);

	Department get(String sn);

	List<Department> getAll();
}
