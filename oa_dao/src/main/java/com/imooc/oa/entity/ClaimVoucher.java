package com.imooc.oa.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//报销单实体类
public class ClaimVoucher {

	// 报销单编号
	private Integer id;
	// 报销事由
	private String cause;
	// 创建者编号
	private String createSn;
	// 创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date createTime;
	// 待处理人编号
	private String nextDealSn;
	// 总金额
	private Double totalAmount;
	// 状态
	private String status;
	// 创建者
	private Employee creater;
	// 待处理人
	private Employee dealer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getCreateSn() {
		return createSn;
	}

	public void setCreateSn(String createSn) {
		this.createSn = createSn;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNextDealSn() {
		return nextDealSn;
	}

	public void setNextDealSn(String nextDealSn) {
		this.nextDealSn = nextDealSn;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getCreater() {
		return creater;
	}

	public void setCreater(Employee creater) {
		this.creater = creater;
	}

	public Employee getDealer() {
		return dealer;
	}

	public void setDealer(Employee dealer) {
		this.dealer = dealer;
	}
}