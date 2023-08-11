package com.poly.Controller.user;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poly.DAO.NewsDAO;
import com.poly.Entities.Categories_news;
import com.poly.Entities.News;

@CrossOrigin("*")
@RestController
public class NewsRestController {
	@Autowired
	NewsDAO dao;
	
	@GetMapping("/api/user/news")
	public ResponseEntity<List<News>> view(Model model) {
		List<News> listNews = dao.findAllActiveTrue();
		
		return ResponseEntity.ok(listNews);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/api/user/news/detail/{id}")
	public String detail(Model m, @PathVariable("id") Integer id) {
		News entity = new News();
		
		entity = dao.getOne(id);
		
		m.addAttribute("news", entity);
		return "user/news-detail";
	}
}
