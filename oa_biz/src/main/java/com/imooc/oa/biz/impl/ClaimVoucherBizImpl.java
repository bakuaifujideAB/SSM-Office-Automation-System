package com.imooc.oa.biz.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.oa.biz.ClaimVoucherBiz;
import com.imooc.oa.dao.ClaimVoucherDao;
import com.imooc.oa.dao.ClaimVoucherItemDao;
import com.imooc.oa.dao.DealRecordDao;
import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.ClaimVoucherItem;
import com.imooc.oa.entity.DealRecord;
import com.imooc.oa.global.Contant;

@Service("cliamVoucherBiz")
public class ClaimVoucherBizImpl implements ClaimVoucherBiz {

	@Autowired
	private ClaimVoucherDao claimVoucherDao;
	@Autowired
	private ClaimVoucherItemDao claimVoucherItemDao;
	@Autowired
	private DealRecordDao dealRecordDao;

	public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
		claimVoucher.setCreateTime(new Date());
		claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
		claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
		claimVoucherDao.insert(claimVoucher);

		for (ClaimVoucherItem item : items) {
			item.setClaimVoucherId(claimVoucher.getId());
			claimVoucherItemDao.insert(item);
		}
	}

	public ClaimVoucher get(int id) {
		return claimVoucherDao.select(id);
	}

	public List<ClaimVoucherItem> getItems(int cvid) {
		return claimVoucherItemDao.selectByClaimVoucher(cvid);
	}

	public List<DealRecord> getRecords(int cvid) {
		return dealRecordDao.selectByClaimVoucher(cvid);
	}

	public List<ClaimVoucher> getForSelf(String sn) {
		return claimVoucherDao.selectByCreateSn(sn);
	}

	public List<ClaimVoucher> getForDeal(String sn) {
		return claimVoucherDao.selectByNextDealSn(sn);
	}

	public void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
		claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
		claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
		claimVoucherDao.update(claimVoucher);

		List<ClaimVoucherItem> olds = claimVoucherItemDao.selectByClaimVoucher(claimVoucher.getId());
		for (ClaimVoucherItem old : olds) {
			boolean isHave = false;
			for (ClaimVoucherItem item : items) {
				if (item.getId() == old.getId()) {
					isHave = true;
					break;
				}
			}
			// 如果在新的items中不存在旧条目，则删除旧条目
			if (!isHave) {
				claimVoucherItemDao.delete(old.getId());
			}
		}
		for (ClaimVoucherItem item : items) {
			item.setClaimVoucherId(claimVoucher.getId());
			if (item.getId() != null && item.getId() > 0) {
				claimVoucherItemDao.update(item);
			} else {
				claimVoucherItemDao.insert(item);
			}
		}

	}

	public void submit(int id) {
		// TODO Auto-generated method stub

	}

	public void deal(DealRecord dealRecord) {
		// TODO Auto-generated method stub

	}

}
