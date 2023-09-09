package com.poly.Controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.DAO.NewsDAO;
import com.poly.DAO.Order_detailsDAO;
import com.poly.DAO.OrdersDAO;
import com.poly.Entities.Categories_news;
import com.poly.Entities.News;
import com.poly.Entities.Order_details;
import com.poly.Entities.Orders;
import com.poly.service.B64Session;

@Controller
public class OrderMANController {
	@Autowired
	OrdersDAO dao;
	
	@Autowired
	Order_detailsDAO daoD;
	
	@Autowired
	B64Session b64s;
	
	@GetMapping("/admin/order")
	public String view( Model model) {
		
		Orders entity = new Orders();
		model.addAttribute("orders", entity);
		
		List<Orders> list =dao.findAll();
		model.addAttribute("list", list);
		
		// Tìm User đã đăng nhập vào trang web
		model.addAttribute("userLogin", b64s.getUserLogin());

		return "admin/order";
	}
}
