package com.poly.RestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.poly.DAO.OrdersDAO;
import com.poly.Entities.Users;

import jakarta.servlet.http.HttpSession;

@Service
public class BillsService {
	@Autowired
	OrdersDAO dao;
	@Autowired
	HttpSession session;
	
	public Order getOne() {
		Users us = (Users) session.getAttribute("userLogin");
		int id = us.getId();
		System.out.println(id);
		System.out.println(this.dao.finByOrder(us.getId()));
		
	return this.dao.finByOrder(us.getId());
	}
	public List<Object> printBill() {
		Users us = (Users) session.getAttribute("userLogin");
		return this.dao.printBills( us);
	}

}
