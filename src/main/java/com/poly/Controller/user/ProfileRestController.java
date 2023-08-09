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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poly.DAO.UsersDAO;
import com.poly.Entities.Users;
import com.poly.service.FavoriteService;
import com.poly.service.OrderDetailService;
import com.poly.service.OrderService;
import com.poly.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.poly.DAO.LikesDAO;
import com.poly.Entities.Likes;
import com.poly.Entities.Order_details;
import com.poly.Entities.Orders;
import com.poly.Entities.Users;

import jakarta.servlet.http.HttpSession;

@CrossOrigin("*")
@RestController
public class ProfileRestController {
	@Autowired
	UserService userSer;
	
	@Autowired
	FavoriteService favSer;
	
	@Autowired
	OrderService ordSer;
	
	@Autowired
	OrderDetailService odDeSer;
	
//	@Autowired
//	HttpSession session;
//	
//	@Autowired
//	HttpServletRequest req;
//	
//	@Autowired
//	LikesDAO lDAO;
	
	
	@GetMapping("api/account")
	public ResponseEntity<Optional<Users>> viewAccount() {
		// Set username mặc định
		String username = "Phinvhpc04124@fpt.edu.vn";
		
		Optional<Users> u = userSer.getUser(username);
		
		if (u.isPresent()) {
			return ResponseEntity.ok(u);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("api/favorite/{u_id}")
	public ResponseEntity<List<Optional<Likes>>> viewFavorites(@PathVariable("u_id") Integer u_id) {
		List<Optional<Likes>> listFav = favSer.getAllFavoriteByUser(u_id);
		
		if(!listFav.isEmpty()) {
			return ResponseEntity.ok(listFav);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("api/order/{u_id}")
	public ResponseEntity<List<Orders>> viewOrders(@PathVariable("u_id") Integer u_id) {
		List<Orders> listOrd = ordSer.getAllByUserID(u_id);
		if(!listOrd.isEmpty()) {
			return ResponseEntity.ok(listOrd);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("api/profile/order_detail/{u_id}")
	public ResponseEntity<List<Order_details>> viewOrderDetails(@PathVariable("u_id") Integer u_id) {
		List<Order_details> listOD = odDeSer.getAllByUserID(u_id);
		if(!listOD.isEmpty()) {
			return ResponseEntity.ok(listOD);
		} else {
			return ResponseEntity.notFound().build();
		}
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
