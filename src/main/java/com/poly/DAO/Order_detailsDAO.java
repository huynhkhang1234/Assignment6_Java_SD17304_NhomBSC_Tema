package com.poly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.Entities.Order_details;

public interface Order_detailsDAO  extends JpaRepository<Order_details, Integer> {
	
	@Query("select o from Order_details o where o.orders.id = ?1 AND o.is_active = 1")
	List<Order_details> findByOrderIdAndIsActiveTrue(Integer order_id);

	@Query("select o from Order_details o where o.orders.users.id = ?1 AND o.is_active = 1")
	List<Order_details> findByUserIdAndIsActiveTrue(Integer user_id);

}
