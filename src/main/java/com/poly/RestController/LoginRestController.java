package com.poly.RestController;
  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.Entities.Users;
import com.poly.RestService.UserService;
  
  @Controller public class LoginRestController {
	  @Autowired
	  UserService userService;
	  @Autowired
	  HttpSession session;
  
	  @RequestMapping("/user/login")
		public String form(){
			return "user/login";
		}
		
		@RequestMapping("/auth/login/success")
		public String success(Model model) {
			model.addAttribute("message", "Đăng nhập thành công!");
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			System.out.println(authentication + "giai tro dang nhap");			
			// Check if the user is authenticated
			if (authentication != null && authentication. isAuthenticated()) {
				Users roleNames =   userService.getRoles(authentication.getName());
				if(roleNames.getRoles().getRoles().equalsIgnoreCase("admin") ||
						roleNames.getRoles().getRoles().equalsIgnoreCase("staff_edit")
						) {
					return"redirect:/admin/index";
				}else {
					return"redirect:/user/index";		
				}
			}
			 return"redirect:/user/index";			
			
		}
		
		
		
		@RequestMapping("/auth/login/error")
		public String error(Model model){
			model.addAttribute("message", "Sai thông tin đăng nhập!");
			return "forward:/user/login";
		}
		
		@RequestMapping("/auth/logoff/success")
		public String logoff(Model model,HttpServletRequest request, HttpServletResponse response){
			model.addAttribute("message", "Đăng xuất thành công!");
			session.removeAttribute("userLogin");
			System.out.println("xoa rồi.");
			   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		        if (authentication != null) {
		            new SecurityContextLogoutHandler().logout(request, response, authentication)
		        }		     
			return "forward:/user/login";
		}

		@RequestMapping("/auth/access/denied")
		public String denied(Model model){
			model.addAttribute("message", "Bạn không có quyền truy xuất!");
			return "user/login";
		}
 }
 