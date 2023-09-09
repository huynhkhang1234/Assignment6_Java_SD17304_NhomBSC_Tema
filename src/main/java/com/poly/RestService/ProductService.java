package com.poly.RestService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.ProductsDAO;
import com.poly.Entities.Products;
@Service
public class ProductService {
	@Autowired
	ProductsDAO dao;
	public Optional<Products> findByProduct(int id) {
		
		return dao.findById(id);
	}
	public List<Products> getAll(){
		return dao.findAllActiveTrue();
	}
}
