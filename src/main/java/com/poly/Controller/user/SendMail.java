package com.poly.Controller.user;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.DAO.UsersDAO;
import com.poly.Entities.MailModel;
import com.poly.Entities.Users;
import com.poly.utils.MailerService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

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
	public void index(Model m) {
		System.out.println("sendMailController.Index() -> " + req.getRequestURI());
		MailModel mail = new MailModel();
		m.addAttribute("mailModel", mail);
	}

	@PostMapping("/mail/send")
	public String send(Model m, @ModelAttribute("mailModel") MailModel mail) throws IOException {
		
		MimeMessage message = sender.createMimeMessage();
		
		Users u = uDAO.findByEmail(mail.getTo());
		
		if(u != null ) {
			
		mail.setFrom("hotrovienBSCTeam@gmail.com");
		mail.setBody("Thông tin tài khoản hiện tại của bạn:"+"  ==> Tên đăng nhập : " + u.getUser_names() + " ==> Mật khẩu của bạn là: " + u.getPass_words());
		try {

			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(mail.getFrom());
			helper.setSubject("Lấy lại mật khẩu");
			helper.setTo(mail.getTo());
			helper.setText(mail.getBody(), true);
			
			helper.setReplyTo(mail.getFrom());
			for (String email : mail.getCc()) {
				helper.addCc(email);
			}
			for (String email : mail.getBcc()) {
				helper.addCc(email);
			}
			for (File file : mail.getFiles()) {
				helper.addAttachment(file.getName(), file);
			}
		} catch (MessagingException | IllegalStateException ex) {
			ex.printStackTrace();
			/* m.addAttribute("message", "Gửi mail thất bại"); */
		}
		
		} else {
			System.out.println("Gmail hiện tại không hợp lệ hoặc không tồn tại trong hệ thống !!");
			m.addAttribute("message", "Gmail hiện tại không hợp lệ hoặc không tồn tại trong hệ thống !!");
			return "/mail/send";
		}
		if(mail.getTo().equals("") == false  ) {
			sender.send(message);		
			System.out.println("Gửi Gmail thành công");
			m.addAttribute("message", "Gmail đã được gửi thành công vui lòng check gmail !!");	
			mail.setTo("");	
			
		}else {
			m.addAttribute("message", "Vui lòng nhập chính xác thông tin email !!");
		}
		
		return "/mail/send";
	}


}
