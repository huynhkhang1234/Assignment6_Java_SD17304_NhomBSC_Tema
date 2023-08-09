package com.poly.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.Entities.Orders;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {
	
	@Query("SELECT o FROM Orders o WHERE o.id = :id")
	Orders findAllByOrderID(@Param("id") int id);
	
	@Query(value="select  top 1 o.id,u.id,o.create_date from users u join orders o\r\n"
	 	+ "	on u.id = o.users_id\r\n"
	 	+ "	where u.id =1\r\n"
	 	+ "	group by o.id,u.id,o.create_date\r\n"
	 	+ "	order by o.create_date desc",nativeQuery = true)
	Integer finByOrder(int id);
	
	@Query("SELECT o FROM Orders o WHERE o.create_date BETWEEN ?1 AND ?2")
	List<Orders> findByCreateDateBetween(java.sql.Date startDate, java.sql.Date endDate);
	
	@Query("SELECT o FROM Orders o WHERE o.users.id = ?1 AND o.is_active = 1")
	List<Orders> findAllByUserIDAndIsActiveTrue(Integer id);
	
}
