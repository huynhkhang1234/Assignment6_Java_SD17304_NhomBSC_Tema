package com.poly.Controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductInfo {
	@GetMapping("/user/product/info")
	public String info() {		
		return "user/product-info";
	}
}
