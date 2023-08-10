package com.poly.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.Entities.Likes;


public interface LikesDAO extends JpaRepository<Likes, Integer> {
	
	 @Query("SELECT l FROM Likes l WHERE l.users.id = ?1")
	 List<Likes> findAllLikesByUserID(Integer user_id);
	
	@Query("SELECT o FROM Likes o WHERE o.users.id = :idUser AND o.is_likes = 1")
	List<Likes> findAllLikesByUserIDAndIslikeTrue(@Param("idUser") Integer idUser);
	
	@Query("SELECT o FROM Likes o WHERE o.products.id = :id AND o.users.id = :idUser")
	Likes findbyProductLike(@Param("id") Integer id,@Param("idUser") Integer idUser);
	

}
