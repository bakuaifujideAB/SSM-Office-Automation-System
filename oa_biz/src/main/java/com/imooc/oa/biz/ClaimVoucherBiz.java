package com.imooc.oa.biz;

import java.util.List;

import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.ClaimVoucherItem;
import com.imooc.oa.entity.DealRecord;

public interface ClaimVoucherBiz {

	void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

	ClaimVoucher get(int id);

	List<ClaimVoucherItem> getItems(int cvid);

	List<DealRecord> getRecords(int cvid);

}
