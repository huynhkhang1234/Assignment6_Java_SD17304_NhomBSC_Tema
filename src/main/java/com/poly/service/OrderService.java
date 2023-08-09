package com.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.LikesDAO;
import com.poly.DAO.OrdersDAO;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.Likes;
import com.poly.Entities.Orders;
import com.poly.Entities.Users;

@Service
public class OrderService {
	@Autowired
    private OrdersDAO orderRepo;
	
	public List<Orders> getAllByUserID(Integer user_id) {
		List<Orders> listOrder = orderRepo.findAllByUserIDAndIsActiveTrue(user_id);
		return listOrder;
	}
    
}
