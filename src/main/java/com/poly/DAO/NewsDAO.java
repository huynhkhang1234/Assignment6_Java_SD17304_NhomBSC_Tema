package com.poly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.Entities.News;

public interface NewsDAO extends JpaRepository<News, Integer>  {
	
	@Query("SELECT n FROM News n WHERE n.is_active =1")
	List<News> findAllActiveTrue();
}
