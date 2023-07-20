package com.poly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.Entities.Galleries;
import com.poly.Entities.Products;

public interface GalleriesDAO extends JpaRepository<Galleries, Integer>{
	@Query("SELECT g FROM Galleries g WHERE g.products = :id")
	List<Galleries> findByImages(@Param("id") Products id);
}
