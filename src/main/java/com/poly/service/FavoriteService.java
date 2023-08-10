package com.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.LikesDAO;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.Likes;
import com.poly.Entities.Users;

@Service
public class FavoriteService {
	@Autowired
    private LikesDAO likeRepo;
	
	public List<Optional<Likes>> getAllFavoriteByUser(Integer user_id) {
		List<Optional<Likes>> listFav = likeRepo.findAllLikesByUserIDAndIslikeTrue(user_id);
		return listFav;
	}
    
}
