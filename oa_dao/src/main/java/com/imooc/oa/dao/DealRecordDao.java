package com.imooc.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.imooc.oa.entity.DealRecord;

@Repository("dealRecordDao")
public interface DealRecordDao {

	void insert(DealRecord dealRecord);

	List<DealRecord> selectByClaimVoucher(int cvid);
}
