package com.poly.RestService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.NewsDAO;
import com.poly.Entities.News;

@Service
public class NewsService {
 
	@Autowired
	NewsDAO dao;
	
	public Optional<News> findByNew(int id) {
		
		return dao.findById(id);
		
	}
	
	public List<News> getAll(){
		return dao.findAllActiveTrue();
	}
	
}
