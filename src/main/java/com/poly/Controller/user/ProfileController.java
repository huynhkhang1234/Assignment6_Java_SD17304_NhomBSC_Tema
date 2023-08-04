package com.poly.Controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.DAO.LikesDAO;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.Likes;
import com.poly.Entities.Users;

@Controller
public class ProfileController {
	@Autowired
	UsersDAO userDao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest req;
	
	@Autowired
	LikesDAO lDAO;
	
	
	@GetMapping("/user/profile/account")
	public String viewAccount( Model m,@ModelAttribute("users") Users users ) {
		
		
		Users u = (Users) session.getAttribute("userLogin");
		
		m.addAttribute("users", u);
		
		return "user/profile";
		
	}
	
	@PostMapping("/user/profile/account/{id}")
	public String viewAccountUpdate(Model m, @ModelAttribute("users") Users users, @PathVariable("id") Integer id) {
		
		String txtPassword = req.getParameter("txtPassword");
		String txtConfirmPassword = req.getParameter("txtConfirmPassword");
		
		
		Users u = (Users) session.getAttribute("userLogin");
		
		if(u.getPass_words().equals(txtPassword)) {
			System.out.println("thất bại");
			return "user/profile/account";
		}
		u.getPass_words().equals(txtPassword);
		u.setPass_words(txtConfirmPassword);
		 userDao.saveAndFlush(u);
		System.out.println("thành công");
		return "redirect:/user/profile/account";
		
		
		
		
		
		
	}
	
	
	
	@GetMapping("/user/profile/profile")
	public String viewProfile( Model m) {
		
		m.addAttribute("url", "profile");
		return "user/profile";
		
	}
	
	@GetMapping("/user/profile/favorite")
	public String viewFavorite( 
			Model m
			) {
		loadData(m);
		
		m.addAttribute("url", "favorite");
		return "user/profile";
	}
	
	@GetMapping("/user/profile/history")
	public String viewHistory( 
			Model m
			) {
		m.addAttribute("url", "history");
		return "user/profile";
	}
	
	private void loadData(Model m) {
				// Lấy tài khoản của thằng đang đăng nhập
				Users userC = (Users) session.getAttribute("userLogin");
				
				List<Likes> list = lDAO.findAllLikesByUserID(userC.getId());
				
				m.addAttribute("listLike", list);
	}
	
}
