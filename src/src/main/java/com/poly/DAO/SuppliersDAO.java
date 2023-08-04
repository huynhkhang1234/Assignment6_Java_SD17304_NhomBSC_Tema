package com.poly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.Entities.Suppliers;

public interface SuppliersDAO extends JpaRepository<Suppliers, Integer> {

}
