package com.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.LikesDAO;
import com.poly.DAO.Order_detailsDAO;
import com.poly.DAO.OrdersDAO;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.Likes;
import com.poly.Entities.Order_details;
import com.poly.Entities.Orders;
import com.poly.Entities.Users;

@Service
public class OrderDetailService {
	@Autowired
    private Order_detailsDAO odDetailRepo;
	
	public List<Order_details> getAllByUserID(Integer user_id) {
		List<Order_details> listOrder = odDetailRepo.findByUserIdAndIsActiveTrue(user_id);
		return listOrder;
	}
    
}
