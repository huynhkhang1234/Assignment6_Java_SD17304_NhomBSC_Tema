
package com.poly.DAO;

import java.util.List;

import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.Entities.Orders;
import com.poly.Entities.Users;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {
	@Query("SELECT o FROM Orders o WHERE o.id = :id")
	Orders findByUserID(@Param("id") int id);
	
	
	 @Query(value="\r\n"
	 		+ "select top 1 *\r\n"
	 		+ "from orders\r\n"
	 		+ "order by create_date desc",nativeQuery = true)
		 		Orders finByOrder( );
	 
	 
	 @Query("SELECT o FROM Orders o WHERE o.create_date BETWEEN ?1 AND ?2")
		List<Orders> findByCreateDateBetween(java.sql.Date startDate, java.sql.Date endDate);
	// tìm kiếm để in ra bills
	 @Query(value="\r\n"
	 		+ "select  p.titles,od.quanlity,od.price,od.sum_money from products p join order_details od\r\n"
	 		+ "on p.id = od.products_id join orders o on o.id = od.orders_id\r\n"
	 		+ "where o.users_id = ?1 and o.id = ?2\r\n"
	 		+ "order by od.create_date desc",nativeQuery = true)
		List<Object> printBills(Users id,Orders od );
	 
}
