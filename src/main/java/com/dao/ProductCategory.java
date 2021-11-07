package com.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bean.Product;


public interface ProductCategory extends JpaRepository<Product, Integer> {

	@Query(value = "select p from Product p where p.category=:category")
	List<Product> findAllByCategory(@Param("category") String category);
	

}
