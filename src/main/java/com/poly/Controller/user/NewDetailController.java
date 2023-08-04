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

@Controller
public class NewDetailController {
	

	@Autowired
	NewsDAO dao;
		
	@GetMapping("/user/news/details/{id}")
	public String view(Model model, @PathVariable Integer id) {
		News n = dao.getById(id);
		System.out.println(n.getContents());
		model.addAttribute("news", n);
		//loc het l
		List<News> listNew =  dao.findAllActiveTrue();	
		model.addAttribute("listNew", listNew);
		return "/user/news-detail";
	}


	

}
