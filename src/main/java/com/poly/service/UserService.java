package com.poly.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.UsersDAO;
import com.poly.Entities.Users;

@Service
public class UserService {
	@Autowired
    private UsersDAO userRepo;
	
	public Users getUser(String username) {
		if (username.contains("@")) {
			return userRepo.findByEmail(username);
		} else {
			return userRepo.findByUsername(username);
		}
	}	
    
}
