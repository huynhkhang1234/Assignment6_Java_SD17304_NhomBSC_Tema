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

	/*
	 * @PostMapping("/user/register") public String
	 * signup(@Valid @ModelAttribute("user") Users_bean model, BindingResult
	 * result,Model m) { if (result.hasErrors()) {
	 * System.out.println("Có lỗi khi đăng ký");
	 * 
	 * return "/user/register"; } else { // nếu không trùng pass2 if
	 * (model.getPass_words2().equalsIgnoreCase(model.getPass_words())) { Users us =
	 * this.userDao.findByEmail(model.getEmail().trim()); if (us != null) {
	 * session.setAttribute("registerError",
	 * "Email đã tồn vui lòng nhập lại thông tin !!");
	 * System.out.println("Email đã tồn vui lòng nhập lại thông tin !!"); } else {
	 * Users acc = new Users(); Roles roles = new Roles();
	 * acc.setUser_names(model.getUser_names().trim());
	 * acc.setFirst_names(model.getFirst_names().trim());
	 * acc.setLast_names(model.getLast_names().trim());
	 * acc.setEmail(model.getEmail().trim());
	 * acc.setPass_words(model.getPass_words().trim());
	 * acc.setAddress(model.getAddress()); acc.setPhones(model.getPhones());
	 * acc.setImages(model.getImages()); acc.setCreate_date(new
	 * Date(System.currentTimeMillis())); acc.setUpdate_date(null); roles.setId(2);
	 * roles.setRoles("user"); roles.setActions("views"); acc.setRoles(roles);
	 * acc.setIs_active(1); this.userDao.save(acc);
	 * session.removeAttribute("registerError"); return "redirect:/user/login"; }
	 * 
	 * }else { m.addAttribute("errorPass","Mật khẩu không trừng khớp ");
	 * System.out.println("Mật khẩu không trừng khớp "); return "/user/register"; }
	 * 
	 * 
	 * } return "/user/register"; }
	 */
}
