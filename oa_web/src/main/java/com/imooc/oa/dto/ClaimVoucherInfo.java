package com.imooc.oa.dto;

import java.util.List;

import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.ClaimVoucherItem;

public class ClaimVoucherInfo {

	private ClaimVoucher claimVoucher;
	private List<ClaimVoucherItem> items;

	public ClaimVoucher getClaimVoucher() {
		return claimVoucher;
	}

	public void setClaimVoucher(ClaimVoucher claimVoucher) {
		this.claimVoucher = claimVoucher;
	}

	public List<ClaimVoucherItem> getItems() {
		return items;
	}

	public void setItems(List<ClaimVoucherItem> items) {
		this.items = items;
	}
}
