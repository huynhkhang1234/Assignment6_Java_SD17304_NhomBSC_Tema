package com.poly.Controller.user;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.poly.DAO.UsersDAO;
import com.poly.Entities.MailModel;
import com.poly.Entities.Users;
import com.poly.utils.MailerService;

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
