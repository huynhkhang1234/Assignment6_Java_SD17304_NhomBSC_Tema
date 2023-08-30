package com.poly.RestService;

import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.poly.DAO.UsersDAO;
import com.poly.Entities.Users;

@Service	
public class UserService implements UserDetailsService {
	@Autowired
	UsersDAO dao;

	@Autowired
	BCryptPasswordEncoder pe;
	
	@Autowired
	HttpSession session;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Users account = dao.findByEmail(username);
			// Tạo UserDetails từ Account
			String password = account.getPass_words();
			int roles = account.getRoles().getId();
			System.out.println(pe.encode(password) + "mat khẩu  mã hóa");
			this.setToken(account.getUser_names(), password,account.getImages(),username);
			return User.withUsername(username)
					.password(pe.encode(password))
					.roles(""+roles).build();									
		} catch (Exception e) {
			throw new UsernameNotFoundException(username + " not found!");
		}
		
}
	public Users getRoles(String email) {
		return  dao.findByEmail(email);
		
	}
		
	public void setToken(String username, String password,String images,String email) {
		 String authInfo = username + ":" + password + ":" + images+ ":" +email;
	        String encodedString = Base64.getEncoder().encodeToString(authInfo.getBytes());
		
		session.setAttribute("userLogin", encodedString);	
	}
	
	public Users getUser(String username) {
		if (username.contains("@")) {
			return dao.findByEmail(username);
		} else {
			return dao.findByUsername(username);
		}
	}
	
	public Users update(Users u) {
		Users user = dao.saveAndFlush(u);
		return user;
	}
		
}
