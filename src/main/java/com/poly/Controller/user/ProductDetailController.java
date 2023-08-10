package com.poly.Controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.DAO.GalleriesDAO;
import com.poly.DAO.ProductsDAO;
import com.poly.Entities.Galleries;
import com.poly.Entities.Products;
import com.poly.service.NumberFormatMoney;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductDetailController {

	@Autowired
	ProductsDAO productRepo;
	@Autowired
	HttpServletRequest request;

	@Autowired
	GalleriesDAO galleriesRepo;

	@Autowired
	HttpSession session;

	@GetMapping("/user/product{id}")
	public String view(Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		// tìm kiếm 1 sản phẩm
		Products ps = this.productRepo.findByProductId(id);
		model.addAttribute("productDetail", ps);

		// tìm kiếm all sản phẩm thích bên dưới
		List<Products> listProductLike = this.productRepo.findAll();
		model.addAttribute("listProductLike", listProductLike);

		// chuyển đồi tiền tệ
		model.addAttribute("productDetailPrice", NumberFormatMoney.formatMoney(ps.getPrice()));
		System.out.println(ps.getTitles());
		System.out.println("trang hiện thị sản phẩm");

		// hiện thi slide show ảnh
		List<Galleries> galleriesList = this.galleriesRepo.findByImages(ps);
		model.addAttribute("galleriesList", galleriesList);
		System.out.println("slide show :" + galleriesList);
		return "user/detail";
	}

	
	

}
