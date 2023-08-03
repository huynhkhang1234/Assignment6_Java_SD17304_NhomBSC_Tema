package com.poly.RestService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.DAO.Order_detailsDAO;
import com.poly.DAO.OrdersDAO;
import com.poly.Entities.Order_details;
import com.poly.Entities.Orders;
import com.poly.Entities.Users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class OrderService {
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	OrdersDAO dao;
	@Autowired
	Order_detailsDAO ddao;
	@PostMapping()
	public Orders create(@RequestBody JsonNode orderData) {
	
		
		System.out.println(orderData);
		ObjectMapper mapper = new ObjectMapper();
		Orders order = mapper.convertValue(orderData, Orders.class);
		  HttpSession session = request.getSession();
		Users us = (Users) session.getAttribute("userLogin");
		order.setUsers(us);		
		//dao.save(order);
		
	
		// chuyển json sang đối tượng list orderDetail.
		 TypeReference<List<Order_details>> type = new TypeReference<List<Order_details>>() {};

		 //lấy vchuyển đổi orderdetail;
		 
		  List<Order_details>details;		
		  details= mapper.convertValue(orderData.get("order_details"), type) .stream()
		  .peek(d -> d.setOrders(order)) .collect(Collectors.toList());
		  
		

	     
	// ddao.saveAll(details);
		 
		return order;
	}
		
}
