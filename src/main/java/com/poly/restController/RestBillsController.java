package com.poly.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.RestService.BillsService;

@CrossOrigin("http://localhost:8080/user/cart/checkout")
@RestController
@RequestMapping("/rest/bills")
public class RestBillsController {
	@Autowired
	BillsService service;
	 @GetMapping() 
	public Integer getAll() {
		return service.getOne();
	}
	
	@GetMapping("/info")
	public List<Object> getInfo() {
		System.out.println(service.printBill());
		return service.printBill();
	}
}
