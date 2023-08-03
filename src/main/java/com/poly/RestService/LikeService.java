package com.poly.RestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.LikesDAO;
import com.poly.Entities.Likes;
import com.poly.Entities.Users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class LikeService {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	@Autowired
	LikesDAO dao;
	
	public List<Likes> getAll(){
		Users u = (Users) session.getAttribute("userLogin");			
		return dao.findAllByUserId(u.getId());	
	}
	
	
}
