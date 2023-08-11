package com.poly.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Date;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poly.Beans.Users_bean;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.MailModel;
import com.poly.Entities.Roles;
import com.poly.Entities.Users;
import com.poly.dto.MailRequest;
import com.poly.dto.MailResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@CrossOrigin("*")
@RestController
public class RegisterRest {
	@Autowired
	UsersDAO userDao;
	@Autowired
	HttpServletRequest req;
	@Autowired
	JavaMailSender sender;
	@Autowired
	HttpSession session;
	@Autowired
	private Configuration config;
	
	
	@GetMapping("api/user/register")
	public ResponseEntity<Users_bean> view(@ModelAttribute("user") Users_bean model) {
		Users user = new Users();
		
		return ResponseEntity.ok(model);
	}

	@PostMapping("api/user/register")
	public ResponseEntity<Users> signup(@Valid @RequestBody Users_bean model, BindingResult result,Model m,
			MailRequest request, Map<String, Object> map) {
		Users user = new Users();
		String getMail = "";
		if (result.hasErrors()) {
			System.out.println("Có lỗi khi đăng ký");

			return ResponseEntity.notFound().build();
		} else {
			// nếu không trùng pass2
			if (model.getPass_words2().equalsIgnoreCase(model.getPass_words())) {
				Users us = this.userDao.findByEmail(model.getEmail().trim());
				if (us != null) {
					session.setAttribute("registerError", "Email đã tồn vui lòng nhập lại thông tin !!");
					System.out.println("Email đã tồn vui lòng nhập lại thông tin !!");
				} else {
					//Thành Công
					
					Users acc = new Users();
					Roles roles = new Roles();
					acc.setUser_names(model.getUser_names().trim());
					acc.setFirst_names(model.getFirst_names().trim());
					acc.setLast_names(model.getLast_names().trim());
					acc.setEmail(model.getEmail().trim());
					acc.setPass_words(model.getPass_words().trim());
					acc.setAddress(model.getAddress());
					acc.setPhones(model.getPhones());
					acc.setImages(model.getImages());
					acc.setCreate_date(new Date(System.currentTimeMillis()));
					acc.setUpdate_date(null);
					roles.setId(2);
					roles.setRoles("user");
					roles.setActions("views");
					acc.setRoles(roles);
					acc.setIs_active(1);
					this.userDao.save(acc);
					
					System.out.println("Thành công");
					MailModel mail = new MailModel();
					Users u = this.userDao.findByEmail(acc.getEmail());
					MimeMessage message = sender.createMimeMessage();
					MailResponse response = new MailResponse();
					System.out.println(acc.getEmail());
					
					
					getMail = acc.getEmail();
						
					mail.setFrom("vuongpvpc04104@fpt.edu.vn");
					
					try {

						MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
						Template t = config.getTemplate("email_template.ftl");
						String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
						helper.setFrom(mail.getFrom());
						helper.setSubject("Thư Chào Mừng");
						helper.setTo(getMail);
						helper.setText(html, true);
						
						helper.setReplyTo(mail.getFrom());
						
						
						sender.send(message);
						response.setMessage("mail send to : " + request.getTo());
						response.setStatus(Boolean.TRUE);
						
						
					} catch (MessagingException | IOException | TemplateException e) {
						response.setMessage("Mail Sending failure : "+e.getMessage());
						response.setStatus(Boolean.FALSE);
						/* m.addAttribute("message", "Gửi mail thất bại"); */
					}
					if(acc.getEmail().equals("") == false  ) {
						sender.send(message);		
						System.out.println("Gửi Gmail thành công");
						m.addAttribute("message", "Gmail đã được gửi thành công vui lòng check gmail !!");	
						mail.setTo("");	
						
					}
					
					
					session.removeAttribute("registerError");
					return ResponseEntity.ok(user);
					
					
				}

			}else {
				m.addAttribute("errorPass","Mật khẩu không trừng khớp ");
				System.out.println("Mật khẩu không trừng khớp ");
				return ResponseEntity.notFound().build();
			}

			
		}
		return ResponseEntity.ok(user);
	}
}
