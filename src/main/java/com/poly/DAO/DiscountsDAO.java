package com.poly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.Entities.Discounts;

public interface DiscountsDAO  extends JpaRepository<Discounts, Integer> {

		@Query("SELECT d FROM Discounts d WHERE d.id = ?1")
		Discounts findByIdNew(Integer id);
}
