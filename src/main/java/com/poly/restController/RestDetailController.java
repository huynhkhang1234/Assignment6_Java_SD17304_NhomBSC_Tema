package com.poly.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.Entities.Galleries;
import com.poly.Entities.Products;
import com.poly.RestService.DetailProductService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/galleries/products")
public class RestDetailController {
	@Autowired
	DetailProductService service;
	@GetMapping("/{id}")
	public List<Galleries> getAllImages(@PathVariable("id") Products id) {
		System.out.println(service.getAllImg(id));
		return service.getAllImg(id);
	}
	
}
