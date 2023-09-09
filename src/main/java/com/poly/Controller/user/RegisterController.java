package com.poly.Controller.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.Beans.Users_bean;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.Roles;
import com.poly.Entities.Users;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegisterController {
	@Autowired
	UsersDAO userDao;

	@Autowired
	HttpSession session;

	@GetMapping("/user/register")
	public String view(@ModelAttribute("user") Users_bean model) {
		return "user/register";
	}

	
}
