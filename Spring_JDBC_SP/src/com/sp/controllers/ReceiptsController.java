package com.sp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.dao.Receipt;
import com.sp.service.ReceiptsService;

@Controller
public class ReceiptsController {

	private ReceiptsService receiptsService;

	@Autowired
	public void setReceiptsService(ReceiptsService receiptsService) {
		this.receiptsService = receiptsService;
	}

	@RequestMapping()
	public String showHome(Model model) {
		return "home";
	}
	
	
	
	@RequestMapping("/showReceipts")
	public String showReceipts(Model model) {

		List<Receipt> receipts = receiptsService.getCurrent();

		model.addAttribute("receipts", receipts);

		return "showReceipts";
	}

	@RequestMapping("/addReceipt")
	public String addReceipts(Model model) {

	
		return "addReceipt";
	}
	
	@RequestMapping(value= "/doCreate", method = RequestMethod.POST)
	public String doCreate(Model model, Receipt receipt) {
		receiptsService.addCurrent(receipt);
		return "home";
	}

}
