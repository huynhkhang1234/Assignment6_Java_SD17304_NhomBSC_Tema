package com.poly.Controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.DAO.NewsDAO;

import com.poly.Entities.News;


import com.poly.service.NewsService;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/news/details")

public class NewDetailRestController {
	
	@Autowired
	NewsDAO dao;
	@Autowired
	NewsService service;
	/*
	 * @Autowired B64Session b64s;
	 */

	@GetMapping("/{id}")
	public Optional<News> view( @PathVariable("id") Integer id){
		return  service.findByNew(id);
	}
	
	@GetMapping("/all")
	public List<News> getNews(Model m) {
		/* m.addAttribute("username", b64s.getUserName()); */
		
		return service.getAll();
	}
}
	

