package com.poly.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.RestService.BillsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/bills")
public class RestBillsController {
	@Autowired
	BillsService service;
	@GetMapping()
	public Order getAll() {
		return service.getOne();
	}
	
	@GetMapping("/info")
	public List<Object> getInfo() {
		return service.printBill();
	}
}
