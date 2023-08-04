package com.poly.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.Entities.Users;

public interface UsersDAO extends JpaRepository<Users, Integer> {
	@Query("SELECT u FROM Users u WHERE u.email = :email")
	Users findByEmail(@Param("email") String username);

	@Query(value = "SELECT acc FROM Users acc")
	public List<Users> getDemo();

	@Query("SELECT n FROM Users n where n.is_active = 1 or n.is_active = 3")
	List<Users> findByEquals();

	@Query("SELECT u FROM Users u WHERE u.user_names = :users")
	Users findByUsername(@Param("users") String users);
	// truy vấn tất cả 1 và 3 trả về âpge

	@Query(value = "SELECT n FROM Users n where n.is_active = 1 or n.is_active = 3")
	Page<Users> getIsActive(Pageable pageable);
	

}
