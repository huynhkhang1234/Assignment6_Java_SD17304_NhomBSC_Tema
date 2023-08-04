package com.poly.Controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.Beans.LoginBean;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.Users;
import com.poly.service.CookieService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	UsersDAO dao;
	@Autowired
	HttpSession session;
	@Autowired
	CookieService cookieService;

	@Autowired
	HttpServletRequest request;

	@GetMapping("/user/login")
	public String view(@ModelAttribute("login") LoginBean bean, Model model) {
		// lấy dữ liệu từ cookie ra mà chỉ có name nếu có
		String user = cookieService.getValue("email");
		System.out.println("login-name : " + user);
		// điền thoog tin nếu tên user có tồn tại
		if (user != null) {
			String pass = cookieService.getValue("password");
			// gán dữ liệu với value để hiện thị
			model.addAttribute("email", user);
			model.addAttribute("pass", pass);
		}
		return "user/login";
	}

	@PostMapping("user/login")
	public String isLogin(@RequestParam(name = "email") String email,
			@RequestParam(name = "pass_words") String password, @Valid @ModelAttribute("login") LoginBean bean,
			BindingResult result, RedirectAttributes redirectAttributes) {
		System.out.println(email);
		System.out.println(password);
		if (result.hasErrors()) {
			System.out.println("Có lỗi");
			return "user/login";
		} else {
			Users userLogin = this.dao.findByEmail(email);
			if (userLogin != null && userLogin.getPass_words().equals(password)) {
				System.out.println("Vai trò" + userLogin.getRoles());
				String remember = request.getParameter("remember");
				if (remember != null) {
					System.out.println(remember);
					// lưu vào cookie theo thời gian
					cookieService.add("email", email, 10);
					cookieService.add("password", password, 10);
				} else {
					// cookieService.delete("email");
					cookieService.delete("password");
				}				

				Users u = (Users) session.getAttribute("userLogin");
				System.out.println(userLogin);
				if (userLogin.getRoles().getRoles().equals("admin")
						&& (userLogin.getIs_active() == 1)) {
					session.removeAttribute("errorMessage");
					System.out.println("Đăng nhập thành công với admin");
					session.setAttribute("userLogin", userLogin);
					return "redirect:/user/index";
				} else if (userLogin.getIs_active() == 3) {
					session.setAttribute("errorMessage", "Tài khoản hiện tại của bạn đang bị khóa !!");
					return "user/login";
				} else {
					if (userLogin.getIs_active() == 0) {
						session.setAttribute("errorMessage", "Tài khoản của bạn đã bị xóa hoặc không tồn tại !!");
						
					} else {
						session.removeAttribute("errorMessage");
						System.out.println("Đăng nhập thành công với quyền user");
						session.setAttribute("userLogin", userLogin);
						return "redirect:/user/index";
					}

				}
			} else {
				session.setAttribute("errorMessage", "Email đăng nhập hoặc mật khẩu không chính xác !!");
				return "user/login";
			}
		}
		return "user/login";
	}
}
