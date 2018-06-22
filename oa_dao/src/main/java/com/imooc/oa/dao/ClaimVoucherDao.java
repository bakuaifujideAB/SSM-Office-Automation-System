package com.imooc.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imooc.oa.entity.ClaimVoucher;

@Repository("claimVoucherDao")
public interface ClaimVoucherDao {

	void insert(ClaimVoucher claimVoucher);

	void update(ClaimVoucher claimVoucher);

	void delete(int id);

	ClaimVoucher select(int id);

	List<ClaimVoucher> selectByCreateSn(String csn);

	List<ClaimVoucher> selectByNextDealSn(String ndsn);
}
