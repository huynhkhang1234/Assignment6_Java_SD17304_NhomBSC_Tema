package com.poly.Controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.service.B64Session;

@Controller
public class HomepageController {
	
	@Autowired
	HttpSession session;
	@Autowired
	B64Session b64s;
	
	@GetMapping("/user/index")
	public String view(Model m ) {
		m.addAttribute("username", b64s.getUserName());			
		
		return "user/index";
	}
}
