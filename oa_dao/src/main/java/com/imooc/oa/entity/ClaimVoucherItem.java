package com.imooc.oa.entity;

//报销单条目实体类
public class ClaimVoucherItem {

	// 主键编号
	private Integer id;
	// 报销单编号
	private Integer claimVoucherId;
	// 费用类别
	private String item;
	// 金额
	private Double amount;
	// 说明
	private String comment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClaimVoucherId() {
		return claimVoucherId;
	}

	public void setClaimVoucherId(Integer claimVoucherId) {
		this.claimVoucherId = claimVoucherId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}