package com.imooc.oa.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imooc.oa.biz.ClaimVoucherBiz;
import com.imooc.oa.dto.ClaimVoucherInfo;
import com.imooc.oa.entity.Employee;
import com.imooc.oa.global.Contant;

@Controller("claimVoucherController")
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {

	@Autowired
	private ClaimVoucherBiz claimVoucherBiz;

	// 进入添加报销单页面
	@RequestMapping("/to_add")
	public String toAdd(Map<String, Object> map) {
		map.put("items", Contant.getItems());
		map.put("info", new ClaimVoucherInfo());
		return "claim_voucher_add";
	}

	// 进行添加报销单操作
	@RequestMapping("/add")
	public String add(HttpSession session, ClaimVoucherInfo info) {
		Employee employee = (Employee) session.getAttribute("employee");
		info.getClaimVoucher().setCreateSn(employee.getSn());
		claimVoucherBiz.save(info.getClaimVoucher(), info.getItems());
		return "redirect:detail?id=" + info.getClaimVoucher().getId();
	}

	// 进入报销单详情页面
	@RequestMapping("/detail")
	public String detail(int id, Map<String, Object> map) {
		map.put("claimVoucher", claimVoucherBiz.get(id));
		map.put("items", claimVoucherBiz.getItems(id));
		map.put("records", claimVoucherBiz.getRecords(id));
		return "claim_voucher_detail";
	}
}
