package com.poly.Controller.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.DAO.OrdersDAO;

import jakarta.servlet.http.HttpSession;

@Controller
public class BillController {
	@Autowired
	HttpSession session;
	@Autowired
	OrdersDAO dao;
	@GetMapping("/user/bill")
	public String bill() {
		return "/user/bills";
	}
	
	@PostMapping("/user/bill")
	public String removeSessionBill() {
		System.out.println("xoa session bill");
		session.removeAttribute("dataBill");
		
		return "redirect:/user/bill";
	}
	@PostMapping("/user/bill/success")
	public String Bill() {
		//Integer us = dao.findIdOrder( (Users) session.getAttribute("userLogin"));
		/*
		 * Integer order = this.dao.finByOrder(1);
		 * System.out.println("id của order là: " + order);
		 * System.out.println("không xóa session bill"); session.setAttribute("isOrder",
		 * order); session.setAttribute("dataNow", XDate.now());
		 */
		return "redirect:/user/bill";
	}
	
	@PostMapping("/user/bill/success/remove")
	public String removeSession() {
		System.out.println("xoa session bill");
		session.removeAttribute("dataBill");
		session.removeAttribute("isOrder");
		session.removeAttribute("dataNow");
		return "/user/shop";
	}
}
