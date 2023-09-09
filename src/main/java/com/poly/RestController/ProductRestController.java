package com.poly.RestController;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.Entities.Products;
import com.poly.RestService.ProductService;
import com.poly.service.B64Session;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product")
public class ProductRestController {
	@Autowired
	ProductService service;
	@Autowired
	HttpSession session;
	@Autowired
	B64Session b64s;
	@GetMapping("/{id}")
	public Optional<Products> getOne(@PathVariable("id") Integer id) {
		return service.findByProduct(id);
	}

	@GetMapping("/all")
	public List<Products> getProducts(Model m) {
		m.addAttribute("username", b64s.getUserName());	
		
		return service.getAll();
	}
}
