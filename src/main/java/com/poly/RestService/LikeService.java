package com.poly.RestService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.LikesDAO;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.Likes;
import com.poly.Entities.Users;
import com.poly.service.B64Session;

@Service
public class LikeService {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	@Autowired
	LikesDAO dao;
	@Autowired
	B64Session b64s;
	@Autowired
	UsersDAO usDAO;
	public List<Likes> getAll() {
		Users us = usDAO.findByEmail(b64s.getemail());	
		return dao.findAllByUserId(us.getId());
	}

}
