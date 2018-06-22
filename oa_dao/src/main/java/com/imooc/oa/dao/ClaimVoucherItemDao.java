package com.imooc.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imooc.oa.entity.ClaimVoucherItem;

@Repository("claimVoucherItemDao")
public interface ClaimVoucherItemDao {

	void insert(ClaimVoucherItem claimVoucherItem);

	void update(ClaimVoucherItem claimVoucherItem);

	void delete(int id);

	List<ClaimVoucherItem> selectByClaimVoucher(int cvid);
}
