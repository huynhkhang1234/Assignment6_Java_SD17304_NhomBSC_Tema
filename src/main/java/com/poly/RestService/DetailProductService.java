package com.poly.RestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.DAO.GalleriesDAO;
import com.poly.Entities.Galleries;
import com.poly.Entities.Products;

@Service
public class DetailProductService {
	@Autowired
	GalleriesDAO dao;
	@GetMapping("rest/galleries/images")
	public List<Galleries> getAllImg(Products id){
		return dao.findByImages(id);
	}
}
