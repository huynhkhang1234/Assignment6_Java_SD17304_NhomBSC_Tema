/*
 * package com.poly.Controller.user;
 * 
 * 
 * 
 * import javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.GetMapping;
 * 
 * @Controller public class LogoutController {
 * 
 * @Autowired HttpSession session;
 * 
 * @GetMapping("/user/logout") public String logout() {
 * session.removeAttribute("userLogin"); System.out.println("xóa rồi mà");
 * System.out.println(session.getAttribute("userLogin"));
 * 
 * return "user/index"; } }
 */