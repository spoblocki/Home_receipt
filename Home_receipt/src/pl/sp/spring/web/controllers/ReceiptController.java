package pl.sp.spring.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.sp.spring.web.dao.Receipt;
import pl.sp.spring.web.service.ReceiptsService;

@Controller
public class ReceiptController {

	private ReceiptsService receiptsService;

	@Autowired
	public void setReceiptsService(ReceiptsService receiptsService) {
		this.receiptsService = receiptsService;
	}

	@RequestMapping("/")
	public String showHome(Model model) {

		List<Receipt> receipts = receiptsService.getCurrent();

		model.addAttribute("receipts", receipts);
		
		//sysout

		return "home";
	}

}
