package com.poly.Controller.user;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.DAO.ProductsDAO;
import com.poly.Entities.Products;
import com.poly.service.SessionService;

@Controller
public class SearchController {
	@Autowired
	SessionService session;
	@Autowired
	ProductsDAO dao;
	
	@PostMapping("/product/page")
	public String page(Model model, @RequestParam("keyword") Optional<String> name,
			@RequestParam("p") Optional<Integer> p) {
		
		System.out.println("Chạy vô code back");
		System.out.println(name+ "từ khóa");
		String findName;
		if (session.get("keyword") == null) {
			findName = name.orElse("");
		} else {
			findName = name.orElse(session.get("keyword"));
		}
		session.set("keyword", findName);
		Pageable pageable = (Pageable) PageRequest.of(p.orElse(0), 5);
		Page<Products> page = dao.findByNamePage("%" + findName + "%", pageable);
		System.out.println("tìm kiếm " + page.getSize());
		model.addAttribute("listproduts", page);
		return "user/shop";
	}
	
	@PostMapping("/admin/product")
	public String pageAdmin(Model model, @RequestParam("keyword") Optional<String> name,
			@RequestParam("p") Optional<Integer> p) {
		
		System.out.println("Chạy vô code của trang sản phẩm admin");
		System.out.println(name+ "từ khóa");
		String findName;
		if (session.get("keyword") == null) {
			findName = name.orElse("");
		} else {
			findName = name.orElse(session.get("keyword"));
		}
		session.set("keyword", findName);
		Pageable pageable = (Pageable) PageRequest.of(p.orElse(0), 5);
		Page<Products> page = dao.findByNamePage("%" + findName + "%", pageable);
		System.out.println("tìm kiếm " + page.getSize());
		model.addAttribute("list", page);
		return "/admin/product";
	}
}
