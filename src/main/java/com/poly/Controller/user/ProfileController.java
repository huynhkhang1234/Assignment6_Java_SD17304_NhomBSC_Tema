package com.poly.Controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.DAO.UsersDAO;
import com.poly.Entities.Users;
import com.poly.service.B64Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.DAO.LikesDAO;
import com.poly.Entities.Likes;
import com.poly.Entities.Users;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {
	
//	@Autowired
//	HttpSession session;
//	
//	@Autowired
//	HttpServletRequest req;
//	
//	@Autowired
//	LikesDAO lDAO;
	
	@Autowired
	B64Session b64s;
	
	
	@GetMapping("user/profile/account")
	public String viewAccount(Model m) {
		m.addAttribute("url", "account");
		m.addAttribute("userLogin", b64s.getUserLogin());
		return "user/profile";
	}
	
	@GetMapping("component/_header.html")
	public String viewHeader() {
		return "user/component/_header";
	}
	
	@GetMapping("component/_footer.html")
	public String viewFooter() {
		return "user/component/_footer";
	}
	
	@GetMapping("component/_header-actived.html")
	public String viewHeaderActived() {
		return "user/component/_header-actived";
	}	
	
	@GetMapping("component/_header-default.html")
	public String viewHeaderDefault() {
		return "user/component/_header-default";
	}
	
//	@PostMapping("/user/profile/account/{id}")
//	public String viewAccountUpdate(Model m, @ModelAttribute("users") Users users, @PathVariable("id") Integer id) {
//		
//		String txtPassword = req.getParameter("txtPassword");
//		String txtConfirmPassword = req.getParameter("txtConfirmPassword");
//		
//		
//		Users u = (Users) session.getAttribute("userLogin");
//		
//		if(u.getPass_words().equals(txtPassword)) {
//			System.out.println("thất bại");
//			return "user/profile/account";
//		}
//		u.getPass_words().equals(txtPassword);
//		u.setPass_words(txtConfirmPassword);
//		 userDao.saveAndFlush(u);
//		System.out.println("thành công");
//		return "redirect:/user/profile/account";	
//		
//	}
	
	
	
//	@GetMapping("/user/profile/profile")
//	public String viewProfile( Model m) {
//		
//		m.addAttribute("url", "profile");
//		return "user/profile";
//		
//	}
//	
//	@GetMapping("/user/profile/favorite")
//	public String viewFavorite( 
//			Model m
//			) {
//		loadData(m);
//		
//		m.addAttribute("url", "favorite");
//		return "user/profile";
//	}
//	
//	@GetMapping("/user/profile/history")
//	public String viewHistory( 
//			Model m
//			) {
//		m.addAttribute("url", "history");
//		return "user/profile";
//	}
//	
//	private void loadData(Model m) {
//				// Lấy tài khoản của thằng đang đăng nhập
//				Users userC = (Users) session.getAttribute("userLogin");
//				
//				List<Likes> list = lDAO.findAllLikesByUserID(userC.getId());
//				
//				m.addAttribute("listLike", list);
//	}
	
}
