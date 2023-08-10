package com.poly.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.Entities.Likes;
import com.poly.RestService.LikeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/like")
public class RestLikeController {
	
	 @Autowired LikeService service;
	 
	 @GetMapping("/all")
	 public List<Likes> likeAll(){ return service.getAll(); }
	 
	
	
}
