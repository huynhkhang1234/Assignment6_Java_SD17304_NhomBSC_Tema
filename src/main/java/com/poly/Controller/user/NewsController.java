package com.poly.Controller.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.DAO.NewsDAO;
import com.poly.Entities.Categories_news;
import com.poly.Entities.News;
import com.poly.service.B64Session;
import com.poly.DAO.NewsDAO;
import com.poly.Entities.Categories_news;
import com.poly.Entities.News;

@Controller
public class NewsController {
	@Autowired
	NewsDAO dao;
	
	@Autowired
	B64Session b64s;
	
	@GetMapping("/user/news")
	public String view(Model model) {
		News entity = new News();
		model.addAttribute("news", entity);


		List<News> list = dao.findAllActiveTrue();

		model.addAttribute("list", list);
		model.addAttribute("userLogin", b64s.getUserLogin());
	
		return "user/news";
	}
	
	/*
	 * @GetMapping("/user/news/detail/{id}") public String detail(Model
	 * m, @PathVariable("id") Integer id) { News entity = new News();
	 * 
	 * entity = dao.getOne(id);
	 * 
	 * m.addAttribute("news", entity);
	 * 
	 * List<News> list = dao.findAllActiveTrue(); m.addAttribute("list", list);
	 * return "user/news-detail"; }
	 */
}
