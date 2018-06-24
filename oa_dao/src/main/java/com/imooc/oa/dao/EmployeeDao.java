package com.imooc.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.imooc.oa.entity.Employee;

@Repository("employeeDao")
public interface EmployeeDao {

	void insert(Employee employee);

	void update(Employee employee);

	void delete(String sn);

	Employee select(String sn);

	List<Employee> selectAll();

	List<Employee> selectByDepartmentAndPost(@Param("dsn") String dsn, @Param("post") String post);
}
