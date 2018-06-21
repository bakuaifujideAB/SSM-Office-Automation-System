package com.imooc.oa.entity;

//部门实体类
public class Department {

	// 部门编号
	private String sn;
	// 部门名称
	private String name;
	// 地址
	private String address;

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}