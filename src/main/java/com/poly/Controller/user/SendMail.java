package com.poly.Controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.DAO.UsersDAO;
import com.poly.utils.MailerService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SendMail {
	@Autowired
	HttpServletRequest req;
	@Autowired
	JavaMailSender sender;
	@Autowired
	MailerService mailer;
	
	@Autowired
	UsersDAO uDAO;

	@Autowired
	ServletContext context;

	@GetMapping("/mail/send")
	public String index() {
		return "mail/send";
	}

	
	
}
