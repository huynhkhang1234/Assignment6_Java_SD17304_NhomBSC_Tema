package com.poly.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.Entities.Orders;
import com.poly.RestService.OrderService;

@CrossOrigin("http://localhost:8080/user/cart")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	OrderService service;
	@PostMapping()
	public Orders create(@RequestBody JsonNode orderData) {	
		System.out.println(orderData);
		return service.create(orderData);
	}	
}
