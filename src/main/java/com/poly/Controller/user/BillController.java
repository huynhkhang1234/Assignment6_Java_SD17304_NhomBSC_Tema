package com.poly.Controller.user;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.DAO.OrdersDAO;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.Users;
import com.poly.service.B64Session;

@Controller
public class BillController {
	@Autowired
	HttpSession session;
	@Autowired
	OrdersDAO dao;
	@Autowired
	B64Session b64s;
	@Autowired
	UsersDAO usDAO;
	@GetMapping("/user/bill")
	public String bill(Model m) {
		Users us = usDAO.findByEmail(b64s.getemail());
		m.addAttribute("user",us);
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
