package com.poly.RestService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.poly.DAO.OrdersDAO;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.Orders;
import com.poly.Entities.Users;
import com.poly.service.B64Session;

@Service
public class BillsService {
	@Autowired
	OrdersDAO dao;
	@Autowired
	HttpSession session;
	@Autowired
	B64Session b64s;
	@Autowired
	UsersDAO usDAO;
	Orders od = null;
	public Integer getOne() {
		 Users us = usDAO.findByEmail(b64s.getemail()); 
		 
	Orders n = dao.finByOrder();
		 od = n;
		 System.out.println(n);
		return n.getId();
	}

	public List<Object> printBill() {
		 Users us = usDAO.findByEmail(b64s.getemail()); 
		return this.dao.printBills(us,od);
	}

}
