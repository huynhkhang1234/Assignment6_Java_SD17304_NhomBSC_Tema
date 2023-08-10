package com.poly.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.Entities.Products;

public interface ProductsDAO extends JpaRepository<Products, Integer> {
	
			
	@Query("SELECT p FROM Products p WHERE p.is_active = 1")
	Page<Products> findAllActiveTrue(Pageable pageable);
	
	@Query("SELECT p FROM Products p WHERE id = :id")
	Products findByProductId(@Param("id") Integer id);
	
	//phân trang
	@Query(value = "SELECT n FROM Products n where n.is_active = 1 ORDER BY n.create_date DESC")
	Page<Products> getIsActive(Pageable pageable);

	//tìm kiếm sản phẩm
	@Query("SELECT p FROM Products p WHERE p.titles LIKE ?1 and p.is_active = 1")
	Page<Products> findByNamePage(String name, Pageable pageable);
	

}
