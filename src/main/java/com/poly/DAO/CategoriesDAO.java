package com.poly.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.Entities.Categories;
import com.poly.Entities.Discounts;

public interface CategoriesDAO extends JpaRepository<Categories, Integer> {
	//phân trang cate
		@Query(value = "SELECT n FROM Categories n where n.is_active = 1")
		Page<Categories> getIsActive(Pageable pageable);
		
		@Query("SELECT n FROM Categories n WHERE n.is_active = 1")	
		List<Categories> findByAndIdNew();
}
