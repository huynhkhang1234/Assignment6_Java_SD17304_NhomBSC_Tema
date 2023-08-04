package com.poly.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.poly.Entities.MailModel;

@Service
public class MailerService {
	@Autowired
	JavaMailSender sender;
	List<MimeMessage> queue = new ArrayList<>();

	public void push(String to, String body) throws MessagingException {
		MailModel mail = new MailModel(to, body);
		this.push(mail);
	}

	public void push(MailModel mail) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());
		helper.setText(mail.getBody(), true);
		helper.setReplyTo(mail.getFrom());
		for(String email : mail.getBcc()) {
			helper.addCc(email);
		}
		for(String email : mail.getBcc()) {
			helper.addBcc(email);
		}
		for(File file : mail.getFiles()) {
			helper.addAttachment(file.getName(), file);
		}
		queue.add(message);
	}
	public void run() {
		int success= 0, error =0;
		while (!queue.isEmpty()) {
			MimeMessage message = queue.remove(0);
			try {
				sender.send(message);
				success ++;
			} catch (Exception e) {
				error++;
				queue.add(message);
			}
		}
		System.out.printf(">>Send: %d, Error: %d\r\n", success, error);
	}
}
