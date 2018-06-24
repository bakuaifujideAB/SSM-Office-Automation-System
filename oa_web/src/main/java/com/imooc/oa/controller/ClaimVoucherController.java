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
		return "redirect:deal";
	}

	// 进入报销单详情页面
	@RequestMapping("/detail")
	public String detail(int id, Map<String, Object> map) {
		map.put("claimVoucher", claimVoucherBiz.get(id));
		map.put("items", claimVoucherBiz.getItems(id));
		map.put("records", claimVoucherBiz.getRecords(id));
		return "claim_voucher_detail";
	}

	// 查看个人报销单页面
	@RequestMapping("/self")
	public String self(HttpSession session, Map<String, Object> map) {
		Employee employee = (Employee) session.getAttribute("employee");
		map.put("list", claimVoucherBiz.getForSelf(employee.getSn()));
		return "claim_voucher_self";
	}

	// 查看个人待处理报销单页面
	@RequestMapping("/deal")
	public String deal(HttpSession session, Map<String, Object> map) {
		Employee employee = (Employee) session.getAttribute("employee");
		map.put("list", claimVoucherBiz.getForDeal(employee.getSn()));
		return "claim_voucher_deal";
	}

	// 进入修改报销单页面
	@RequestMapping("/to_update")
	public String toUpdate(int id, Map<String, Object> map) {
		map.put("items", Contant.getItems());
		ClaimVoucherInfo info = new ClaimVoucherInfo();
		info.setClaimVoucher(claimVoucherBiz.get(id));
		info.setItems(claimVoucherBiz.getItems(id));
		map.put("info", info);
		return "claim_voucher_update";
	}

	// 进行修改报销单操作
	@RequestMapping("/update")
	public String update(HttpSession session, ClaimVoucherInfo info) {
		Employee employee = (Employee) session.getAttribute("employee");
		info.getClaimVoucher().setCreateSn(employee.getSn());
		claimVoucherBiz.update(info.getClaimVoucher(), info.getItems());
		return "redirect:deal";
	}
}
