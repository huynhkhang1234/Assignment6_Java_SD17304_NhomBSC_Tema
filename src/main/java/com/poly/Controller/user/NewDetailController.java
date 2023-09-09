package com.poly.Controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.DAO.NewsDAO;
import com.poly.Entities.Categories_news;
import com.poly.Entities.News;
import com.poly.service.B64Session;

@Controller
public class NewDetailController {
	
	@Autowired
	NewsDAO dao;
	
	@Autowired
	B64Session b64s;
	
	@GetMapping("/user/news/details/{id}")
	public String view(Model model) {
		model.addAttribute("userLogin", b64s.getUserLogin());
		return "user/news-detail";
	}
	
	/*
	 * @GetMapping("/admin/show/{id}") public String edit(Model
	 * model, @ModelAttribute("news") News entity, @PathVariable("id") Integer id) {
	 * // // entity = dao.getOne(id); // model.addAttribute("news", entity); // //
	 * // List<News> list = dao.findAllActiveTrue(); // model.addAttribute("listDe",
	 * list);
	 * 
	 * return "user/news-detail"; }
	 */
	
}
