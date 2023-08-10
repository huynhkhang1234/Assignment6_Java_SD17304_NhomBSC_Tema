package com.poly.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.Entities.Products;
import com.poly.RestService.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product")
public class RestProductController {
	@Autowired
	ProductService service;

	@GetMapping("/{id}")
	public Optional<Products> getOne(@PathVariable("id") Integer id) {
		return service.findByProduct(id);
	}

	@GetMapping("/all")
	public List<Products> getProducts() {
		return service.getAll();
	}
}
