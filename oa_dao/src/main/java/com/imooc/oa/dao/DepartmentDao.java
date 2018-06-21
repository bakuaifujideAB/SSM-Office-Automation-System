package com.imooc.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imooc.oa.entity.Department;

@Repository("departmentDao")
public interface DepartmentDao {

	void insert(Department department);

	void update(Department department);

	void delete(String sn);

	Department select(String sn);

	List<Department> selectAll();

}
