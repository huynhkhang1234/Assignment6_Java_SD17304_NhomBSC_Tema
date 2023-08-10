package com.poly.service;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class B64Session {
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;
	public String getUserName() {
		String encodedString = (String) session.getAttribute("userLogin");
	     if (encodedString != null) {
	         // Giải mã chuỗi Base64 để lấy thông tin tên đăng nhập
	         byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
	         String authInfo = new String(decodedBytes);
	         String[] userInfo = authInfo.split(":");
	         System.out.println(userInfo[0]);
	        return userInfo[0];
	        
	       
	     } 
	     return "";
	}
	
	public String getemail() {
		String encodedString = (String) session.getAttribute("userLogin");
	     if (encodedString != null) {
	         // Giải mã chuỗi Base64 để lấy thông tin tên đăng nhập
	         byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
	         String authInfo = new String(decodedBytes);
	         String[] userInfo = authInfo.split(":");	         
	        return userInfo[3];	        	       
	     } 
	     return "";
	}
	
	public String getImg() {
		String encodedString = (String) session.getAttribute("userLogin");
	     if (encodedString != null) {
	         // Giải mã chuỗi Base64 để lấy thông tin tên đăng nhập
	         byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
	         String authInfo = new String(decodedBytes);
	         String[] userInfo = authInfo.split(":");	         
	        return userInfo[3];	        	       
	     } 
	     return "";
	}
		
	 
}
