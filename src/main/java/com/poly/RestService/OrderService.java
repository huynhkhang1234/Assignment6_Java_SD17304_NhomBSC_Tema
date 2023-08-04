package com.poly.RestService;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.DAO.Order_detailsDAO;
import com.poly.DAO.OrdersDAO;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.Order_details;
import com.poly.Entities.Orders;
import com.poly.Entities.Users;
import com.poly.service.B64Session;

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
	@Autowired
	B64Session b64s;
	@Autowired
	UsersDAO usDAO;

	@PostMapping()
	public Orders create(@RequestBody JsonNode orderData) {

		System.out.println(orderData);
		ObjectMapper mapper = new ObjectMapper();
		Orders order = mapper.convertValue(orderData, Orders.class);
		Users us = usDAO.findByEmail(b64s.getemail());
		System.out.println(us);
		order.setUsers(us);
		 dao.save(order);

		// chuyển json sang đối tượng list orderDetail.
		TypeReference<List<Order_details>> type = new TypeReference<List<Order_details>>() {
		};

		// lấy vchuyển đổi orderdetail;

		List<Order_details> details;
		details = mapper.convertValue(orderData.get("order_details"), type).stream().peek(d -> d.setOrders(order))
				.collect(Collectors.toList());

		 ddao.saveAll(details);

		return order;
	}

}
