package com.poly.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poly.DAO.UsersDAO;
import com.poly.Entities.MailModel;
import com.poly.Entities.Users;
import com.poly.utils.MailerService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@SpringBootApplication
@CrossOrigin("*")
@RestController
public class SendMailRest {
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
	
	@GetMapping("api/mail/send")
	public ResponseEntity<MailModel> index(Model m) {
		System.out.println("sendMailController.Index() -> " + req.getRequestURI());
		MailModel mail = new MailModel();
		
		return ResponseEntity.ok(mail);
	}

	@PostMapping("api/mail/send")
	public ResponseEntity<MailModel> send(Model m, @RequestBody MailModel mail) throws IOException {
		MimeMessage message = sender.createMimeMessage();
		System.out.println(mail.getTo());
		Users u = uDAO.findByEmail(mail.getTo());
		
		if(u != null ) {
			
		mail.setFrom("hotrovienBSCTeam@gmail.com");
		
		mail.setBody("Thông tin tài khoản hiện tại của bạn:\r\n "+"  ==> Tên đăng nhập : " + u.getUser_names() + "==> Mật khẩu của bạn là: " + u.getPass_words());
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
			return ResponseEntity.notFound().build();
		}
		if(mail.getTo().equals("") == false  ) {
			sender.send(message);		
			System.out.println("Gửi Gmail thành công");
			m.addAttribute("message", "Gmail đã được gửi thành công vui lòng check gmail !!");	
			mail.setTo("");	
			
		}else {
			m.addAttribute("message", "Vui lòng nhập chính xác thông tin email !!");
		}
		
		return ResponseEntity.ok(mail);
	}


}
