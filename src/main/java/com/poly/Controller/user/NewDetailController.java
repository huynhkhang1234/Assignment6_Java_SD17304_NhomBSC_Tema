package com.poly.Controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.DAO.NewsDAO;
import com.poly.Entities.Categories_news;
import com.poly.Entities.News;

@Controller
public class NewDetailController {
	
	@Autowired
	NewsDAO dao;
	
	@GetMapping("/user/news/detail")
	public String view(Model model) {
		News entity = new News();
		model.addAttribute("news", entity);


		List<News> list = dao.findAllActiveTrue();

		model.addAttribute("list", list);
		return "user/news-detail";
	}
	
	
	
	@GetMapping("/admin/show/{id}")
	public String edit(Model model, @ModelAttribute("news") Optional<News> entity, @PathVariable("id") Integer id) {
//
		entity = dao.findById(id);
		model.addAttribute("news", entity);

		
		List<News> list = dao.findAllActiveTrue();
		model.addAttribute("listDe", list);
		
		return "user/news-detail";
	}
	
}
